package com.CRUD.Assignment4.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    public List<Animal> findBySpecies(String species);

    @Query("SELECT a FROM Animal a WHERE a.name LIKE %?1%")
    public List<Animal> findByNameLike(String namePart);


}
