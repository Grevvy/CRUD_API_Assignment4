package com.CRUD.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java
 * Includes all REST APU endpoint for mappings for the Animal object.
 */
@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animal/all
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
     * Get a specific Animal by an Id.
     * http://localhost:8080/animal/{id}
     *
     * @param id The unique Id for an Animal.
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
     * http://localhost:8080/animal/add
     *
     * @param animal the new Animal object
     */
    @PostMapping("/new")
    public String addNewAnimal(Animal animal){
        service.addNewAnimal(animal);
        return "redirect:/animal/all";
    }

    /**
     * Update an existing Animal entry.
     * http://localhost:8080/animal/update/{id}
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
     *
     * @param animal
     * @return
     */
    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animal/" + animal.getAnimalId();
    }

    /**
     * Delete an existing Animal object.
     * http://localhost:8080/animal/delete/{id}
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
     * http://localhost:8080/animal/species/{species}
     *
     * @param species the species of the specified animals.
     * @return A List of animals with the same species.
     */
    @GetMapping("")
    public String getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "mammal") String species, Model model) {
        model.addAttribute("animalList", service.getAnimalBySpecies(species));
        model.addAttribute("title", "Animal Species: " +species);
        return "animal-list";
    }

    /**
     * Get a list of Animals that share the same name or part of a name.
     * http://localhost:8080/animal/search?name={String}
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
}
