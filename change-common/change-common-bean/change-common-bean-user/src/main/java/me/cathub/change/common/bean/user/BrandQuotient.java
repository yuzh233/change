package me.cathub.change.common.bean.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.tool.LongJsonSerializer;

/**
 * 品牌商
 */
public class BrandQuotient extends User {
    @JsonSerialize(using = LongJsonSerializer.class)
    private long company_id;

    private Company company;        // 企业

    public BrandQuotient() {
    }

    public BrandQuotient(long id) {
        super(id);
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "BrandQuotient{" +
                "company_id=" + company_id +
                ", company=" + company +
                ", id=" + id +
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
