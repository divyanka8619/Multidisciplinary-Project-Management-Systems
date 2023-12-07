package com.multidisplinary.project_management.Services;

import com.multidisplinary.project_management.DTO.StatusOfEmployeeDTO;
import com.multidisplinary.project_management.Entities.Status;
import com.multidisplinary.project_management.Repositories.StatusOfEmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusOfEmployeeService {

    @Autowired
    StatusOfEmployeeRepository statusOfEmployeeRepository;

    @Transactional
    public Status getStatusByName(String statusName) {

        Optional<Status> statusByName = statusOfEmployeeRepository.findByStatusName(statusName);

        if (statusByName.isPresent()) {
            return statusByName.get();
        } else {
            throw new RuntimeException("Could not find Status with name: " + statusName);
            //todo ELSE throw exception
        }
    }

    @Transactional
    public List<StatusOfEmployeeDTO> getAllStatus() {

        List<Status> allStatus = statusOfEmployeeRepository.findAll();
        List<StatusOfEmployeeDTO> statusDTOS = new ArrayList<>();

        for (Status status : allStatus) {
            StatusOfEmployeeDTO temp = new StatusOfEmployeeDTO();
            temp.status_Id = status.getStatusId();
            temp.status_Name = status.getStatusName();
            temp.status_Of_Project = status.getStatusName();
            statusDTOS.add(temp);
        }
        return statusDTOS;
    }

    @Transactional
    public void saveNewStatus(Status statusName) {

        statusOfEmployeeRepository.save(statusName);
    }

    @Transactional
    public void deleteStatusById(Integer id) {

        statusOfEmployeeRepository.deleteById(id);
    }
}
