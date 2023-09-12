package vn.edu.iuh.www_lab_week1.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import vn.edu.iuh.www_lab_week1.models.Account;
import vn.edu.iuh.www_lab_week1.models.Role;
import vn.edu.iuh.www_lab_week1.repositories.AccountRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.www_lab_week1.repositories.RoleRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/login")
public class ControllerServlet extends HttpServlet {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private HttpServletRequest req;
    private HttpServletResponse resp;

    {
        try {
            accountRepository = new AccountRepository();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            roleRepository = new RoleRepository();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("nextHome")){
            try {
                logIn(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (action.equals("listAccount")) {
            try {
//                get data
                List<Account> acccountList = accountRepository.getAllAccount();
//                set data to jsp
                req.setAttribute("listAccount", acccountList);
                req.getRequestDispatcher("/listAccount.jsp")
                        .forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(action.equals("listRole")){
            try {
//                get data
                List<Role> roleList = roleRepository.getAllRole();
//                set data to jsp
                req.setAttribute("listRole", roleList);
                req.getRequestDispatcher("/listRole.jsp")
                        .forward(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private void logIn(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, SQLException, IOException {
        String e = req.getParameter("email");
        String p = req.getParameter("password");
        String link="/index.jsp";
        if (accountRepository.loginAccount(e, p).isPresent()) {
            link="/home.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(link);
        rd.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

    }
}
