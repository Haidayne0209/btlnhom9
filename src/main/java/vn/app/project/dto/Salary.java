
package vn.app.project.dto;

import lombok.Data;


@Data
public class Salary {
    private Integer id;
    private Integer employeeId;
    private Double salaryAmount;
    private String salaryDate;
    private String detail;
    
    private Employee employee;
}
