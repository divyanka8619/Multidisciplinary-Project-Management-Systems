package com.multidisplinary.project_management.RestControllers;

import com.multidisplinary.project_management.DTO.TypeOfRatingsDTO;
import com.multidisplinary.project_management.Services.TypeOfRatingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TypeOfRatingsController {

    @Autowired
    TypeOfRatingsService typeOfRatingsService;

    public TypeOfRatingsController(TypeOfRatingsService typeOfRatingsService) {
        this.typeOfRatingsService = typeOfRatingsService;
    }

    @GetMapping(value = "/types", produces = "application/json")
    public ResponseEntity<List<TypeOfRatingsDTO>> getAllTypes() {

        List<TypeOfRatingsDTO> allTypesDTO = typeOfRatingsService.getAllTypes();
        return new ResponseEntity<List<TypeOfRatingsDTO>>(allTypesDTO, HttpStatus.OK);
    }
}
