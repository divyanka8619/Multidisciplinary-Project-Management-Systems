package com.multidisplinary.project_management.Services;

import com.multidisplinary.project_management.DTO.HRItemDTO;
import com.multidisplinary.project_management.Entities.*;
import com.multidisplinary.project_management.Repositories.HRItemRepository;
import com.multidisplinary.project_management.Repositories.StatusOfEmployeeRepository;
import com.multidisplinary.project_management.Repositories.AddTeamMembersRepository;
import com.multidisplinary.project_management.Repositories.TypeOfRatingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HRItemService {

    @Autowired
    HRItemRepository hRItemRepository;

    @Autowired
    StatusOfEmployeeRepository statusOfEmployeeRepository;

    @Autowired
    AddTeamMembersRepository addTeamMembersRepository;

    @Autowired
    TypeOfRatingsRepository typeOfRatingsRepository;

    @Transactional
    public Boolean isItemIdPresent(Integer id) {

        return hRItemRepository.findById(id).isPresent();
    }

    @Transactional
    public Item findByItemId(Integer id) {

        Optional<Item> byId = hRItemRepository.findByItemId(id);

        if(byId.isPresent()){
            return byId.get();
        } else {
            throw new RuntimeException("Could not find  project with the id: " + id);
            // todo ELSE throw exception
        }
    }

    @Transactional
    public List<Item> findByTitle(String title) {

        return hRItemRepository.findByTitle(title);
    }

    @Transactional
    public List<HRItemDTO> getAllItems() {

        List<Item> allItems = hRItemRepository.findAll();
        List<HRItemDTO> itemDTOS = new ArrayList<>();

        for (Item item :
                allItems) {
            HRItemDTO temp = new HRItemDTO();
            temp.item_Id = item.getItemId();
            temp.titles = item.getTitle();
            temp.descriptions = item.getDescription();
            temp.statusOfItems = item.getStatusOfItem().getStatusName();
            temp.typeOfItems = item.getTypeOfItem().getName();
            temp.teamMemberIds = item.getTeamMemberOfItem().getMemberId();
            temp.teamMemberOfProjectLastName = item.getTeamMemberOfItem().getLastName();
            temp.teamMemberOfProjectFirstName = item.getTeamMemberOfItem().getFirstName();
            temp.teamMemberOfProjectEmailAddress = item.getTeamMemberOfItem().getEmailAddress();
            itemDTOS.add(temp);
        }
        return itemDTOS;
    }

    @Transactional
    public Item saveNewItem(HRItemDTO hRItemDTO) {

        Optional<Status> byStatusName = statusOfEmployeeRepository.findByStatusName(hRItemDTO.statusOfItems);
        Optional<Type> byTypeName = typeOfRatingsRepository.findByName(hRItemDTO.typeOfItems);
        Optional<TeamMembers> byMemberId = addTeamMembersRepository.findByMemberId(hRItemDTO.teamMemberIds);

        TeamMembers teamMembers = null;
        if (!byMemberId.isPresent()) {

            TeamMembers newMember = new TeamMembers(hRItemDTO.teamMemberIds);
            teamMembers = addTeamMembersRepository.save(newMember);
        } else {
            teamMembers = byMemberId.get();
        }

        Status status = null;
        if (!byStatusName.isPresent()) {

            Status newStatus = new Status(hRItemDTO.statusOfItems);
            status = statusOfEmployeeRepository.save(newStatus);
        } else {

            status = byStatusName.get();
        }

        Type type = null;
        if (!byTypeName.isPresent()) {
            Type newType = new Type(hRItemDTO.typeOfItems);
            newType = typeOfRatingsRepository.save(newType);
        } else {

            type = byTypeName.get();
        }

        Item itemToBeSaved = new Item(hRItemDTO, teamMembers, status, type);
        Item savedItem = hRItemRepository.save(itemToBeSaved);
        return savedItem;
    }

    @Transactional
    public Item updateItemById(Integer id, HRItemDTO itemToBeUpdated) {

        Item item;
        Status status;
        Type type;
        TeamMembers teamMembers;

        Optional<Status> statusOptional = statusOfEmployeeRepository.findByStatusName(itemToBeUpdated.statusOfItems);

        Optional<Type> typeOptional = typeOfRatingsRepository.findByName(itemToBeUpdated.typeOfItems);

        Optional<TeamMembers> teamMembersOptional = addTeamMembersRepository.findByMemberId(itemToBeUpdated.teamMemberIds);

        Optional<Item> itemOptional = hRItemRepository.findById(id);
        if (!itemOptional.isPresent()) {

            throw new RuntimeException("Could not find item with the id: " + id);
        } else {

            item = itemOptional.get();
            status = statusOptional.get();
            type = typeOptional.get();
            teamMembers = teamMembersOptional.get();

            status.setStatusName(itemToBeUpdated.statusOfItems);
            type.setName(itemToBeUpdated.typeOfItems);
            teamMembers.setMemberId(itemToBeUpdated.teamMemberIds);

            item.setTitle(itemToBeUpdated.titles);
            item.setDescription(itemToBeUpdated.descriptions);
            item.setStatusOfItem(status);
            item.setTypeOfItem(type);
            item.setTeamMemberOfItem(teamMembers);
        }
        return hRItemRepository.save(item);
    }

    @Transactional
    public void deleteItemById(Integer id) {

        hRItemRepository.deleteById(id);
    }
}
