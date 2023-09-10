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
    public boolean deleteRole(String id) throws SQLException {
        String sql="delete from role where role_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
        return true;
    }
    public boolean updateRole(Role role) throws SQLException {
        String sql ="update role set role_name=?, " +
                "description=?, " +
                "status=? " +
                "where role_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, role.getRole_name());
        ps.setString(2, role.getDescription());
        ps.setInt(3, role.getStatus());
        ps.setString(4, role.getRole_id());
        ps.executeUpdate();
        return true;
    }
    public boolean insertRole(Role role) throws Exception{
        String sql ="insert into role values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,role.getRole_id());
        ps.setString(2, role.getRole_name());
        ps.setString(3, role.getDescription());
        ps.setInt(4, role.getStatus());
        ps.executeUpdate();
        return true;
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
