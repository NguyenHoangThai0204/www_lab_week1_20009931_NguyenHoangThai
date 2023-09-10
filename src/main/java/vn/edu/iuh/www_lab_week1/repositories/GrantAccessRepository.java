package vn.edu.iuh.www_lab_week1.repositories;

import org.jetbrains.annotations.NotNull;
import vn.edu.iuh.www_lab_week1.connection.Connect;
import vn.edu.iuh.www_lab_week1.models.Grant;
import vn.edu.iuh.www_lab_week1.models.GrantAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrantAccessRepository {
    public static Connection connection;

    static {
        try {
            connection = Connect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<GrantAccess> getAllGranAScc() throws SQLException {
        String sql ="select * from grant_access";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<GrantAccess> list = new ArrayList<>();
        while (rs.next()){
            GrantAccess grantAccess = new GrantAccess(rs.getString(1), rs.getString(2)
                    ,rs.getString(3),
                    Grant.valueOf(rs.getString(4)));
            list.add(grantAccess);
        }
        return list;
    }
}
