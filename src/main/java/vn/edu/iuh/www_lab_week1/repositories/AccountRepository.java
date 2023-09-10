package vn.edu.iuh.www_lab_week1.repositories;

import vn.edu.iuh.www_lab_week1.connection.Connect;
import vn.edu.iuh.www_lab_week1.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    public static Connection connection;

    static {
        try {
            connection = Connect.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AccountRepository() throws Exception{

    }
    public void insert(Account account) throws SQLException {
        String sql ="insert into account values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,account.getAccount_id());
        ps.setString(2, account.getFull_name());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getEmail());
        ps.setString(5, account.getPhone());
        ps.setInt(6, account.getStatus());
        ps.executeUpdate();
    }

    public List<Account> getAllAccount() throws Exception{
        String sql="select * from account";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Account> list = new ArrayList<>();
        while (rs.next()){
            Account ac = new Account(rs.getString(1),rs.getString(2),rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getInt(6));
            list.add(ac);
        }
        return list;
    }
}
