package cn.BinGCU.dao;

import cn.BinGCU.Student;
import cn.BinGCU.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> getStudent01();
    List<Student> getStudent02();

    Teacher getTeacherById(@Param("tid") int id);
}
