package org.bmth.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bmth.mybatis.dao.UserMapper;
import org.bmth.mybatis.entity.Address;
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
        List<User> users = userDao.findAll();

        if (users != null && !users.isEmpty()){
            User user =  users.get(0);
            Address address = new Address();
            address.setProvince("北京市");
            address.setCity("北京市");
            address.setRegion("海淀区");
            address.setDetailAddress("海淀黄庄");
            user.setAddress(address);

            userDao.saveUser(user);
            sqlSession.commit();
        }
        System.out.println(users);
    }
}
