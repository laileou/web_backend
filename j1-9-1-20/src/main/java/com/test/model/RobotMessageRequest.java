package com.test.model;

/**
 * @author joe
 */
public class RobotMessageRequest {

    private int reqType =0;
    private Perception perception;
    private UserInfo userInfo = new UserInfo();

    //补充类成员变量的Getter and Setter方法
    public  String Getter(){
        return perception.getInputText().text;
    }

    public static void Setter(){

    }
    public void setPerception(Perception per){
        this.perception=per;
    }
    public  class Perception{

        private InputText inputText;

        public InputText getInputText() {
            return inputText;
        }

        public void setInputText(InputText inputText) {
            this.inputText = inputText;
        }
    }

    public  class InputText{
        private String text;
        public void setText(String input){
            this.text=text;
        }
        //完善类的剩余结构  提示：仔细思考一下这个类需要完成的额一些业务逻辑
        public String gettext(){
            return text;
        }

    }

    public static class UserInfo {
        private String apiKey = "b017c92f5c084daab1dc79f6dba247a8";
        private String userId = "youkeda001";

        //完善类的剩余结构   提示：仔细思考一下这个类需要完成的额一些业务逻辑
    }

}
