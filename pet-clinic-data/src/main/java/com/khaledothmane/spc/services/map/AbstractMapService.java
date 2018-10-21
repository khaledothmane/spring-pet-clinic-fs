package com.khaledothmane.spc.services.map;

import com.khaledothmane.spc.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {

        return map.get(id);
    }

    T save(T object) {
        if(object != null) {
            if (object.getId() == null) {
                object.setId(generateNextId());
            }
            map.put(object.getId(), object);

        } else {
            throw new RuntimeException("Object is null !");
        }
        return object;
    }

    void deleteById(ID id) {

        map.remove(id);
    }

    void delete(T object) {

        map.entrySet().removeIf(obj -> obj.getValue().equals(object));
    }

    private Long generateNextId() {
        Long next = null;
        try {
            next = (Long) (Collections.max(map.keySet())) + 1;
        } catch (Exception e) {
            next = 1L;
        }
        return next;
    }
}
