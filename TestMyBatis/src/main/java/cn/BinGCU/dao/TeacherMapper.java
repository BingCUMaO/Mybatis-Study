package cn.BinGCU.dao;

import cn.BinGCU.Teacher;

public interface TeacherMapper {

    Teacher getTeacherById( int id);

    Teacher getTeacherAndHisStudents(int id);
}
