package cn.BinGCU.test;

import cn.BinGCU.User;
import cn.BinGCU.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis入门案例
 */
public class MybatisTest {

    public static void main(String[] args) throws Exception {
        //1、读取配置文件
        String resource = "mybatisConfig.xml";      //指定全局配置文件
        InputStream is = Resources.getResourceAsStream(resource);   //读取配置文件到IO流

        //2、创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3、使用SqlSessionFactory生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4、使用SqlSeesion创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        //5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        System.out.println("=============================");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("=============================");

        //6、释放资源
        sqlSession.close();
        is.close();
    }
}
