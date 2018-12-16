package com.khaledothmane.spc.services.map;

import com.khaledothmane.spc.model.Owner;
import com.khaledothmane.spc.services.OwnerService;
import com.khaledothmane.spc.services.PetService;
import com.khaledothmane.spc.services.PetTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service @Slf4j
@Profile({"default", "mapservice"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        log.error("Missing petType in Owner");
                        throw new RuntimeException("PetType is required !!!");
                    } if (pet.getId() == null) {
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(object);
        }
        return null;
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream()
                .filter(owner -> owner.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }
}
