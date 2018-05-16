package me.cathub.change.common.base;

/**
 * Server 层, 填充关联数据接口
 *
 * @author cheng
 * <p/>
 * @param <Bean> Java bean
 */
public interface FillAssociationDate<Bean> {

    /**
     * 填充关联数据
     * @param bean
     * @return
     * @throws Exception
     */
    Bean fill(Bean bean);
}
