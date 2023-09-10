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
@WebServlet(name = "abc", value = "/abc")
public class ControllerServlet extends HttpServlet {
    @Inject
    private AccountRepository accountRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String action = req.getParameter("action");

        if (action.equals("create_account")){
            AccountRepository accountRepository = null;
         //   accountRepository.insert(account);
        }
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        try {
            out.println("<h1>" + accountRepository.getAllAccount().get(0).getFull_name() + "</h1>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        out.println("</body></html>");
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }



}
