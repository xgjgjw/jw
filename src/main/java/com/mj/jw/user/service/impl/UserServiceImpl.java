package com.mj.jw.user.service.impl;

import com.mj.jw.user.dao.UserMapper;
import com.mj.jw.user.entity.User;
import com.mj.jw.user.entity.UserParam;
import com.mj.jw.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserList(UserParam userParam) {
        Map<String,Object> map = new HashMap<>();
        List<User> list = userMapper.getUserList(map);
        return list;
    }
}
