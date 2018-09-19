package com.khaledothmane.spc.services;

import com.khaledothmane.spc.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
