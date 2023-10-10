package vn.app.project.dto;

import lombok.Data;


@Data
public class Reward {
    private Integer id;
    private String title;
    private String description;
    private Integer employeeId;
    
    private Employee employee;
}
