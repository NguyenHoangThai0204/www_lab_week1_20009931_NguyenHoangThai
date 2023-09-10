package vn.edu.iuh.www_lab_week1.resources;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import vn.edu.iuh.www_lab_week1.models.Account;
import vn.edu.iuh.www_lab_week1.repositories.AccountRepository;

import java.util.List;

@WebServlet(name = "account", value = "/account")
public class AccountResource{
    public static void main(String[] args) throws Exception {
        AccountRepository ac = new AccountRepository();
        ac.getAllAccount().forEach(System.out::println);
    }
}

