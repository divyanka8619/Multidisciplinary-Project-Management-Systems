package com.multidisplinary.project_management.DTO;

import com.multidisplinary.project_management.Entities.Item;

public class HRItemDTO {

    public int item_Id;
    public String titles;
    public String descriptions;
    public String statusOfItems;
    public String typeOfItems;
    public Integer teamMemberIds;

    public Integer getTeamMemberId() {
        return teamMemberIds;
    }

    public void setTeamMemberId(Integer teamMemberId) {
        this.teamMemberIds = teamMemberId;
    }

    public String teamMemberOfProjectFirstName;
    public String teamMemberOfProjectLastName;
    public String teamMemberOfProjectEmailAddress;

    public HRItemDTO() {
    }

    public HRItemDTO(Item itemEntity) {
        this.item_Id = itemEntity.getItemId();
        this.titles = itemEntity.getTitle();
        this.descriptions = itemEntity.getDescription();
        this.statusOfItems = itemEntity.getStatusOfItem().getStatusName();
        this.typeOfItems = itemEntity.getTypeOfItem().getName();
        this.teamMemberIds = itemEntity.getTeamMemberOfItem().getMemberId();
        this.teamMemberOfProjectFirstName = itemEntity.getTeamMemberOfItem().getFirstName();
        this.teamMemberOfProjectLastName = itemEntity.getTeamMemberOfItem().getLastName();
        this.teamMemberOfProjectEmailAddress = itemEntity.getTeamMemberOfItem().getEmailAddress();
    }


    public int getItemId() {
        return item_Id;
    }

    public void setItemId(int itemId) {
        this.item_Id = itemId;
    }

    public String getTitle() {
        return titles;
    }

    public void setTitle(String title) {
        this.titles = title;
    }

    public String getDescription() {
        return descriptions;
    }

    public void setDescription(String description) {
        this.descriptions = description;
    }

    public String getStatusOfItem() {
        return statusOfItems;
    }

    public void setStatusOfItem(String statusOfItem) {
        this.statusOfItems = statusOfItem;
    }

    public String getTypeOfItem() {
        return typeOfItems;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItems = typeOfItem;
    }

    public String getTeamMemberOfProjectFirstName() {
        return teamMemberOfProjectFirstName;
    }

    public void setTeamMemberOfProjectFirstName(String teamMemberOfProjectFirstName) {
        this.teamMemberOfProjectFirstName = teamMemberOfProjectFirstName;
    }

    public String getTeamMemberOfProjectLastName() {
        return teamMemberOfProjectLastName;
    }

    public void setTeamMemberOfProjectLastName(String teamMemberOfProjectLastName) {
        this.teamMemberOfProjectLastName = teamMemberOfProjectLastName;
    }

    public String getTeamMemberOfProjectEmailAddress() {
        return teamMemberOfProjectEmailAddress;
    }

    public void setTeamMemberOfProjectEmailAddress(String teamMemberOfProjectEmailAddress) {
        this.teamMemberOfProjectEmailAddress = teamMemberOfProjectEmailAddress;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + item_Id +
                ", title='" + titles + '\'' +
                ", description='" + descriptions + '\'' +
                ", statusOfItem='" + statusOfItems + '\'' +
                ", typeOfItem='" + typeOfItems + '\'' +
                ", teamMemberId=" + teamMemberIds +
                ", teamMemberOfProjectFirstName='" + teamMemberOfProjectFirstName + '\'' +
                ", teamMemberOfProjectLastName='" + teamMemberOfProjectLastName + '\'' +
                ", teamMemberOfProjectEmailAddress='" + teamMemberOfProjectEmailAddress + '\'' +
                '}';
    }
}
