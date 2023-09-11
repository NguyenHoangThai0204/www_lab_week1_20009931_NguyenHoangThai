package vn.edu.iuh.www_lab_week1.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import vn.edu.iuh.www_lab_week1.repositories.AccountRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "abc", value = "/abc")
public class ControllerServlet extends HttpServlet {
    @Inject
    private AccountRepository accountRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String action = req.getParameter("action");
        AccountRepository accountRepository = null;
        if (action.equals("login")){

        }
        if (action.equals("delete_account")){
            try {
                accountRepository.deleteAccount("R002");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }



}
