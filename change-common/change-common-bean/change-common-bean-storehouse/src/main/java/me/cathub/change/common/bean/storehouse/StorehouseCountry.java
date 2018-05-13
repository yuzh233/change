package me.cathub.change.common.bean.storehouse;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库所在国家
 */
public class StorehouseCountry implements Serializable {
    private long id;

    /**
     * 国家名
     */
    private String name;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    public StorehouseCountry() {
    }

    public StorehouseCountry(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StorehouseCountry{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append('}');
        return sb.toString();
    }
}
