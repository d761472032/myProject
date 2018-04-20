package com.mySpringMVC.util;

import com.alibaba.fastjson.JSON;
import com.mySpringMVC.entity.baseData;

public class jsonUtil {
    public static baseData dataToJson(Object object) {
        return new baseData(true, JSON.toJSONString(object));
    }
}
