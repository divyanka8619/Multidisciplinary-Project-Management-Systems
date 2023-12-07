package com.multidisplinary.project_management.EntityConverter;

import com.multidisplinary.project_management.DTO.StatusOfEmployeeDTO;
import com.multidisplinary.project_management.Entities.Status;

import org.springframework.stereotype.Service;

@Service
public class StatusEntityConverter implements EntityConverter<Status, StatusOfEmployeeDTO> {

    @Override
    public StatusOfEmployeeDTO convertToDTO(Status statusEntity) {
        StatusOfEmployeeDTO statusOfEmployeeDTO = new StatusOfEmployeeDTO();
        statusOfEmployeeDTO.status_Name = statusEntity.getStatusName();
        statusOfEmployeeDTO.status_Id = statusEntity.getStatusId();
        return statusOfEmployeeDTO;
    }

    @Override
    public Status convertToEntity(StatusOfEmployeeDTO statusOfEmployeeDTO) {

        Status statusEntity = new Status();
        statusEntity.setStatusName(statusOfEmployeeDTO.status_Name);
        return statusEntity;
    }
}
