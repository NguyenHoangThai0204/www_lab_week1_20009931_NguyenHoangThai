package vn.edu.iuh.www_lab_week1.repositories;

import org.mariadb.jdbc.Connection;
import vn.edu.iuh.www_lab_week1.connection.Connect;
import vn.edu.iuh.www_lab_week1.models.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public static Connection connection;

    static {
        try {
            connection = Connect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Role> getAllRole() throws SQLException {
        String sql ="select * from role";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Role> list = new ArrayList<>();
        while (rs.next()){
            Role role = new Role(rs.getString(1), rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4));
            list.add(role);
        }
        return list;
    }
}
