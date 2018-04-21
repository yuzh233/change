package me.cathub.change.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

public abstract class BaseControllerImpl<B extends Serializable, S extends BaseRpcServer> implements BaseCrud<B> {

    @Autowired
    S service;

    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public boolean insert(B bean) throws Exception {
        return service.insert(bean);
    }

    @RequestMapping("/deleteL")
    @ResponseBody
    @Override
    public boolean deleteL(B bean) throws Exception {
        return false;
    }

    @RequestMapping("/restore")
    @ResponseBody
    @Override
    public boolean restore(B bean) throws Exception {
        return false;
    }

    @RequestMapping("/deleteP")
    @ResponseBody
    @Override
    public boolean deleteP(B bean) throws Exception {
        return false;
    }

    @RequestMapping("/update")
    @ResponseBody
    @Override
    public boolean update(B bean) throws Exception {
        return false;
    }

    @RequestMapping("/select")
    @ResponseBody
    @Override
    public B select(B bean) throws Exception {
        return null;
    }

    @RequestMapping("/list")
    @ResponseBody
    @Override
    public List<B> list(int page, int count, int tableIndex) throws Exception {
        return null;
    }

    @RequestMapping("/count")
    @ResponseBody
    @Override
    public long count(int tableIndex) throws Exception {
        return 0;
    }

    @RequestMapping("/clear")
    @ResponseBody
    @Override
    public long clear(int tableIndex) throws Exception {
        return service.clear(tableIndex);
    }
}
