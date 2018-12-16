package com.khaledothmane.spc.services.map;

import com.khaledothmane.spc.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Long id2 = 2L;
        Owner savedOwner = ownerServiceMap.save(Owner.builder().id(id2).build());
        Owner noIdOwner = ownerServiceMap.save(Owner.builder().build());
        assertEquals(id2, savedOwner.getId());
        assertNotNull(noIdOwner);
        assertNotNull(noIdOwner.getId());
    }

    @Test
    void delete() {
        Owner owner = ownerServiceMap.findById(ownerId);
        ownerServiceMap.delete(owner);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }
}