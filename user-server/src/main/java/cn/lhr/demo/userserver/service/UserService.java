package cn.lhr.demo.userserver.service;


import cn.lhr.demo.userserver.mapper.UserMapper;
import cn.lhr.demo.userserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User quryById(Long id) throws InterruptedException {
        //Thread.sleep(new Random().nextInt(2000));
        return userMapper.selectByPrimaryKey(id);
    }
}
