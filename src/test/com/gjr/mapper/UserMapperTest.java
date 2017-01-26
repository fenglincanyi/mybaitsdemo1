package com.gjr.mapper;

import com.gjr.po.User;
import com.gjr.po.UserCustom;
import com.gjr.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

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

    /**
     * 模糊查询
     */
    @Test
    public void queryUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.getMapper(UserMapper.class).queryUserByName("明");

        System.out.println(users);

        sqlSession.close();
    }

    /**
     * 包装类型，输入映射测试
     */
    @Test
    public void queryUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("明");// 设置模糊关键字
        userCustom.setPassword("888888");
        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> users = sqlSession.getMapper(UserMapper.class).queryUserList(userQueryVo);

        System.out.println(users);

        sqlSession.close();
    }

}