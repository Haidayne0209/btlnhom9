package vn.app.project.dto;

import lombok.Data;


@Data
public class Employee {
    private Integer id;
    private String fullName;
    private String address;
    private String phone;
    private String gender;
    private String position;
    private Integer departmentId;
    private Boolean isDeleted;
    
    private Department department;
}
