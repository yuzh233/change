package me.cathub.change.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

public abstract class BaseControllerImpl<B extends Serializable, S extends BaseRpcServer> implements BaseCrud<B> {

    @Autowired
    S rpcService;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(B bean) throws Exception {
        return rpcService.insert(bean);
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
        return (B) rpcService.select(bean);
    }

    @RequestMapping("/list")
    @ResponseBody
    @Override
    public List<B> list(int page, int count, int tableIndex) throws Exception {
        return rpcService.list(page, count, tableIndex);
    }

    @RequestMapping("/count")
    @ResponseBody
    @Override
    public int count(int tableIndex) throws Exception {
        return rpcService.count(tableIndex);
    }

    @RequestMapping("/clear")
    @ResponseBody
    @Override
    public int clear(int tableIndex) throws Exception {
        return rpcService.clear(tableIndex);
    }
}
