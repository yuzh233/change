package me.cathub.change.common.bean.user;

/**
 * 品牌商
 */
public class BrandQuotient extends User {
    private long company_id;

    /**
     * 所属企业
     */
    private Company company;

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
        final StringBuilder sb = new StringBuilder("BrandQuotient{");
        sb.append("company_id=").append(company_id);
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
        sb.append(", role_id=").append(role_id);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
