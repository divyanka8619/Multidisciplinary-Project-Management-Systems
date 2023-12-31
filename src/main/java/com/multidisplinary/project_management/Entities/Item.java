package com.multidisplinary.project_management.Entities;

import javax.persistence.*;

import com.multidisplinary.project_management.DTO.HRItemDTO;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    Integer itemId;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    Status statusOfItem;

    @ManyToOne
    @JoinColumn(name = "type_Id")
    Type typeOfItem;


    @ManyToOne
    @JoinColumn(name = "member_id")
    TeamMembers teamMemberOfItem;

    public Item(HRItemDTO hRItemDTO, TeamMembers teamMembers, Status status, Type type) {

        this.title = hRItemDTO.titles;
        this.description = hRItemDTO.descriptions;
        this.teamMemberOfItem = teamMembers;
        this.statusOfItem = status;
        this.typeOfItem = type;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatusOfItem() {
        return statusOfItem;
    }

    public void setStatusOfItem(Status statusOfItem) {
        this.statusOfItem = statusOfItem;
    }

    public Type getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(Type typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public TeamMembers getTeamMemberOfItem() {
        return teamMemberOfItem;
    }

    public void setTeamMemberOfItem(TeamMembers teamMemberOfItem) {
        this.teamMemberOfItem = teamMemberOfItem;
    }

    public Item() {
    }

    public Item(HRItemDTO hRItemDTO) {

        this.title = hRItemDTO.titles;
        this.description = hRItemDTO.descriptions;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", statusId=" + statusOfItem +
                ", typeId=" + typeOfItem +
                '}';
    }
}
