package com.leti.server.services;

import com.leti.server.entities.Type;
import com.leti.server.repositories.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private TypesRepository typesRepository;

    @Autowired
    public TypeService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }

    public List<Type> getAll(){
        return typesRepository.findAll();
    }

    public Type addType(Type type) {
        return typesRepository.insert(type);
    }

    public boolean isTypeExists(String type) {
        return typesRepository.existsByTypeName(type);
    }
}
