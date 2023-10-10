package vn.app.project.dto;

import lombok.Data;


@Data
public class Department {
    private Integer id;
    private Integer managerId;
    private String departmentName;
    private String description;
    private Boolean isDeleted;
    
    private Employee employee;
}
