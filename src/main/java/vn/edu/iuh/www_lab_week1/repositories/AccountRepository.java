package vn.edu.iuh.www_lab_week1.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.www_lab_week1.models.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    public static Connection connection;

    public AccountRepository() throws Exception{
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/mydb?createDatabaseIfNotExist=true";
        connection = DriverManager.getConnection( url, "root", "20009931");
    }
    public void deleteAccount(String id) throws SQLException {
        String sql="delete from account where account_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();
    }

    public void updateAccount(Account account) throws SQLException {
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
    }
    public void insertAccount(Account account) throws SQLException {
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
    public Optional<Account> loginAccount(String em, String pa) throws SQLException {
        String sql ="select * from account where email=? and password=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, em);
            ps.setString(2, pa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String accid = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                int status = rs.getInt(6);
                Account account= new Account(accid, name, pass, email, phone, status);
                return Optional.of(account);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public Account getAccountById(String id) throws Exception{
        String sql="select * from account where account_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            return new Account(rs.getString(1),rs.getString(2),rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getInt(6));

        }
        return null;
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
