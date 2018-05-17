package me.cathub.change.common.bean;

/**
 * 响应数据
 *
 * @author cheng
 */
public class ResponseData {

    /**
     * 响应标识
     */
    private int code;

    /**
     * 响应数据
     */
    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseData{");
        sb.append("code=").append(code);
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
