package com.khaledothmane.spc.repositories;

import com.khaledothmane.spc.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Vet, Long> {
}
