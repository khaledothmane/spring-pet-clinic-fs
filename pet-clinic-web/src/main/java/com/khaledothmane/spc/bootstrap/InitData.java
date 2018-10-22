package com.khaledothmane.spc.bootstrap;

import com.khaledothmane.spc.model.Owner;
import com.khaledothmane.spc.model.PetType;
import com.khaledothmane.spc.model.Vet;
import com.khaledothmane.spc.services.OwnerService;
import com.khaledothmane.spc.services.PetTypeService;
import com.khaledothmane.spc.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // To be registered into the Spring Context
public class InitData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public InitData(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType snake = new PetType();
        snake.setName("Snake");
        petTypeService.save(snake);

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        System.out.println("######## PetTypes Loaded");

        Owner owner1 = new Owner();
        owner1.setFirstName("Tyres");
        owner1.setLastName("Fury");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Fair");
        ownerService.save(owner2);

        System.out.println("######## Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Franklin");
        vet1.setLastName("Olivero");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jack");
        vet2.setLastName("Newborn");
        vetService.save(vet2);

        System.out.println("######## Vets Loaded");
    }
}
