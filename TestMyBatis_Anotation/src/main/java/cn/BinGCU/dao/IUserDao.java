package cn.BinGCU.dao;

import cn.BinGCU.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有记录
     *
     * @return
     */
    @Select("SELECT * FROM user_table;")
    List<User> findAll();
}
