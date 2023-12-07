package com.multidisplinary.project_management.RestControllers;

import com.multidisplinary.project_management.DTO.StatusOfEmployeeDTO;
import com.multidisplinary.project_management.Services.StatusOfEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StatusOfEmployeeController {

    @Autowired
    StatusOfEmployeeService statusOfEmployeeService;

    @GetMapping(value = "/status", produces = "application/json")
    public ResponseEntity<List<StatusOfEmployeeDTO>> getAllStatus() {

        List<StatusOfEmployeeDTO> allStatusDTO = statusOfEmployeeService.getAllStatus();
        return new ResponseEntity<List<StatusOfEmployeeDTO>>(allStatusDTO, HttpStatus.OK);
    }
}
