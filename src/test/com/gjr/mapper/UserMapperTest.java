package com.gjr.mapper;

import com.gjr.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by geng
 * on 2017/1/26.
 */
public class UserMapperTest {

    private static final String RESOURCE_FILE_NAME = "mybatisconfig.xml";
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream in = Resources.getResourceAsStream(RESOURCE_FILE_NAME);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.getMapper(UserMapper.class).findUserById(2);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User tmp = new User();
        tmp.setUsername("啦啦啦");
        tmp.setPassword("998382");
        sqlSession.getMapper(UserMapper.class).insertUser(tmp);

        // 一定要提交,否则不生效
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User tmp = new User();
        tmp.setId(3);
        tmp.setUsername("小明");
        tmp.setPassword("888888");

        sqlSession.getMapper(UserMapper.class).updateUser(tmp);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(UserMapper.class).deleteUser(7);
        sqlSession.commit();
        sqlSession.close();
    }

}