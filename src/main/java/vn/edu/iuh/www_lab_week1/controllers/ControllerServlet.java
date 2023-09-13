package vn.edu.iuh.www_lab_week1.controllers;

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
//  --------------------              load data Account and Role    ------------ ----------------------------------------
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
//  -----------------------------------------  Log in ------------------------------------------------
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
//    -------------------------------- addAccount, addRole       ------------------------------------------------
    public void addAccount( HttpServletRequest req, HttpServletResponse resp ) throws Exception {
        String id = req.getParameter("idAccount");
        String name = req.getParameter("nameAcc");
        String pass = req.getParameter("passAcc");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int status = Integer.valueOf(req.getParameter("status"));
        Account acc = new Account(id, name, pass, email, phone, status);
        accountRepository.insertAccount(acc);
        loadAccount(req, resp);
    }
    public void addRole( HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("idRole");
        String name = req.getParameter("nameRole");
        String des = req.getParameter("desRole");
        int sta = Integer.valueOf(req.getParameter("statusRole"));
        Role role = new Role(id,name, des, sta);
        roleRepository.insertRole(role);
        loadRole(req, resp);
    }
//  -------------------------------    Update Account, Role       -----------------------------------------
    public void upDateAccount( HttpServletRequest req, HttpServletResponse resp ) throws Exception {
        String id = req.getParameter("idAccount");
        String name = req.getParameter("nameAcc");
        String pass = req.getParameter("passAcc");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int status = Integer.valueOf(req.getParameter("status"));
        Account acc = new Account(id, name, pass, email, phone, status);
        accountRepository.updateAccount(acc);
        loadAccount(req, resp);
    }
    public void upDateRole( HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("idRole");
        String name = req.getParameter("nameRole");
        String des = req.getParameter("desRole");
        int sta = Integer.valueOf(req.getParameter("statusRole"));
        Role role = new Role(id,name, des, sta);
        roleRepository.updateRole(role);
        loadRole(req, resp);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//  --------------------------------         print list        --------------------------------------------
        if (action.equals("listAccount")) {
            try {
                loadAccount(req, resp);
            } catch (Exception e) {
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
//  -------------------------------       add account, add role        ------------------------------------
        if(action.equals("nextLayoutAcc")){
            req.getRequestDispatcher("/showAccountAdd.jsp")
                    .forward(req,resp);
        }
        if(action.equals("nextLayoutRole")){
            req.getRequestDispatcher("/showRoleAdd.jsp")
                    .forward(req, resp);
        }
//  ------------------------------      deleteAccount, deleteRole      --------------------------------------
        if (action.equals("deleteAccount")){
            String idDe = req.getParameter("deleAccId");
            try {
                accountRepository.deleteAccount(idDe);
                loadAccount(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(action.equals("deleteRole")){
            String idDeRole = req.getParameter("deleRoleId");
            try {
                roleRepository.deleteRole(idDeRole);
                loadRole(req, resp);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
//  ------------------------------  updateAccount, updateRole     -------------------------------
        if (action.equals("nextLayoutUpdateAccount")){
            String idUpAcc = req.getParameter("upDateAccID");
            try {
                Account account = accountRepository.getAccountById(idUpAcc);
                req.setAttribute("upAcc", account);
                req.getRequestDispatcher("/showAccountUpdate.jsp")
                        .forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        if(action.equals("nextLayoutUpdateRole")){
            String idUpRole = req.getParameter("upDateRoleId");
            try {
                Role role = roleRepository.getRoleById(idUpRole);
                req.setAttribute("upRole", role);
                req.getRequestDispatcher("/showRoleUpdate.jsp")
                        .forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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
        if (action.equals("addAccount")){
            try {
                addAccount(req,resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (action.equals("addRole")){
            try {
                addRole(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(action.equals("upDateRole")){
            try {
                upDateRole(req,resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(action.equals("upDateAccount")){
            try {
                upDateAccount(req,resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
