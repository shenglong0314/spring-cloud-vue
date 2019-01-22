package com.glf.parent.provide.system.controller;


import com.glf.parent.provide.system.entity.Roles;
import com.glf.parent.provide.system.entity.User;
import com.glf.parent.provide.system.pojo.ResponsePage;
import com.glf.parent.provide.system.pojo.RouterTree;
import com.glf.parent.provide.system.service.RolesServiceImpl;
import com.glf.parent.provide.system.service.RouterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


@RestController()
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesServiceImpl rolesService;

    @Autowired
    private RouterServiceImpl routerService;
    @RequestMapping("/getRoles")
public  ResponseEntity<HashMap<String, Object>> getRoles(HttpServletRequest request , String token){

        ServletContext servletContext = request.getServletContext();
        User user = (User) servletContext.getAttribute(token);
        List<Roles> roles = rolesService.getRoles(user.getId());
        Set<RouterTree> routerTree = routerService.findRouterTree(roles);
        HashMap<String, Object> res = new HashMap<>();
        res.put("roles",roles);
        res.put("name",user.getUsername());
        res.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        res.put("router",routerTree);
        return ResponseEntity.ok(res);

    }

    @RequestMapping("/getPageRolesList")
public ResponseEntity getPageRolesList(Long page,Long limit,String search){
        ResponsePage<Roles> pageRolesList = rolesService.getPageRolesList(page, limit, search);
        return ResponseEntity.ok(pageRolesList);
}

@RequestMapping("/add")
    public int add(@RequestBody Roles roles){
        int i = rolesService.add(roles);
        return i;
    }


  @RequestMapping("/selectRolesByid")
    public ResponseEntity selectRolesByid(Long id){
        Roles roles = rolesService.selectRolesByid(id);

        return ResponseEntity.ok(roles);
    }
    @RequestMapping("/delectByid")
    public int delectByid(Long id) {


        int i = rolesService.delectByid(id);

        return i;
    }

}
