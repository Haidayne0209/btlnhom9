package vn.app.project.dao;

import vn.app.project.dto.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.app.project.dto.Department;

public class EmployeeDAO extends AbstractDAO<Employee> {
    
    private static EmployeeDAO instance;
    
    public static EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new EmployeeDAO();
        }
        return instance;
    }
    
    private EmployeeDAO() {
    }
    
    @Override
    public void delete(int id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                UPDATE employee
                                SET isDeleted = 1
                                WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                cnt.close();
            }
        } catch (Exception e) {
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public Boolean update(Employee emp) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                UPDATE employee
                                SET fullName = ?,
                                    address = ?,
                                    phone = ?,
                                    gender = ?,
                                    position = ?,
                                    department_id = ?
                                WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, emp.getFullName());
                ps.setString(2, emp.getAddress());
                ps.setString(3, emp.getPhone());
                ps.setString(4, emp.getGender());
                ps.setString(5, emp.getPosition());
                if (emp.getDepartmentId() != null) {
                    ps.setInt(6, emp.getDepartmentId());
                } else {
                    ps.setNull(6, java.sql.Types.INTEGER);
                }
                ps.setInt(7, emp.getId());
                ps.executeUpdate();
                cnt.close();
            }
            return true;
        } catch (Exception e) {
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    @Override
    public Boolean add(Employee emp) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = "INSERT INTO employee(fullName, address, phone, gender, position, department_id) VALUES (?,?,?,?,?,?);";
                ps = cnt.prepareStatement(sql);
                ps.setString(1, emp.getFullName());
                ps.setString(2, emp.getAddress());
                ps.setString(3, emp.getPhone());
                ps.setString(4, emp.getGender());
                ps.setString(5, emp.getPosition());
                if (emp.getDepartmentId() != null) {
                    ps.setInt(6, emp.getDepartmentId());
                } else {
                    ps.setNull(6, java.sql.Types.INTEGER);
                }
                ps.executeUpdate();
                cnt.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
    @Override
    public List<Employee> getAll() throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                            SELECT e.*, d.department_name
                         FROM employee e
                                  LEFT JOIN department d ON d.id = e.department_id
                         WHERE e.isDeleted = 0;
                         """;
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = new Employee();
                item.setId(rs.getInt("id"));
                item.setFullName(rs.getString("fullName"));
                item.setAddress(rs.getString("address"));
                item.setPhone(rs.getString("phone"));
                item.setGender(rs.getString("gender"));
                item.setPosition(rs.getString("position"));
                item.setIsDeleted(rs.getBoolean("isDeleted"));
                item.setDepartmentId(rs.getInt("department_id"));
                
                var dept = new Department();
                dept.setId(item.getDepartmentId());
                dept.setDepartmentName(rs.getString("department_name"));
                item.setDepartment(dept);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }
    
    public List<Employee> getAll(String textSearch) throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                            SELECT e.*, d.department_name
                            FROM employee e
                            LEFT JOIN department d ON e.id = d.manager_id
                            WHERE e.isDeleted = 0 AND fullName LIKE ?;
                         """;
            ps = cnt.prepareStatement(sql);
            ps.setString(1, "%" + textSearch + "%");
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = new Employee();
                item.setId(rs.getInt("id"));
                item.setFullName(rs.getString("fullName"));
                item.setAddress(rs.getString("address"));
                item.setPhone(rs.getString("phone"));
                item.setGender(rs.getString("gender"));
                item.setPosition(rs.getString("position"));
                item.setIsDeleted(rs.getBoolean("isDeleted"));
                item.setDepartmentId(rs.getInt("department_id"));
                
                var dept = new Department();
                dept.setId(item.getDepartmentId());
                dept.setDepartmentName(rs.getString("department_name"));
                item.setDepartment(dept);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }
    
    public List<Employee> getAllEmployeeNotManager() throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                            SELECT e.*, d.department_name
                            FROM employee e
                                     LEFT JOIN department d ON d.manager_id = e.id AND e.isDeleted = 0
                            WHERE d.manager_id IS NULL;
                         """;
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = new Employee();
                item.setId(rs.getInt("id"));
                item.setFullName(rs.getString("fullName"));
                item.setAddress(rs.getString("address"));
                item.setPhone(rs.getString("phone"));
                item.setGender(rs.getString("gender"));
                item.setPosition(rs.getString("position"));
                item.setIsDeleted(rs.getBoolean("isDeleted"));
                item.setDepartmentId(rs.getInt("department_id"));
                
                var dept = new Department();
                dept.setId(item.getDepartmentId());
                dept.setDepartmentName(rs.getString("department_name"));
                item.setDepartment(dept);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }
    
}
