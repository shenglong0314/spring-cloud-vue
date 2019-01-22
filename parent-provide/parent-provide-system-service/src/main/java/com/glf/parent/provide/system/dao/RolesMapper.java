package com.glf.parent.provide.system.dao;


import com.glf.parent.provide.system.config.MyMapper;
import com.glf.parent.provide.system.entity.Roles;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface RolesMapper extends MyMapper<Roles> {

    @Select("SELECT r.* FROM user_roles ru ,roles r WHERE ru.userid=#{userid}  AND ru.rolesid=r.id")
    List<Roles> getRoles(Integer userid);

}