package vn.edu.iuh.www_lab_week1;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.ApplicationPath;
import vn.edu.iuh.www_lab_week1.models.Account;
import vn.edu.iuh.www_lab_week1.repositories.AccountRepository;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
//@ApplicationPath("/api")
//public class HelloServlet extends Application {
//
//}

public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            AccountRepository ac = new AccountRepository();
            List<Account> all = ac.getAllAccount();

            request.setAttribute("allAcc", all);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/abcd");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}