package Test;

import cn.BinGCU.dao.EmployeeMapper;
import cn.BinGCU.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestPojos {

    @Test
    public void testGetNameAndEmployeeByName(){
        String source = "mybatisConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(source);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            for (Map<String, Employee> stringEmployeeMap : mapper.getNameAndEmployeeByName("zhangsan")) {
                System.out.println(stringEmployeeMap);
            }

            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdateById(){
        String source = "mybatisConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(source);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            SqlSession sqlSession1 = factory.openSession();

            EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
            Map<Object, Object> params = new HashMap<>();
            params.put("id", 1);
            params.put("salary", 5000);
            mapper1.updateById(params);
            sqlSession1.commit();        //别忘了commit啊（笑哭）
            sqlSession1.close();

            SqlSession sqlSession2 = factory.openSession();
            EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
            System.out.println(mapper2.getNameAndEmployeeByName("zhangsan"));


            sqlSession2.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmloyeeById(){
        String source = "mybatisConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(source);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper.getEmloyeeById(3));

            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testGetIdAndEmloyeeById(){
        String source = "mybatisConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(source);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Employee> map = mapper.getIdAndEmloyeeById(4);
            System.out.println(map);


            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMaxSalary(){
        String resource = "mybatisConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper.getMaxSalary());

            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQuerySalaryGreaterThan4000(){
        String resource = "mybatisConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.querySalaryGreaterThan4000();
            for (Employee employee : list) {
                System.out.println(employee);
            }

            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testBatchInsert(){
        String resource = "mybatisConfig.xml";
        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee01 = new Employee();
            employee01.setId(20);
            employee01.setName("XXX");
            employee01.setSalary(5000);

            Employee employee02 = new Employee();
            employee02.setId(21);
            employee02.setName("YYY");
            employee02.setSalary(5000);

            Employee employee03 = new Employee();
            employee03.setId(22);
            employee03.setName("ZZZ");
            employee03.setSalary(5000);

            List<Employee> list = new LinkedList<>();
            list.add(employee01);
            list.add(employee02);
            list.add(employee03);

            mapper.batchInsert(list);
            sqlSession.commit();

            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmployeeByFuzzySearch(){
        String resource = "mybatisConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = build.openSession();

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee();
            employee.setSalary(5000);

            List<Employee> list = mapper.getEmployeeByFuzzySearch(employee);
            for (Employee employee1 : list) {
                System.out.println(employee1);
            }

            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
