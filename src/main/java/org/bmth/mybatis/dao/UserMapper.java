package org.bmth.mybatis.dao;

import org.bmth.mybatis.entity.User;

import java.util.List;

/**
 * Created By pengq On 2020/1/4 23:00
 */
public interface UserMapper {
    List<User> findAll();
    void saveUser(User user);
}
