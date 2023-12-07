package com.multidisplinary.project_management.RestControllers;

import com.multidisplinary.project_management.DTO.HRItemDTO;
import com.multidisplinary.project_management.Entities.Item;
import com.multidisplinary.project_management.Services.HRItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HRItemController {

    @Autowired
    HRItemService hRItemService;

    public HRItemController(HRItemService hRItemService) {
        this.hRItemService = hRItemService;
    }

    @GetMapping(value = "/items", produces = "application/json")
    public ResponseEntity<List<HRItemDTO>> getAllItems() {

        List<HRItemDTO> allItemsDTO = hRItemService.getAllItems();
        return new ResponseEntity<List<HRItemDTO>>(allItemsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/item/id/{itemId}", produces = "application/json")
    public ResponseEntity<HRItemDTO> getItemById(@PathVariable Integer itemId) {

        Item itemById = hRItemService.findByItemId(itemId);
        if (itemById != null) {
            Item itemEntity = itemById;
            HRItemDTO hRItemDTO = new HRItemDTO(itemEntity);
            return new ResponseEntity<HRItemDTO>(hRItemDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No item with the id " + itemId + " was found.");
        }
    }

    @PostMapping(value = "add-new-item", consumes = "application/json")
    public ResponseEntity<Item> createItem(@RequestBody HRItemDTO hRItemDTO) {

        Item item = hRItemService.saveNewItem(hRItemDTO);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PutMapping(value = "/update-item/{itemId}", consumes = "application/json")
    public ResponseEntity<Item> updateProjectById(@PathVariable(name = "itemId") Integer itemId, @RequestBody HRItemDTO hRItemDTO) {

        Item p = hRItemService.findByItemId(itemId);
        if (p != null) {
            Item item = hRItemService.updateItemById(itemId, hRItemDTO);//todo save
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find item with the id: " + itemId);
        }
    }

    @DeleteMapping("/item/{itemId}")
    public void deleteProjectById(@PathVariable Integer itemId) {

        if (hRItemService.isItemIdPresent(itemId)) {
            hRItemService.deleteItemById(itemId);

            //TODO DO NOT THROW EXCEPTION DIRECTLY. RETURN AN EXCEPTION DTO
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No item with the id " + itemId + " was found.");
        }
    }
}
