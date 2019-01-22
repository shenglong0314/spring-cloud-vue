package com.glf.parent.provide.system.dao;


import com.glf.parent.provide.system.config.MyMapper;
import com.glf.parent.provide.system.entity.Router;
import com.glf.parent.provide.system.pojo.RouterTree;

import java.util.Set;

public interface RouterMapper extends MyMapper<Router> {

    Set<RouterTree> findRouterAndMeta(Long id);
}