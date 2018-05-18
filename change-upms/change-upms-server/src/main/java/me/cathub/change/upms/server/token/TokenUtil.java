package me.cathub.change.upms.server.token;

import me.cathub.change.common.util.RedisUtil;

/**
 * Token工具类
 *
 * @author cheng
 */
public class TokenUtil {

    public static void setToken(String tokenId, TokenInfo tokenInfo) {
        RedisUtil.set(tokenId, tokenInfo);
    }

    public static TokenInfo getToken(String tokenId) {

    }

    public static void delToken(String tokenId) {

    }
}
