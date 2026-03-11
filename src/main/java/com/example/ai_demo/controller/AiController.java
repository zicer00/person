package com.example.ai_demo.controller;


import com.example.ai_demo.dto.OcrContent;
import com.example.ai_demo.mapper.OcrContentMapper;
import com.example.ai_demo.util.AiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
public class AiController {
    @Autowired
    private OcrContentMapper ocrContentMapper;

    @RequestMapping(value = "/nlp",method = RequestMethod.GET)
    public String nlp(@RequestParam("text") String text){
        String res = AiUtil.nlp(text);
        OcrContent ocrContent = new OcrContent();
        ocrContent.setContent(res);
        ocrContent.setType(3);
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        ocrContentMapper.insert(ocrContent);
        return res;
    }

    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public String img(@RequestParam("file")MultipartFile file) throws IOException {
        String res = AiUtil.img(file);
        OcrContent ocrContent = new OcrContent();
        ocrContent.setContent(res);
        ocrContent.setType(1);
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        ocrContentMapper.insert(ocrContent);
        return res;
    }

    @RequestMapping(value = "/word",method = RequestMethod.POST)
    public String word(@RequestParam("file") MultipartFile file) throws IOException {
        String res = AiUtil.word(file);
        OcrContent ocrContent = new OcrContent();
        ocrContent.setContent(res);
        ocrContent.setType(2);
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        ocrContentMapper.insert(ocrContent);
        return res;
    }
}
