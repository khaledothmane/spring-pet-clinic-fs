package com.khaledothmane.spc.bootstrap;

import com.khaledothmane.spc.model.Owner;
import com.khaledothmane.spc.model.Vet;
import com.khaledothmane.spc.services.OwnerService;
import com.khaledothmane.spc.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // To be registered into the Spring Context
public class InitData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public InitData(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Tyres");
        owner1.setLastName("Fury");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("John");
        owner2.setLastName("Fair");
        ownerService.save(owner2);

        System.out.println("######## Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Franklin");
        vet1.setLastName("Olivero");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jack");
        vet2.setLastName("Newborn");
        vetService.save(vet2);

        System.out.println("######## Vets Loaded");
    }
}
