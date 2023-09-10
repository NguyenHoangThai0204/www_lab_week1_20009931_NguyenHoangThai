package vn.edu.iuh.www_lab_week1.resources;

import jakarta.servlet.annotation.WebServlet;
import vn.edu.iuh.www_lab_week1.repositories.RoleRepository;

import java.sql.SQLException;

@WebServlet(name = "role", value = "/role")
public class RoleResource {
    public static void main(String[] args) throws SQLException {
        RoleRepository roleRepository = new RoleRepository();
        roleRepository.getAllRole().forEach(System.out::println);
    }
}
