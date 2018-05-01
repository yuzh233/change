package me.cathub.change.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseControllerImpl<B extends Serializable, S extends BaseRpcServer> implements BaseDao<B> {

    @Autowired
    S rpcService;

    public S getRpcService() {
        return rpcService;
    }

    //抽象方法，删除/批量删除都在同一个方法，入参是long[],需要查询每个控制器对应的实体信息。
    public abstract boolean delete(long[] ids) throws Exception;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(B bean) throws Exception {
        return rpcService.insert(bean) != -1 ? true : false;
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


    @ModelAttribute
    public abstract void update_modelAttribute(@RequestParam(value = "id",required = false)Long id, Map<String, Object> map) throws Exception;

    @RequestMapping("/update")
    @ResponseBody
    @Override
    public boolean update(B bean) throws Exception {
        System.out.println(bean);
        return rpcService.update(bean);
    }

    @RequestMapping("/select")
    @ResponseBody
    @Override
    public B select(B bean) throws Exception {
        return (B) rpcService.select(bean, true);
    }

    @Override
    public List<B> list(int page, int count, int tableIndex) throws Exception {
        return rpcService.list(page, count, tableIndex, false); // flag:是否关联查询（true：不关联）
    }

    @RequestMapping("/count")
    @ResponseBody
    @Override
    public int count(int tableIndex) throws Exception {
        return rpcService.count(tableIndex);
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list1(int page, int count, int tableIndex) throws Exception {
        List rows = list(page, count, tableIndex);
        int total = count(tableIndex);
        return new PageResult(rows, total);
    }

    @RequestMapping("/clear")
    @ResponseBody
    @Override
    public int clear(int tableIndex) throws Exception {
        return rpcService.clear(tableIndex);
    }


    @Override
    public List<B> listByDel(int page, int count, int tableIndex) throws Exception {
        return null;
    }


    @Override
    public int countByDel(int tableIndex) throws Exception {
        return 0;
    }

}
