package com.multidisplinary.project_management.Services;

import com.multidisplinary.project_management.DTO.TypeOfRatingsDTO;
import com.multidisplinary.project_management.Entities.Type;
import com.multidisplinary.project_management.Repositories.TypeOfRatingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOfRatingsService {

    @Autowired
    TypeOfRatingsRepository typeOfRatingsRepository;

    @Transactional
    public Optional<Type> findTypeByName(String name) {

        return typeOfRatingsRepository.findByName(name);
    }

    @Transactional
    public void saveNewType(Type type) {

        typeOfRatingsRepository.save(type);
    }

    @Transactional
    public List<TypeOfRatingsDTO> getAllTypes() {

        List<Type> allTypes = typeOfRatingsRepository.findAll();
        List<TypeOfRatingsDTO> typeDTOS = new ArrayList<>();

        for (Type type :
                allTypes) {
            TypeOfRatingsDTO temp = new TypeOfRatingsDTO();
            temp.type_Id = type.getTypeId();
            temp.type_Name = type.getName();
            typeDTOS.add(temp);
        }
        return typeDTOS;
    }

    @Transactional
    public void deleteTypeById(Integer id) {

        typeOfRatingsRepository.deleteById(id);
    }
}
