package com.CRUD.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the Animal database.
 */
@Service
public class AnimalService {
    @Autowired AnimalRepository animalRepository;

    /**
     * Fetch all Animals
     *
     * @return the List of all Animals
     */
    public List<Animal> getAllAnimals() {return animalRepository.findAll();}

    /**
     * Fetch a unique Animal
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Add a new Animal object.
     *
     * @param animal the new Animal to add.
     */
    public void addNewAnimal(Animal animal) { animalRepository.save(animal);}

    /**
     * Update an existing Animal object.
     *
     * @param animalId the unique Animal id.
     * @param animal the new animal details.
     */
    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());

        animalRepository.save(existing);
    }

    /**
     * Delete a unique Animal.
     *
     * @param animalId the unique Animal id.
     */
    public void deleteAnimalById(int animalId) {animalRepository.deleteById(animalId);}

    /**
     * Fetch all Animals of the same species.
     *
     * @param species the species of the Animals.
     * @return A list of Animals that share the same species.
     */
    public List<Animal> getAnimalBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    /**
     * Fetch all Animals of the same or part of the same name.
     *
     * @param namePart the name or part of a name specified.
     * @return A list of all Animals that match the name or part of the name.
     */
    public List<Animal> searchAnimalsByName(String namePart) {
        return animalRepository.findByNameLike(namePart);
    }


}
