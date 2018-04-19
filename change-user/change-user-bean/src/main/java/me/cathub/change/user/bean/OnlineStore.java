package me.cathub.change.user.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 网店
 */
public class OnlineStore implements Serializable {
    private long id;
    private String url;
    private Date createDate;
    private Date updateDate;
    private int tableIndex;

    private long shopkeeper_id;

    private Shopkeeper shopkeeper;

    public long getShopkeeper_id() {
        return shopkeeper_id;
    }

    public void setShopkeeper_id(long shopkeeper_id) {
        this.shopkeeper_id = shopkeeper_id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Shopkeeper getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    @Override
    public String toString() {
        return "OnlineStore{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", tableIndex=" + tableIndex +
                ", shopkeeper_id=" + shopkeeper_id +
                ", shopkeeper=" + shopkeeper +
                '}';
    }
}
