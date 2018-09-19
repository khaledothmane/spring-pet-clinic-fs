package com.khaledothmane.spc.services;

import com.khaledothmane.spc.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
