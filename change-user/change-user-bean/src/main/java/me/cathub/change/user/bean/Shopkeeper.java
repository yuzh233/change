package me.cathub.change.user.bean;

import me.cathub.change.common.bean.User;

/**
 * B2C店主
 *
 * @author cheng
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
        sb.append('}');
        return sb.toString();
    }
}