package com.CRUD.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java
 * Includes all REST APU endpoint for mappings for the Animal object.
 */
@RestController
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
    public List<Animal> getAllAnimals() {return service.getAllAnimals();}

    /**
     * Get a specific Animal by an Id.
     * http://localhost:8080/animal/{id}
     *
     * @param id The unique Id for an Animal.
     * @return One Animal object
     */
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return service.getAnimalById(id);
    }

    /**
     * Add a new Animal entry.
     * http://localhost:8080/animal/add
     *
     * @param animal the new Animal object
     */
    @PostMapping("/add")
    public void addNewAnimal(@RequestBody Animal animal){
        service.addNewAnimal(animal);
    }

    /**
     * Update and existing Animal entry.
     * http://localhost:8080/animal/update/{id}
     *
     * @param id the id of the Animal being updated.
     * @param animal the Animal object being updated.
     */
    @PutMapping("/update/{id}")
    public void updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        service.updateAnimal(id, animal);
    }

    /**
     * Delete an existing Animal object.
     * http://localhost:8080/animal/delete/{id}
     *
     * @param id the id of the Animal being deleted.
     */
    @DeleteMapping("/delete/{id}")
    public void deleteAnimal(@PathVariable int id) {
        service.deleteAnimalById(id);
    }

    /**
     * Get a List of Animals of the same species.
     * http://localhost:8080/animal/species/{species}
     *
     * @param species the species of the specified animals.
     * @return A List of animals with the same species.
     */
    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return service.getAnimalBySpecies(species);
    }

    /**
     * Get a list of Animals that share the same name or part of a name.
     * http://localhost:8080/animal/search?name={String}
     *
     * @param name the Animal name or part of animal name to be searched.
     * @return A list of Animals that share the same name or part of a name.
     */
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return service.searchAnimalsByName(name);
    }
}
