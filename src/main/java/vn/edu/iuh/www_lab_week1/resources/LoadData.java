package vn.edu.iuh.www_lab_week1.resources;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.www_lab_week1.models.Account;
import vn.edu.iuh.www_lab_week1.repositories.AccountRepository;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "account", value = "/account")
public class LoadData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        try {
//        Lấy data từ Repository
            AccountRepository daoAcc = new AccountRepository();
            List<Account> listAcc = daoAcc.getAllAccount();
//        set data
            req.setAttribute("loadAcc", listAcc);
            req.getRequestDispatcher("loadAcc").forward(req,resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
