package vn.app.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    static final String URL_DB = "jdbc:mysql://localhost:3306/qlnsavas";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection getConnection() {
        Connection cnt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnt = DriverManager.getConnection(URL_DB, USER, PASS);
            System.out.println("Kết nối MY SQL thành công");
        } catch (Exception e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
        return cnt;
    }
}
