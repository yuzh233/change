package me.cathub.change.user.bean;

/**
 * B2C店主
 */
public class Shopkeeper extends User {

    public Shopkeeper() {
    }

    public Shopkeeper(long id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Shopkeeper{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                ", tableIndex=" + tableIndex +
                ", role_id=" + role_id +
                ", role=" + role +
                '}';
    }
}