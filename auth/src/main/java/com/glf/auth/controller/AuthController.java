package com.glf.auth.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
public class AuthController {
          private Log log = LogFactory.getLog(getClass());


    @GetMapping("/test")
    public Callable getAuto(){
        DeferredResult deferredResult = new DeferredResult();
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                log.info("测试");
                return "test";
            }
        };
        log.info("完成");
        return callable;
    }
}
