package me.cathub.change.common.bean.storehouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import me.cathub.change.common.tool.LongJsonSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库
 */
public class Storehouse implements Serializable {
    @JsonSerialize(using = LongJsonSerializer.class)
    private long id;
    private String name;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 仓库描述
     */
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    private int tableIndex;
    @JsonSerialize(using = LongJsonSerializer.class)
    private long storehouseCountry_id;

    /**
     * 哪个国家的仓库?
     */
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
        final StringBuilder sb = new StringBuilder("Storehouse{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", tableIndex=").append(tableIndex);
        sb.append(", storehouseCountry_id=").append(storehouseCountry_id);
        sb.append(", storehouseCountry=").append(storehouseCountry);
        sb.append('}');
        return sb.toString();
    }
}
