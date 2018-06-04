package me.cathub.change.apply.common;

import java.util.List;

/**
 * @Author: z.yu
 * @Date: 2018/06/01 13:28
 * @Description: 用于封装查询产品列表的一系列参数
 */
public class QueryHelper {
    private long categoryId;
    private int page;
    private int count;
    private int next;
    private int previous;
    private int totalCount;
    private int totalPage;

    /**
     * 筛选条件：new:时间排 / sales_volume:销量排 / price:价格排 / complex:综合排
     */
    private String condition;

    /**
     * 搜索条件
     */
    private String search;

    /**
     * 封装了产品对象和产品图片对象
     */
    private List<ProductPageResult> productPageResultList;

    public List<ProductPageResult> getProductPageResultList() {
        return productPageResultList;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPrevious() {
        return previous < 1 ? 1 : previous;
    }

    public void setPrevious(int previous) {
        this.previous = page - 1;
    }

    public int getNext() {
        return next > totalCount ? totalCount : next;
    }

    public void setNext(int next) {
        this.next = page + 1;
    }

    public void setProductPageResultList(List<ProductPageResult> productPageResultList) {
        this.productPageResultList = productPageResultList;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
