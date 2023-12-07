package com.multidisplinary.project_management.EntityConverter;

import com.multidisplinary.project_management.DTO.HRItemDTO;
import com.multidisplinary.project_management.Entities.Item;

import org.springframework.stereotype.Service;

@Service
public class ItemEntityConverter implements EntityConverter<Item, HRItemDTO> {

    @Override
    public HRItemDTO convertToDTO(Item itemEntity) {

        HRItemDTO hRItemDTO = new HRItemDTO();
        hRItemDTO.item_Id = itemEntity.getItemId();
        hRItemDTO.titles = itemEntity.getTitle();
        hRItemDTO.descriptions = itemEntity.getDescription();
        hRItemDTO.statusOfItems = itemEntity.getStatusOfItem().getStatusName();
        hRItemDTO.typeOfItems = itemEntity.getTypeOfItem().getName();

        if (itemEntity.getStatusOfItem() != null && itemEntity.getTypeOfItem() != null) {

            hRItemDTO.statusOfItems = itemEntity.getStatusOfItem().getStatusName();
            hRItemDTO.typeOfItems = itemEntity.getTypeOfItem().getName();
        } else if (itemEntity.getStatusOfItem() == null){

            hRItemDTO.statusOfItems = "Undefined Status";
        } else if (itemEntity.getTypeOfItem() == null) {

            hRItemDTO.typeOfItems = "Undefined Type";
        }
        return hRItemDTO;
    }

    @Override
    public Item convertToEntity(HRItemDTO hRItemDTO) {

        Item itemEntity = new Item();

        itemEntity.setTitle(hRItemDTO.titles);
        itemEntity.setDescription(hRItemDTO.descriptions);
        return itemEntity;
    }
}
