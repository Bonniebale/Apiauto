package com.api.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {
    /**
     * SqlSessionFactoryBuilder  构造器，可以从 XML 配置文件或一个预先配置的 Configuration 实例来构建出 SqlSessionFactory 实例。
     * SqlSessionFactory SqlSession工厂，每个基于 MyBatis 的应用都以一个 SqlSessionFactory 的实例为核心，由SqlSessionFactoryBuilder类创建。
     * SqlSessionFactory类可以用于创建SqlSession类，方法：openSession(),传入参数true可以设置为自动提交事务。
     * SqlSession SqlSession代表和数据库的一次会话，用完必须关闭，是非线程安全的。可以从SqlSessionFactory中获得 SqlSession 的实例；
     * SqlSession 提供了在数据库执行 SQL 命令所需的所有方法，可以通过 SqlSession 实例来获得映射器接口的代理对象，即接口和xml文件进行绑定。
     * 方法：getMapper()，需要传入dao接口的class类型参数UserDao.class
     * @return
     * @throws IOException
     */
    public static SqlSession getSqlSession() throws IOException {

        //获取资源的配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        ////由SqlSessionFactoryBuilder对象获取SqlSessionFactory对象
        //
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        // //由SqlSession工厂获得SqlSession对象，使用其进行增删改查,SqlSession是能够执行配置文件中的sql语句
        SqlSession sqlSession = factory.openSession();
        return sqlSession;

    }
}
