package vn.app.project.dao;

import vn.app.project.dto.Reward;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.app.project.dto.Employee;

public class RewardDAO extends AbstractDAO<Reward> {

    private static RewardDAO instance;

    public static RewardDAO getInstance() {
        if (instance == null) {
            instance = new RewardDAO();
        }
        return instance;
    }

    private RewardDAO() {

    }

    @Override
    public Boolean add(Reward item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                INSERT INTO reward(title, description, employee_id) VALUES (?, ?, ?);
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, item.getTitle());
                ps.setString(2, item.getDescription());
                ps.setInt(3, item.getEmployeeId());
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
    public Boolean update(Reward item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                 UPDATE reward
                                 SET title = ?,
                                     description = ?
                                 WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, item.getTitle());
                ps.setString(2, item.getDescription());
                ps.setInt(3, item.getId());
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
                                DELETE FROM reward WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                cnt.close();
            }
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
    }

    @Override
    public List<Reward> getAll() throws Exception {
        List<Reward> list = new ArrayList<>();
        String sql = """
                     SELECT r.*, e.fullName, e.position
                     FROM reward r
                     LEFT JOIN employee e on e.id = r.employee_id AND e.isDeleted = 0;
                     """;
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var item = new Reward();
                item.setId(rs.getInt("id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setEmployeeId(rs.getInt("employee_id"));

                var emp = new Employee();
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
