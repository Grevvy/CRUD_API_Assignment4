package com.CRUD.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnimalService {
    @Autowired AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {return animalRepository.findAll();}

    public Animal getAnimalById() {return animalRepository.findById(animalId).orElse(null);}

    public void addNewAnimal(Animal animal) { animalRepository.save(animal);}

    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());

        animalRepository.save(existing);
    }

    public void deleteAnimalById(int animalId) {animalRepository.deleteById(animalId);}

    public List<Animal> getAnimalByClass(String attribute) {animalRepository.getAnimalByClass(attribute);}
}
