package com.glf.parent.provide.system.service;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glf.parent.provide.system.dao.RolesMapper;
import com.glf.parent.provide.system.entity.Roles;
import com.glf.parent.provide.system.pojo.ResponsePage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class RolesServiceImpl {


    @Autowired
    private RolesMapper rolesMapper;

public int add(Roles roles){
    int i;
    if(roles.getId()==null){
        i = rolesMapper.insert(roles);
    }else {
        i=rolesMapper.updateByPrimaryKey(roles);
    }


    return i;
}
public Roles selectRolesByid(Long id){
    Roles roles = rolesMapper.selectByPrimaryKey(id);

    return roles;
}

public int delectByid(Long id){
    int i = rolesMapper.deleteByPrimaryKey(id);

    return i;
}





public  List<Roles> getRoles(Integer userid){
    List<Roles> roles = rolesMapper.getRoles(userid);
      return roles;
   }


    public ResponsePage<Roles> getPageRolesList(Long page,Long limit,String search) {
        Example example = new Example(Roles.class);
        if(!StringUtils.isBlank(search)){
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("name","%"+search+"%");
        }
        ResponsePage<Roles> rolesPage = new ResponsePage<>();
        Page<Object> objects = PageHelper.startPage(page.intValue(), limit.intValue());
        List<Roles> roles = rolesMapper.selectByExample(example);
        rolesPage.setData(roles);
        rolesPage.setTotal(objects.getTotal());

        return rolesPage;
    }
}
