package com.chat.dao;

/*
 * Created by Administrator on 2020/7/21  0021
 * DateTime:2020/07/21 22:38
 * Description:
 * Others:
 */

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ChatDao {

    /**
     * @param question
     * @return
     */
    @Select("select answer from chat where question=#{question}")
    public String selectByQuestion(@Param("question") String question);
}
