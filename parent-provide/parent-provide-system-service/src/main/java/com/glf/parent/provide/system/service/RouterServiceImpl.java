package com.glf.parent.provide.system.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glf.parent.provide.system.dao.RouterMapper;
import com.glf.parent.provide.system.entity.Roles;
import com.glf.parent.provide.system.entity.Router;
import com.glf.parent.provide.system.pojo.ResponsePage;
import com.glf.parent.provide.system.pojo.RouterTree;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class RouterServiceImpl {

    @Autowired
    private RouterMapper routerMapper;

    public Set<RouterTree> findRouterTree(List<Roles> ids) {
        Set<RouterTree> routerTrees = new HashSet<>();
        for (Roles id : ids) {
            Set<RouterTree> routerAndMeta = routerMapper.findRouterAndMeta(id.getId());
            routerTrees.addAll(routerAndMeta);
        }
        return routerTrees;
    }

    public int add(Router router) {
        int i;
        if (router.getId() == null) {
            i = routerMapper.insert(router);
        } else {
            i = routerMapper.updateByPrimaryKey(router);
        }
        return i;
    }

    public Router selectRouterByid(Long id) {
        Router route = routerMapper.selectByPrimaryKey(id);

        return route;
    }

    public int delectByid(Long id) {
        int i = routerMapper.deleteByPrimaryKey(id);

        return i;
    }


    public ResponsePage<Router> getPageRouterList(Long page, Long limit, String search) {
        Example example = new Example(Router.class);
        if (!StringUtils.isBlank(search)) {
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("path", "%" + search + "%");
        }
        ResponsePage<Router> routePage = new ResponsePage<>();
        Page<Object> objects = PageHelper.startPage(page.intValue(), limit.intValue());
        List<Router> route = routerMapper.selectByExample(example);
        routePage.setData(route);
        routePage.setTotal(objects.getTotal());

        return routePage;

    }
    }
