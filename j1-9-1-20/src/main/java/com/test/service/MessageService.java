package com.test.service;

public class MessageService {
    //创建RobotService成员变量并赋初值
    RobotService r1=new RobotService();

    /**
     * 发消息
     *
     * @param message
     */
    public String send(String message) {
        //根据传入的message消息描述，调用RobotService对象，获取对话结果，并返回
          return  r1.reply(message);

    }
}
