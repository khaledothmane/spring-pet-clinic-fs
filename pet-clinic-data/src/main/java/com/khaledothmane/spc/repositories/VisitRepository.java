package com.khaledothmane.spc.repositories;

import com.khaledothmane.spc.model.Vet;
import com.khaledothmane.spc.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
