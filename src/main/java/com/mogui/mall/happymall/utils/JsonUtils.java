package com.mogui.mall.happymall.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class JsonUtils {

      public static Map<String,Object> stringToMap(String body){
          return JSON.parseObject(body,Map.class);
      }
}
