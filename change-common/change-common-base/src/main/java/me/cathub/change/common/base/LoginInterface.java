package me.cathub.change.common.base;

/**
 * 登陆校验接口
 * @param <T>
 */
public interface LoginInterface<T> {
    String LOGIN = ".login";

    /**
     * 登陆
     * @throws Exception
     */
    T login(T bean) throws Exception;
}
