package com.khaledothmane.spc.repositories;

import com.khaledothmane.spc.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
