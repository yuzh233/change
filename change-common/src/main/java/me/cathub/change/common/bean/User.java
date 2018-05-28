package me.cathub.change.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户账户
 *
 * @author cheng
 *
 * @see
 * # updateAuthor cheng
 * # updateInfo 用户与角色变更为多对多关系
 * # lastUpdate 2018-5-17 12:11
 */
public class User implements Serializable {

    public static final int TYPE_ADMIN = 1;
    public static final int TYPE_BRAND_QUOTIENT = 2;
    public static final int TYPE_SHOPKEEPER = 3;

    /**
     * 作用在属性或getter上，用于在序列化json时嵌入自己的代码。比如long转成String
     */
    @JsonSerialize(using = LongJsonSerializer.class)
    protected long id;

    /**
     * 用户名
     */
    protected String username;

    /**
     * 密码
     */
    protected String password;

    /**
     * 真实姓名
     */
    protected String name;

    /**
     * 手机号码
     */
    protected String phone;

    /**
     * 邮箱地址
     */
    protected String email;
    protected int type;
    protected Date createDate;
    protected Date updateDate;

    /**
     * 账户状态
     */
    protected int status;
    protected int tableIndex;

    public User() {}

    public User(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", type=").append(type);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", status=").append(status);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append('}');
        return sb.toString();
    }
}
