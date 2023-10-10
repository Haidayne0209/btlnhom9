package vn.app.project.dao;

import vn.app.project.dto.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.app.project.dto.Employee;

public class DepartmentDAO extends AbstractDAO<Department>{

    private static DepartmentDAO instance;

    public static DepartmentDAO getInstance() {
        if (instance == null) {
            instance = new DepartmentDAO();
        }
        return instance;
    }

    private DepartmentDAO() {
    }

    @Override
    public void delete(int id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                DELETE FROM department WHERE id = ?;
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
    public Boolean add(Department item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = "INSERT INTO department(manager_id, department_name, description) VALUES (?, ?, ?);";
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, item.getManagerId());
                ps.setString(2, item.getDepartmentName());
                ps.setString(3, item.getDescription());
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
    public Boolean update(Department item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                UPDATE department
                                SET department_name = ?,
                                    description = ?
                                WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, item.getDepartmentName());
                ps.setString(2, item.getDescription());
                ps.setInt(3, item.getId());
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
    public List<Department> getAll() throws Exception {
        List<Department> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                         select d.*, e.fullName, e.position
                         from department d
                         left join employee e
                             on d.manager_id = e.id AND e.isDeleted = 0;
                         """;
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var item = new Department();
                item.setId(rs.getInt("id"));
                item.setManagerId(rs.getInt("manager_id"));
                item.setDepartmentName(rs.getString("department_name"));
                item.setDescription(rs.getString("description"));
                item.setIsDeleted(rs.getBoolean("is_deleted"));
                
                var emp = new Employee();
                emp.setId(rs.getInt("manager_id"));
                emp.setFullName(rs.getString("fullName"));
                emp.setPosition(rs.getString("position"));
                item.setEmployee(emp);
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
