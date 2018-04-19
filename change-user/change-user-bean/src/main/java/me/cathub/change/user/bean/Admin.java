package me.cathub.change.user.bean;

/**
 * 管理员
 */
public class Admin extends User {
    public Admin() {
    }

    public Admin(long id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                ", tableIndex=" + tableIndex +
                ", role_id=" + role_id +
                ", role=" + role +
                '}';
    }
}
