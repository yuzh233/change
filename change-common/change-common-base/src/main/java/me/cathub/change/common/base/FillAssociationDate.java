package me.cathub.change.common.base;

/**
 * 填充关联数据接口
 */
public interface FillAssociationDate<T> {

    /**
     * 填充关联数据
     * @param bean
     * @return
     * @throws Exception
     */
    T fill(T bean);
}
