package com.example.ai_demo.util;

import java.util.*;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
public class Sample {


    public static void main(String[] args) {

        //设置APPID/AK/SK
        String APP_ID = "122225734";
        String API_KEY = "MTgcSlLStYPDmRXPDe5pabzR";
        String SECRET_KEY = "MaCDQ00DlSwf5ot5VNKdsqTRZSpzGn9k";

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);


        // 调用接口
        String path = "C:\\Users\\zice\\Pictures\\Screenshots\\test.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
        
    }
}