package me.cathub.change.common.bean.wallet;

import me.cathub.change.common.bean.user.User;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易信息
 */
public class Transaction implements Serializable {
    public static final int TYPE_YL = 1;            //
    public static final int TYPE_ZFB = 2;
    public static final int TYPE_WX = 3;

    public static final int STATUS_FAILED = -1;
    public static final int STATUS_SUCCESS = 1;

    private long id;
    private float price;        // 金额
    private String message;     // 备注
    private int type;           // 交易类型
    private int status;         // 交易状态
    private Date createDate;
    private Date updateDate;

    private long sendUser_id;
    private long receiveUser_id;

    private User sendUser;      // 给钱方
    private User receiveUser;   // 收钱方
}
