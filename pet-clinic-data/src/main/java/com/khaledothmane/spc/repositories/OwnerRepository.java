package com.khaledothmane.spc.repositories;

import com.khaledothmane.spc.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);
}
