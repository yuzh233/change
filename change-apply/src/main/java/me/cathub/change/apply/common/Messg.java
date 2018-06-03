package me.cathub.change.apply.common;

/**
 * 返回数据模版
 *
 * @Author: YouJie
 * @Date: 2018/5/12
 * @Time: 16:01
 * </p>
 */
public class Messg {
    private Integer status; //状态吗
    private String msg; // 说明

    public Messg() {

    }
    public Messg(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
