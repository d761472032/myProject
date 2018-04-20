package com.mySpringMVC.dao.redis;

import com.mySpringMVC.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class RedisImplTest {

    @Test
    public void set() {
        User user = new User();
        user.setUsername("d761472032");
        user.setPassword("761472032");
        RedisImpl.set("user",user);
        RedisImpl.closeConnection();
    }

    @Test
    public void del() {
        RedisImpl.del("user");
        RedisImpl.closeConnection();
    }

    @Test
    public void get() {
        User user = RedisImpl.get("user",User.class);
        if (user != null) System.out.println(user.toString());
        else System.out.println("user不存在");
        RedisImpl.closeConnection();
    }
}