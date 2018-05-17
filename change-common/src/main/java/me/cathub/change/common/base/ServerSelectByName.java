package me.cathub.change.common.base;

/**
 * Server 层, 根据名称查找的接口
 *
 * @author cheng
 * <p/>
 * @param <Bean> Java bean
 */
public interface ServerSelectByName<Bean> {

    /**
     * 根据名称查找
     * @param name
     * @param tableIndex
     * @param flag
     * @return
     * @throws Exception
     */
    Bean selectByName(String name, int tableIndex, boolean flag) throws Exception;
}
