package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grant_access")
public class GrantAccess {

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;



    private boolean is_grant;
    private String note;

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", account=" + account +
                ", is_grant=" + is_grant +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrantAccess)) return false;
        GrantAccess that = (GrantAccess) o;
        return Objects.equals(getRole(), that.getRole()) && Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRole(), getAccount());
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isIs_grant() {
        return is_grant;
    }

    public void setIs_grant(boolean is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess() {

    }


    public GrantAccess(Role role, Account account, boolean is_grant, String note) {
        this.role = role;
        this.account = account;
        this.is_grant = is_grant;
        this.note = note;
    }
}
