package com.khaledothmane.spc.bootstrap;

import com.khaledothmane.spc.model.*;
import com.khaledothmane.spc.services.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component // To be registered into the Spring Context
public class InitData implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public InitData(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) loadInitData();
    }

    private void loadInitData() {
        PetType snake = new PetType();
        snake.setName("Snake");
        petTypeService.save(snake);

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        System.out.println("######## PetTypes Loaded");

        Pet petSnake = new Pet();
        petSnake.setPetType(snake);
        petSnake.setName("python snake");

        Pet petDog = new Pet();
        petDog.setPetType(dog);
        petDog.setName("Donald");

        Owner owner1 = new Owner();
        owner1.setFirstName("Tyres");
        owner1.setLastName("Fury");
        owner1.setAddress("73 Levain Baker");
        owner1.setCity("New York");
        owner1.setPhone("+1 212-874-6080");
        petSnake.setOwner(owner1);
        owner1.getPets().add(petSnake);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Fair");
        owner2.setAddress("South cost - Harlem");
        owner2.setCity("New York");
        owner2.setPhone("+1 646-455-0952");
        petDog.setOwner(owner2);
        owner2.getPets().add(petDog);
        ownerService.save(owner2);

        //TODO: bidirectional mapping using builder
        Owner owner3 = Owner.builder().firstName("John").lastName("Fair").address("South cost - Harlem")
                .city("New York").phone("+1 646-455-0952").build();

        ownerService.save(owner2);

        System.out.println("######## Owners Loaded");

        Visit visitSnake = new Visit();
        visitSnake.setPet(petSnake);
        visitSnake.setDate(LocalDate.of(2018, Month.DECEMBER, 20));
        visitSnake.setDescription("Visiting my snake :)");
        visitService.save(visitSnake);

        Speciality psychiatry = new Speciality();
        psychiatry.setDescription("Psychiatry");
        specialityService.save(psychiatry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialityService.save(surgery);

        Speciality dermatology = new Speciality();
        dermatology.setDescription("Dermatology");
        specialityService.save(dermatology);


        Vet vet1 = new Vet();
        vet1.setFirstName("Franklin");
        vet1.setLastName("Olivero");
        vet1.getSpecialities().add(psychiatry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jack");
        vet2.setLastName("Newborn");
        vet2.getSpecialities().add(surgery);
        vet2.getSpecialities().add(dermatology);
        vetService.save(vet2);

        System.out.println("######## Vets Loaded");
    }
}
