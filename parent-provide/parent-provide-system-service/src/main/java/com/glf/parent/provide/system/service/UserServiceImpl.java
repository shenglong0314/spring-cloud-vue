package com.glf.parent.provide.system.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glf.parent.provide.system.dao.UserMapper;
import com.glf.parent.provide.system.entity.User;
import com.glf.parent.provide.system.pojo.ResponsePage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl {


    @Autowired
    private UserMapper userMapper;

    public ResponsePage selectUserList(Integer page,Integer limit,String search){
        ResponsePage<User> userPage = new ResponsePage<>();
        Page<Object> objects = PageHelper.startPage(page, limit);
        Example example = new Example(User.class);
        if(!StringUtils.isBlank(search)){
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("username","%"+search+"%");

        }
        List<User> users = userMapper.selectByExample(example);
        long total = objects.getTotal();
        int pages = objects.getPages();
        userPage.setPages(pages);
        userPage.setTotal(total);
        userPage.setData(users);
        System.out.println("=========================total:"+total+"==========pages:"+pages);

        return userPage;

    }
    public User login(String name,String passwd){
        User user = new User();
        user.setUsername(name);
        user.setPassword(passwd);


        User u = userMapper.selectOne(user);



            return u;



    }

    public int addUser(User user) {
        int i=0;
        if(user.getId()==null){
             i = userMapper.insertSelective(user);
        }else {
             i = userMapper.updateByPrimaryKey(user);
        }

        return i;
    }
    public User editUser(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public int deleteUserByid(Integer id){
        int i = userMapper.deleteByPrimaryKey(id);
        return i;
    }

    public User findUserByid(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
