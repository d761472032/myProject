package com.mySpringMVC.service;

import com.mySpringMVC.entity.baseData;

public interface loginService {
    baseData checkKey(String key);

    String getJspName(int key);
}