package me.cathub.change.wallet.bean;

import me.cathub.change.common.bean.User;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易信息
 *
 * @author cheng
 */
public class Transaction implements Serializable {
    public static final int TYPE_YL = 1;
    public static final int TYPE_ZFB = 2;
    public static final int TYPE_WX = 3;

    public static final int STATUS_FAILED = -1;
    public static final int STATUS_SUCCESS = 1;

    private long id;
    private float price;
    private String message;
    private int type;
    private int status;
    private Date createDate;
    private Date updateDate;

    private long sendUserId;
    private long receiveUserId;

    private User sendUser;
    private User receiveUser;
}
