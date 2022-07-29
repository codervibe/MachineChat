package com.chat.domain;
/*
 * Created by Administrator on 2020/7/21  0021
 * DateTime:2020/07/21 22:11
 * Description:
 * Others:
 */

public class Chat {
    private String question;
    private String answer;

    public Chat() {
    }

    public Chat(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
