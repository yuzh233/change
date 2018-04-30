package me.cathub.change.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

public abstract class BaseControllerImpl<B extends Serializable, S extends BaseRpcServer> implements BaseDao<B> {

    @Autowired
    S rpcService;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(B bean) throws Exception {
//        return rpcService.insert(bean) != -1 ? true : false;
        return true;
    }

    @RequestMapping("/deleteL")
    @ResponseBody
    @Override
    public boolean deleteL(B bean) throws Exception {
//        return rpcService.deleteL(bean);
        return true;
    }

    @RequestMapping("/restore")
    @ResponseBody
    @Override
    public boolean restore(B bean) throws Exception {
//        return rpcService.restore(bean);
        return true;
    }

    @RequestMapping("/deleteP")
    @ResponseBody
    @Override
    public boolean deleteP(B bean) throws Exception {
//        return rpcService.deleteP(bean);
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    @Override
    public boolean update(B bean) throws Exception {
//        return rpcService.update(bean);
        return true;
    }

    @RequestMapping("/select")
    @ResponseBody
    @Override
    public B select(B bean) throws Exception {
//        return (B) rpcService.select(bean);
        return null;
    }

//    @RequestMapping("/list")
//    @ResponseBody
    @Override
    public List<B> list(int page, int count, int tableIndex) throws Exception {
        return rpcService.list(page, count, tableIndex, false); // flag:是否关联查询（true：不关联）
    }

    @RequestMapping("/count")
    @ResponseBody
    @Override
    public int count(int tableIndex) throws Exception {
        return rpcService.count(tableIndex);
//        return 0;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list1(int page, int count, int tableIndex) throws Exception {
        List rows = list(page,count,tableIndex);
        int total = count(tableIndex);
        return new PageResult(rows,total);
    }

    @RequestMapping("/clear")
    @ResponseBody
    @Override
    public int clear(int tableIndex) throws Exception {
//        return rpcService.clear(tableIndex);
        return 0;
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
