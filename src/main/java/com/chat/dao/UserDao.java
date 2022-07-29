package com.chat.dao;

/*
 * Created by Administrator on 2020/6/29  0029
 * DateTime:2020/06/29 6:13
 * Description:SSM
 * Others:
 */

import com.chat.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao接口
 */
@Component
@Repository
public interface UserDao {
    //显示所有账户信息

    /**
     * @return user
     */
    @Select("select * from user")
    public List<User> showUserInfo();
    //查询所有账户信息

    public List<UserDao> findAll();

    //保存账户信息

    public void saveAccount();



}
