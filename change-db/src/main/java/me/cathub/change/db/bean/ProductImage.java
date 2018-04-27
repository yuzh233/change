package me.cathub.change.db.bean;

public class ProductImage {
    public static final int TYPE_COVER = 1;
    public static final int TYPE_SHOW = 1;
    public static final int TYPE_INFO = 2;

    private String url;
    private int type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "url='" + url + '\'' +
                ", type=" + type +
                '}';
    }
}
