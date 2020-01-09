package org.bmth.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bmth.mybatis.dao.UserMapper;
import org.bmth.mybatis.entity.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by pengq on 2020/1/4 13:15.
 */
public class MybatisApplication {
    public static void main(String[] args) {
        String resource = "/mybatis-config.xml";
        InputStream inputStream = MybatisApplication.class.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> user = userDao.findAll();
        System.out.println(user);
    }
}
