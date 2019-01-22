package com.glf.parent.provide.system.controller;


import com.glf.parent.provide.system.entity.Router;
import com.glf.parent.provide.system.pojo.ResponsePage;
import com.glf.parent.provide.system.pojo.RouterTree;
import com.glf.parent.provide.system.service.RouterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("router")
@RestController
public class RouterController {


    @Autowired
    private RouterServiceImpl routerService;


    @RequestMapping("/findRouterTree")
    public List<RouterTree> findRouterTree() {


      //  List<RouterTree> routerTree = routerService.findRouterTree(1L);

        return null;
    }

    @RequestMapping("/getPageRouterList")
    public ResponseEntity getPageRouterList(Long page, Long limit, String search){
        ResponsePage<Router> pagerouterList = routerService.getPageRouterList(page, limit, search);
        return ResponseEntity.ok(pagerouterList);
    }

    @RequestMapping("/add")
    public int add(@RequestBody Router router){
        int i = routerService.add(router);
        return i;
    }


    @RequestMapping("/selectrouterByid")
    public ResponseEntity selectrouterByid(Long id){
        Router router = routerService.selectRouterByid(id);

        return ResponseEntity.ok(router);
    }
    @RequestMapping("/delectByid")
    public int delectByid(Long id) {


        int i = routerService.delectByid(id);

        return i;
    }
}
