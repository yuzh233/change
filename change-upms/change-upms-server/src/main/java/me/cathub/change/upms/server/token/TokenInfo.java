package me.cathub.change.upms.server.token;

/**
 * 令牌信息
 *
 * @author cheng
 */
public class TokenInfo {

    /**
     * 用户id
     */
    private long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户类型
     */
    private int type;

    /**
     * 请求源的某应用系统标识
     */
    private String applyFlag;

    /**
     * 全局SessionId
     */
    private String globalId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getApplyFlag() {
        return applyFlag;
    }

    public void setApplyFlag(String applyFlag) {
        this.applyFlag = applyFlag;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TokenInfo{");
        sb.append("userId=").append(userId);
        sb.append(", username='").append(username).append('\'');
        sb.append(", type=").append(type);
        sb.append(", applyFlag='").append(applyFlag).append('\'');
        sb.append(", globalId='").append(globalId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
