package com.khaledothmane.spc.services.springdatajpa;

import com.khaledothmane.spc.model.Owner;
import com.khaledothmane.spc.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService service;

    final Long ownerId = 1l;
    static final String LAST_NAME = "Arther";
    Owner owner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(ownerRepository);
        owner = Owner.builder().id(ownerId).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(owner);
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        assertEquals(1, service.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner returnedOwner = service.findById(ownerId);
        assertNotNull(returnedOwner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        assertNotNull(service.save(owner));
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.of(owner));
        Owner arthur = service.findByLastName(LAST_NAME);
        assertNotNull(arthur);
    }
}