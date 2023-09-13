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
    //                get data

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
    public List<Account> loadAccount(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //                set data to jsp
        List<Account> acccountList = accountRepository.getAllAccount();
        req.setAttribute("listAccount", acccountList);
        req.getRequestDispatcher("/listAccount.jsp")
                .forward(req, resp);
        return null;
    }
    public List<Role> loadRole(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        //                get data
        List<Role> roleList = roleRepository.getAllRole();
//                set data to jsp
        req.setAttribute("listRole", roleList);
        req.getRequestDispatcher("/listRole.jsp")
                .forward(req,resp);
        return null;
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("listAccount")) {
            try {
                loadAccount(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
//                deleteAccount
        if (action.equals("deleteAccount")){
            String id = req.getParameter("deleAccId");
            try {
                accountRepository.deleteAccount(id);
                loadAccount(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
//              deleteRole
        if(action.equals("deleteRole")){
            String id = req.getParameter("deleRoleId");
            try {
                roleRepository.deleteRole(id);
                loadRole(req, resp);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        if(action.equals("listRole")){
            try {
                loadRole(req, resp);
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
        if (action.equals("nextHome")){
            try {
                logIn(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
