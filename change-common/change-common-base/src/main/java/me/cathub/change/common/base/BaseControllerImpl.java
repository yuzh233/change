package me.cathub.change.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通用的控制器抽象类
 * @param <B> Java bean type
 * @param <S> Rpc server type
 */
public abstract class BaseControllerImpl<B extends Serializable, S extends BaseRpcServer<B>> implements BaseController<B> {

    @Autowired
    protected S rpcService;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(B bean) throws Exception {
        return rpcService.insert(bean) != -1;
    }

    @RequestMapping("/deleteL")
    @ResponseBody
    @Override
    public boolean deleteL(B bean) throws Exception {
        return rpcService.deleteL(bean);
    }

    @RequestMapping("/restore")
    @ResponseBody
    @Override
    public boolean restore(B bean) throws Exception {
        return rpcService.restore(bean);
    }

    @RequestMapping("/deleteP")
    @ResponseBody
    @Override
    public boolean deleteP(B bean) throws Exception {
        return rpcService.deleteP(bean);
    }

    @RequestMapping("/update")
    @ResponseBody
    @Override
    public boolean update(B bean) throws Exception {
        return rpcService.update(bean);
    }

    @RequestMapping("/select")
    @ResponseBody
    @Override
    public B select(B bean) throws Exception {
        return rpcService.select(bean, false);
    }

    @RequestMapping("/list")
    @ResponseBody
    @Override
    public PageResult list(int page, int count, int tableIndex) throws Exception {
        PageResult result = new PageResult();

        List datas = rpcService.list(page, count, tableIndex, false);
        int total = rpcService.count(tableIndex);

        result.setRows(datas);
        result.setTotal(total);

        return result;
    }

    @RequestMapping("/count")
    @ResponseBody
    @Override
    public int count(int tableIndex) throws Exception {
        return rpcService.count(tableIndex);
    }

    @RequestMapping("/listByDel")
    @ResponseBody
    @Override
    public PageResult listByDel(int page, int count, int tableIndex) throws Exception {
        PageResult result = new PageResult();

        List datas = rpcService.listByDel(page, count, tableIndex, true);
        int total = rpcService.count(tableIndex);

        result.setRows(datas);
        result.setTotal(total);

        return result;
    }

    @RequestMapping("/countByDel")
    @ResponseBody
    @Override
    public int countByDel(int tableIndex) throws Exception {
        return rpcService.countByDel(tableIndex);
    }

    @RequestMapping("/clear")
    @ResponseBody
    @Override
    public int clear(int tableIndex) throws Exception {
        return rpcService.clear(tableIndex);
    }

    public void update_modelAttribute(Long id, Map<String, Object> map) throws Exception{}
}
