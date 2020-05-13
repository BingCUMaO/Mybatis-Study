package cn.BinGCU;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private int id;

    private String tname;

    //表示一个老师集合多个学生，1对多关系
    private List<Student> students;

}
