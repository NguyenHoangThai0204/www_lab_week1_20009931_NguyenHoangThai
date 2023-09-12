package vn.edu.iuh.www_lab_week1.resources;

import vn.edu.iuh.www_lab_week1.repositories.GrantAccessRepository;

public class GrantAccountResource {
    public static void main(String[] args) throws Exception{
        GrantAccessRepository gh = new GrantAccessRepository();
        gh.getAllGranAScc().forEach(System.out::println);
    }
}
