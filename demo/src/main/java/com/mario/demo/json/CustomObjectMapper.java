package com.mario.demo.json;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class CustomObjectMapper extends ObjectMapper {

  public CustomObjectMapper() {
    super();
    //排除值为空的属性
    setSerializationInclusion(JsonInclude.Include.NON_NULL);
    //转换成对象时没有属性的处理忽略
    disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    //设置日期格式
    setDateFormat(new SimpleDateFormat());

    //进行缩进输出
    configure(SerializationFeature.INDENT_OUTPUT, true);


  }
}
