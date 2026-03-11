package com.example.ai_demo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("`ocr_content`")
public class OcrContent {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String content;
    private Integer type;
    private Date createTime;
    private Date modifyTime;
}
