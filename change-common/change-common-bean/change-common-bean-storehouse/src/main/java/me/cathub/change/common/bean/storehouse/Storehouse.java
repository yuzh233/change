package me.cathub.change.common.bean.storehouse;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库
 */
public class Storehouse implements Serializable {
    private long id;
    private String name;
    private String address;
    private String description;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long storehouseCountry_id;

    private StorehouseCountry storehouseCountry;

    public Storehouse() {
    }

    public Storehouse(long id) {
        this.id = id;
    }

    public long getStorehouseCountry_id() {
        return storehouseCountry_id;
    }

    public void setStorehouseCountry_id(long storehouseCountry_id) {
        this.storehouseCountry_id = storehouseCountry_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public StorehouseCountry getStorehouseCountry() {
        return storehouseCountry;
    }

    public void setStorehouseCountry(StorehouseCountry storehouseCountry) {
        this.storehouseCountry = storehouseCountry;
    }

    @Override
    public String toString() {
        return "Storehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                ", storehouseCountry_id=" + storehouseCountry_id +
                ", storehouseCountry=" + storehouseCountry +
                '}';
    }
}
