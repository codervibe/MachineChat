package com.chat.service;

/*
 * Created by Administrator on 2020/7/21  0021
 * DateTime:2020/07/21 22:37
 * Description:
 * Others:
 */

import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service("chatService")
public interface ChatService {
    /**
     * @param question
     * @return
     */
    public String QueryAnswer(String question);
}
