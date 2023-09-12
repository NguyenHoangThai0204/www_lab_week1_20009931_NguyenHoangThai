package vn.edu.iuh.www_lab_week1.controllers.resources;


import vn.edu.iuh.www_lab_week1.repositories.AccountRepository;


public class AccountResource {
    public static void main(String[] args) throws Exception {
        AccountRepository ac = new AccountRepository();
        ac.getAllAccount().forEach(System.out::println);
    }

}

