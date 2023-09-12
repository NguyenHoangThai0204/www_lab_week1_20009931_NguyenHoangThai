package vn.edu.iuh.www_lab_week1.connection;

import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connection;

    static {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        try {
            String db = "jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true";
            String user ="root";
            String pass = "20009931";
            return (Connection) DriverManager.getConnection(db,user,pass);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
