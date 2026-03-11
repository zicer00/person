package com.example.ai_demo;

import com.example.ai_demo.controller.ContentController;
import com.example.ai_demo.dto.OcrContent;
import com.example.ai_demo.dto.User;
import com.example.ai_demo.mapper.OcrContentMapper;
import com.example.ai_demo.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class QuickStartTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OcrContentMapper ocrContentMapper;

    @Autowired
    private ContentController controller;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
        
/*        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);*/
    }

    @Test
    public void testSelectOcr(){
        System.out.println(("----- selectAll method test ------"));
        List<OcrContent> ocrContentList= ocrContentMapper.selectList(null);
        for (OcrContent ocrContent : ocrContentList) {
            System.out.println(ocrContent.getId());
            System.out.println(ocrContent.getContent());
            System.out.println(("----------------------"));
        }
    }

    @Test
    public void testInsertOcr(){
        System.out.println(("----- Insert method test ------"));
        OcrContent ocrContent = new OcrContent();
        ocrContent.setId(2l);
        ocrContent.setContent("baidu");
        ocrContent.setType(2);
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        int insertNum=ocrContentMapper.insert(ocrContent);
        System.out.println("成功插入"+insertNum+"条数据");
    }

    @Test
    public void testDeleteOcr(){
        System.out.println(("----- Delete method test ------"));
        int deleteNum=ocrContentMapper.deleteById(2);
        System.out.println("成功删除"+deleteNum+"条数据");
    }

    @Test
    public void testUpdateOcr(){
        System.out.println(("----- Update method test ------"));
        OcrContent ocrContent = new OcrContent();
        ocrContent.setId(1l);
        ocrContent.setContent("baidu");
        ocrContent.setType(1);
        ocrContent.setCreateTime(new Date());
        ocrContent.setModifyTime(new Date());
        int updateNum=ocrContentMapper.updateById(ocrContent);
        System.out.println("成功修改"+updateNum+"条数据");
    }

    @Test
    public void ContentControllerTest(){
        List<OcrContent> allContent = controller.getAllContent();
        for (OcrContent content : allContent) {
            System.out.println(content.getId());
            System.out.println(content.getContent());
        }

    }
}
