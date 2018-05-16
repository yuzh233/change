package me.cathub.change.user.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.util.json.LongJsonSerializer;

/**
 * 品牌商
 *
 * @author cheng
 */
public class BrandQuotient extends User {

    @JsonSerialize(using = LongJsonSerializer.class)
    private long companyId;

    /**
     * 所属企业
     */
    private Company company;

    public BrandQuotient() {
    }

    public BrandQuotient(long id) {
        super(id);
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BrandQuotient{");
        sb.append("companyId=").append(companyId);
        sb.append(", company=").append(company);
        sb.append(", id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", status=").append(status);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", roleId=").append(roleId);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
