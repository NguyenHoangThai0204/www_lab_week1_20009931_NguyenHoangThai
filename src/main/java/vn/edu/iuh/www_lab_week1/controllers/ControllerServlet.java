package vn.edu.iuh.www_lab_week1.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.www_lab_week1.models.Account;
import vn.edu.iuh.www_lab_week1.repositories.AccountRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;


@WebServlet("/login")
public class ControllerServlet extends HttpServlet {
    @Inject
    private AccountRepository accountRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("nextHome")) {
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else if (action.equals("listAccount")) {
            req.getRequestDispatcher("/listAccount.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String link = "";
//        try {
//            Account account = accountRepository.login(email, pass);
//            if(account != null ){
//                link = "/home.jsp";
//            }
//            else {
//                link ="/index.jsp";
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        //req.setAttribute("acc", accountRepository.getAllAccount());

    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);

    }

}
