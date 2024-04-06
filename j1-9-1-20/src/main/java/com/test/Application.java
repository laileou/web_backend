package com.test;
import com.test.service.MessageService;
import java.lang.String;


//这是整个程序的测试类，也就是程序的入口，已经编写完成，无需更改
/**
 * Application
 */
public class Application {

    public static MessageService messageService = new MessageService();

    public static void main(String[] args) {
        String reply = messageService.send("今天天气怎么样");
        System.out.println(reply);

        if (reply.indexOf("查询哪个城市") != -1) {//indexof查找字符串所在位置，找不到返回-1
            reply = messageService.send("杭州");
            System.out.println(reply);
        }
        System.exit(0);
    }

}