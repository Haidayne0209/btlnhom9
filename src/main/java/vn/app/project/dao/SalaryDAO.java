package vn.app.project.dao;

import vn.app.project.dto.Employee;
import vn.app.project.dto.Salary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalaryDAO extends AbstractDAO<Salary>{

    private static SalaryDAO instance;

    public static SalaryDAO getInstance() {
        if (instance == null) {
            instance = new SalaryDAO();
        }
        return instance;
    }

    private SalaryDAO() {

    }

    @Override
    public Boolean add(Salary item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                             INSERT INTO salary(employee_id, salary_amount, salary_date, detail)
                             VALUES (?, ?, ?, ?);
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, item.getEmployeeId());
                ps.setDouble(2, item.getSalaryAmount());
                ps.setString(3, item.getSalaryDate());
                ps.setString(4, item.getDetail());
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
    public Boolean update(Salary item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                              UPDATE salary
                              SET salary_amount = ?,
                                  salary_date = ?,
                                  detail = ?
                              WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setDouble(1, item.getSalaryAmount());
                ps.setString(2, item.getSalaryDate());
                ps.setString(3, item.getDetail());
                ps.setInt(4, item.getId());
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
    public void delete(int id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                DELETE FROM salary WHERE id = ?;
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
    public List<Salary> getAll() throws Exception {
        List<Salary> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                         SELECT s.*, e.fullName, e.position
                         FROM salary s
                         LEFT JOIN employee e on e.id = s.employee_id AND e.isDeleted = false;
                         """;
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var item = new Salary();
                item.setId(rs.getInt("id"));
                item.setEmployeeId(rs.getInt("employee_id"));
                item.setSalaryAmount(rs.getDouble("salary_amount"));
                item.setSalaryDate(rs.getString("salary_date"));
                item.setDetail(rs.getString("detail"));
                Employee emp = new Employee();
                emp.setId(item.getEmployeeId());
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
