package com.chat.web.controller;

import com.chat.domain.Chat;
import com.chat.service.ChatService;
import com.chat.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;



/*
 * Created by Administrator on 2020/8/8  0008
 * DateTime:2020/08/08 16:50
 * Description:
 * Others:
 */

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private WeatherService weatherService;



    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public String answer(@RequestBody List<Chat> ChatList, Model model) {
        System.out.println("model = " + model);
        String question = "";
        for (Chat chat : ChatList) {
            question=chat.getQuestion();
        }
        System.out.println("question = " + question);
        String weatherInfo = "";
        String weanthertext="天气";
        for (Chat chats : ChatList) {
            question = chats.getQuestion();
        }

        System.out.println("question = " + question);
        System.out.println("question.indexOf(\"天气\") = " + question.indexOf("天气"));
        if (question.contains(weanthertext)) {
            weatherInfo = weatherService.queryAsCityname("高唐");
        }
        final String Answer = chatService.QueryAnswer(question);
//        String finalWeatherInfo = weatherInfo;
        final String finalWeatherInfo = weatherInfo;
        new Thread(new Runnable() {
            @Override
            public void run() {
//        Word2SoundUtils.text2speak(Answer);
//        Word2SoundUtils.text2speak(finalWeatherInfo);

            }
        }).start();
        model.addAttribute("INfo", Answer);
        model.addAttribute("wearher", finalWeatherInfo);

        return "Success";
    }
}
