package me.cathub.change.common.bean.user;

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
        final StringBuilder sb = new StringBuilder("Shopkeeper{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", status=").append(status);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", role_id=").append(role_id);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}