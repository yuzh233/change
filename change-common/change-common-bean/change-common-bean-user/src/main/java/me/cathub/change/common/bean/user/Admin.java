package me.cathub.change.common.bean.user;

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
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", tableIndex=" + tableIndex +
                ", role_id=" + role_id +
                ", role=" + role +
                '}';
    }
}
