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
    public boolean deleteAccount(String id) throws SQLException {
        String sql="delete from account where account_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
        return true;
    }
    public boolean updateAccount(Account account) throws SQLException {
        String sql ="update account set full_name=?," +
                "password=?," +
                "email=?," +
                "phone=?," +
                "status=? " +
                "where account_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, account.getFull_name());
        ps.setString(2, account.getPassword());
        ps.setString(3, account.getEmail());
        ps.setString(4, account.getPhone());
        ps.setInt(5, account.getStatus());
        ps.setString(6, account.getAccount_id());
        ps.executeUpdate();
        return true;
    }
    public boolean insertAccount(Account account) throws SQLException {
        String sql ="insert into account values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,account.getAccount_id());
        ps.setString(2, account.getFull_name());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getEmail());
        ps.setString(5, account.getPhone());
        ps.setInt(6, account.getStatus());
        ps.executeUpdate();
        return true;
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
