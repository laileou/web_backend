package com.test;
import com.test.service.MessageService;
import java.lang.String;
import java.sql.Connection;//Connection接口负责连接数据库并担任传送数据任务
import java.sql.DriverManager;//管理JDBC的驱动
import java.sql.SQLException;
import java.sql.Statement;//Statement接口有Connection产生，负责执行SQL语句

//这是整个程序的测试类，也就是程序的入口，已经编写完成，无需更改
/**
 * Application
 */
public class Application {

    public static MessageService messageService = new MessageService();

    public static void main(String[] args)throws ClassNotFoundException,SQLException {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //构建链接参数
        String url="jdbc:mysql://localhost:3306/web后端";//传入路径
        String username="root";
        String password="619429zai";

        //获取连接对象
        Connection connection=DriverManager.getConnection(url,username,password);//

        //获取执行者对象
        Statement statement=connection.createStatement();//由connection连接对象产生statement执行者对象，statement执行者对象执行mysql语句

        //判断连接对象
        if(connection==null)
            System.out.println("连接失败");
        else {
            System.out.println("连接成功");
        }

        //添加数据
        String sqlinsert="insert into user values('b017c92f5c084daab1dc79f6dba247a8','youkeda001')";
        if(statement.executeUpdate(sqlinsert)>=1)//调用执行者对象statement的执行更新方法，executeUpdate(sql)返回受影响的行数，>=1代表受影响的行数至少一行
        {
            System.out.println("添加成功");
        }
        else {
            System.out.println("添加失败");
        }



        //删除数据
        String sqldelete="delete from bank where id=3";
        if(statement.executeUpdate(sqldelete)>=1)//调用执行者对象statement的执行更新方法，executeUpdate(sql)返回受影响的行数，>=1代表受影响的行数至少一行
        {
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }

        connection.close();//关闭连接


        String reply = messageService.send("今天天气怎么样");
        System.out.println(reply);

        if (reply.indexOf("查询哪个城市") != -1) {//indexof查找字符串所在位置，找不到返回-1
            reply = messageService.send("杭州");
            System.out.println(reply);
        }
        System.exit(0);
    }

}