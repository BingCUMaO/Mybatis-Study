package cn.BinGCU.test;

import cn.BinGCU.Student;
import cn.BinGCU.Teacher;
import cn.BinGCU.User;
import cn.BinGCU.dao.IUserDao;
import cn.BinGCU.dao.StudentMapper;
import cn.BinGCU.dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperTest {

    @Test
    public void testSelect(){
        try(SqlSession sqlSession = SqlSessionUtil.getSqlSession()){

            IUserDao userDao  = sqlSession.getMapper(IUserDao.class);

            List<User> users = userDao.findAll();
            for (User user : users) {
                System.out.println(user);
            }
        }

    }

//    @Test
//    public void testInsert(){
//        try(SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
//
//            IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//
//            int i = userDao.insertUser(new User(120));
//            sqlSession.commit();
//
//            System.out.println("=======================>>>>>>>>"+i);
//
//        }
//    }

    @Test
    public void testInsertByMap(){
        try(SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            IUserDao userDao = sqlSession.getMapper(IUserDao.class);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userID", 130);

            int i = userDao.insertUserByMap(map);
            System.out.println("=======================>>>>>>>>"+i);

            sqlSession.commit();
        }


    }

    @Test
    //01、查询全部字段
    public void testStudentForeignKey01(){

        try(SqlSession sqlSession =  SqlSessionUtil.getSqlSession()) {
//            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//
//            Teacher teacher = teacherMapper.getTeacherById(1);
//            System.out.println(teacher);

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> stuList = studentMapper.getStudent01();
            for (Student s : stuList) {
                System.out.println(s);
            }
        }
    }

    @Test
    //02、查询部分字段
    public void testStudentForeignKey02() {

        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> stuList = studentMapper.getStudent02();
            for (Student s : stuList) {
                System.out.println(s);
            }
        }
    }


    @Test
    public void testGetTeacherAndHisStudents(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            Teacher teacher = sqlSession.getMapper(TeacherMapper.class).getTeacherAndHisStudents(1);

            //打印的时候Student类型里面的teacher为空
            // 是因为类型为Teacher，我没处理它的映射
            //要不然类型改为int 类型也行
            System.out.println(teacher);
            for (Student student : teacher.getStudents()) {
                System.out.println(student);
            }
        }
    }
}
