package com.mj.jw.user.dao;

import com.mj.jw.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList(Map<String,Object> map);
}
