package vn.edu.iuh.www_lab_week1.models;

public class GrantAccess {
    private String role_id;
    private String account_id;
    private String note;

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role_id='" + role_id + '\'' +
                ", account_id='" + account_id + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getRole_id() {
        return role_id;
    }

    public GrantAccess(String role_id, String account_id, String note) {
        this.role_id = role_id;
        this.account_id = account_id;
        this.note = note;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
