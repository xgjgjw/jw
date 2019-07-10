package com.mj.jw.user.service;

import com.mj.jw.user.entity.User;
import com.mj.jw.user.entity.UserParam;

import java.util.List;

public interface UserService {
    List<User> getUserList(UserParam userParam);
}
