package com.khaledothmane.spc.services;

import com.khaledothmane.spc.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
