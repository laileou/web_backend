package com.test.service;

import com.alibaba.fastjson.JSONObject;
import com.test.model.RobotMessageRequest;
import okhttp3.*;
import java.lang.String;

import java.io.IOException;

/**
 * RobotService
 */
public class RobotService {

    OkHttpClient client = new OkHttpClient();

    String post(String json) throws IOException {
        //创建requestbody对象，设置MediaType.get()函数的参数为"application/json; charset=utf-8"，请求内容设置为传入的JSON字符串
        RobotMessageRequest requestbody=new RobotMessageRequest();

        //创建request对象，请求url设置为"http://openapi.tuling123.com/openapi/api/v2"，请求类型为post，传入body对象
        Request request= new Request(,"http://openapi.tuling123.com/openapi/api/v2",post(String.valueOf(requestbody)));
        //这里是try-catch的异常捕获，是   Java开发中很重要的一环，是Java程序安全性的保证，在此不必纠结，后面会学到
        try (Response response = client.newCall(request).execute()) {
            //将返回的JSON数据转换为对象类型，并获取返回的结果文本，并以字符串的形式返回
            JSONObject jsonObject=JSONObject.parseObject(json);
            String result= JSONObject.toJSONString(jsonObject);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String reply(String input) {

        //完成RobotMessageRequest对象的参数设置
        RobotMessageRequest request = new RobotMessageRequest();
        RobotMessageRequest.InputText inputText= request.new InputText();

        //......
        inputText.setText(input);

        //......

        RobotMessageRequest.Perception perception=request.new Perception();
        perception.setInputText(inputText);

        request.setPerception(perception);
        //将请求转换为JSON字符串，通过post方法提交并返回结果字符串
        RobotService rr=new RobotService();
        try {
            return rr.post(request.Getter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}