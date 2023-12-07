package com.multidisplinary.project_management.DTO;

public class StatusOfEmployeeDTO {

    public int status_Id;
    public String status_Name;
    public String status_Of_Project;

    public StatusOfEmployeeDTO() {
    }

    public StatusOfEmployeeDTO(int statusId, String statusName, String statusOfProject) {
        this.status_Id = statusId;
        this.status_Name = statusName;
        this.status_Of_Project = statusOfProject;
    }

    public int getStatusId() {
        return status_Id;
    }

    public void setStatusId(int statusId) {
        this.status_Id = statusId;
    }

    public String getStatusName() {
        return status_Name;
    }

    public void setStatusName(String statusName) {
        this.status_Name = statusName;
    }

    public String getStatusOfProject() {
        return status_Of_Project;
    }

    public void setStatusOfProject(String statusOfProject) {
        this.status_Of_Project = statusOfProject;
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "statusId=" + status_Id +
                ", statusName='" + status_Name + '\'' +
                ", statusOfProject='" + status_Of_Project + '\'' +
                '}';
    }
}
