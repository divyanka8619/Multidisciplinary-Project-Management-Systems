package com.multidisplinary.project_management.DTO;

public class TypeOfRatingsDTO {

    public int type_Id;
    public String type_Name;

    public TypeOfRatingsDTO() {
    }

    public TypeOfRatingsDTO(int typeId, String typeName) {
        this.type_Id = typeId;
        this.type_Name = typeName;
    }

    public int getTypeId() {
        return type_Id;
    }

    public void setTypeId(int typeId) {
        this.type_Id = typeId;
    }

    public String getTypeName() {
        return type_Name;
    }

    public void setTypeName(String typeName) {
        this.type_Name = typeName;
    }

    @Override
    public String toString() {
        return "TypeDTO{" +
                "typeId=" + type_Id +
                ", typeName='" + type_Name + '\'' +
                '}';
    }
}
