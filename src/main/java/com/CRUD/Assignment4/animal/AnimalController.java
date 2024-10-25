package com.CRUD.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java
 * Includes all MVC endpoint for mappings for the Animal object.
 */
@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService service;

    /**
     * Sends the user to all animals since nothing for /animal
     *
     * @return
     */
    @GetMapping("")
    public String showHomepage() {
        return "redirect:/animal/all";
    }

    /**
     * Get a list of all Animals in the database.
     * <a href="http://localhost:8080/animal/all">All</a>
     *
     * @return a list of all Animal objects.
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Get a specific Animal by an id.
     * <a href="http://localhost:8080/animal/2">One</a>
     *
     * @param id The unique id for an Animal.
     * @return One Animal object
     */
    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable int id, Model model) {
        model.addAttribute("animal", service.getAnimalById(id));
        model.addAttribute("title", id);
        return "animal-details";
    }

    /**
     * Add a new Animal entry.
     * <a href="http://localhost:8080/animal/new">...</a>
     *
     * @param animal the new Animal object
     */
    @PostMapping("/new")
    public String addNewAnimal(@ModelAttribute Animal animal){
        service.addNewAnimal(animal);
        return "redirect:/animal/all";
    }

    /**
     * Show the create animal form.
     *
     * @param model
     * @return
     */
    @GetMapping("/create")
    public String showCreateAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }

    /**
     * Update an existing Animal entry.
     *
     * @param id the id of the Animal being updated.
     * @param model the Animal object being updated.
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model)
    {
        model.addAttribute("animal", service.getAnimalById(id));
        return "animal-update";
    }

    /**
     *Perform the update.
     *
     * @param animal
     * @return
     */
    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.updateAnimal(animal.getAnimalId(), animal);
        return "redirect:/animal/" + animal.getAnimalId();
    }

    /**
     * Delete an existing Animal object.
     *
     * @param id the id of the Animal being deleted.
     */
    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable int id) {
        service.deleteAnimalById(id);
        return "redirect:/animal/all";
    }

    /**
     * Get a List of Animals of the same species.
     * <a href="http://localhost:8080/animal?species=mammal">...</a>
     *
     * @param species the species of the specified animals.
     * @return A List of animals with the same species.
     */
    @GetMapping("/species")
    public String getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "mammal") String species, Model model) {
        List<Animal> animals = service.getAnimalBySpecies(species);
        model.addAttribute("animalList", animals);
        model.addAttribute("title", "Animal Species: " + species);
        return "animal-list";
    }

    /**
     * Get a list of Animals that share the same name or part of a name.
     * <a href="http://localhost:8080/animal?name=bird">...</a>
     *
     * @param name the Animal name or part of animal name to be searched.
     * @return A list of Animals that share the same name or part of a name.
     */
    @GetMapping("/search")
    public String searchAnimalsByName(@RequestParam ("name")String name, Model model) {
        List<Animal> animals = service.searchAnimalsByName(name);
        model.addAttribute("animalList", animals);
        model.addAttribute("title", "Search Results for: " + name);
        return "animal-list";
    }

    /**
     * Allows the user to search by their specified criteria (i.e. name, species, habitat).
     *
     * @param searchType The type of search
     * @param searchTerm The term of search
     * @param model
     * @return
     */
    @GetMapping("/searchBy")
    public String searchAnimalsBy(@RequestParam("searchType") String searchType, @RequestParam("searchTerm") String searchTerm, Model model) {
        List<Animal> animals;

        switch (searchType) {
            case "name":
                animals = service.searchAnimalsByName(searchTerm);
                break;
            case "species":
                animals = service.getAnimalBySpecies(searchTerm);
                break;
            case "habitat":
                animals = service.searchAnimalsByHabitat(searchTerm);
                break;
            default:
                animals = service.getAllAnimals();
        }

        model.addAttribute("animalList", animals);
        model.addAttribute("title", "Search Results for " + searchType + ": " + searchTerm);
        return "animal-list";
    }

}
