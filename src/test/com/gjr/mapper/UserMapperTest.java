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
    }

}