package com.chat.service.Impl;
/*
 * Created by Administrator on 2020/7/21  0021
 * DateTime:2020/07/21 22:38
 * Description:
 * Others:
 */


import com.chat.dao.ChatDao;
import com.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service("ChatServiceImpl")
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatDao chatDao;

    @Override
    public String QueryAnswer(String question) {

        String answer = chatDao.selectByQuestion(question);
        return answer;
    }
}
