package com.example.ai_demo.util;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

public class SampleNLP {


    public static void main(String[] args) {
        //设置APPID/AK/SK
        String APP_ID = "122226872";
        String API_KEY = "d2DLPa6joDuWplOxbH0sSYhP";
        String SECRET_KEY = "iwrWntRvYAjGsAIr9e5ZC84O5sQVd1Km";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        String text = "百度是一家人工智能公司";
        JSONObject res = client.ecnet(text, null);
        System.out.println(res.toString(2));

    }
}
