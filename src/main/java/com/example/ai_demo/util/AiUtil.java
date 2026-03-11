package com.example.ai_demo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AiUtil {
    public static String img(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "122226141";
        String API_KEY = "OBpckAcxdqDBEn9U9TkANwez";
        String SECRET_KEY = "nGuuWCY80A61KuAzvSkBUQFUDWWThxuy";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);


        // 调用接口

        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        JSONObject result=res.getJSONArray("result").getJSONObject(0);
        String s = "这张图"+result.getDouble("score")*100+"%的概率是"+result.getString("keyword");
        return s;
    }

    public static String word(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "122225734";
        String API_KEY = "MTgcSlLStYPDmRXPDe5pabzR";
        String SECRET_KEY = "MaCDQ00DlSwf5ot5VNKdsqTRZSpzGn9k";

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);


        // 调用接口

        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray array = res.getJSONArray("words_result");
        StringBuffer result=new StringBuffer();
        for (int i = 0; i < array.length(); i++) {
            result.append(array.getJSONObject(i).getString("words")).append("\n");
        }

        return result.toString();
    }

    public static String nlp(String text){
        //设置APPID/AK/SK
        String APP_ID = "122226872";
        String API_KEY = "d2DLPa6joDuWplOxbH0sSYhP";
        String SECRET_KEY = "iwrWntRvYAjGsAIr9e5ZC84O5sQVd1Km";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口

        JSONObject res = client.ecnet(text, null);
        String res1=res.getJSONObject("item").getString("correct_query");
        return res1;
    }


    public static void main(String[] args) {
        String text = "百度是一家人工智能公四";
        System.out.println(nlp(text));
    }
}
