package cn.BinGCU.dao;

import cn.BinGCU.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {

    /**
     * 查询所有记录
     * @return
     */
    List<User> findAll();

    int insertUser(User user);

    int insertUserByMap(Map<String, Object> map);
}
