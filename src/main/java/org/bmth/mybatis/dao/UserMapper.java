package org.bmth.mybatis.dao;

import org.bmth.mybatis.entity.User;

/**
 * Created By pengq On 2020/1/4 23:00
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
