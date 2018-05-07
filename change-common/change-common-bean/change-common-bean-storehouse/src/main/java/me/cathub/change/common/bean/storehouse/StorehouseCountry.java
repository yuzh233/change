package me.cathub.change.common.bean.storehouse;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库所在国家
 */
public class StorehouseCountry implements Serializable {
    private long id;
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
        return "StorehouseCountry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                '}';
    }
}
