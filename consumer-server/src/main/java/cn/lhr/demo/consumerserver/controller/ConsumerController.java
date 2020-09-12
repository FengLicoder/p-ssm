package cn.lhr.demo.consumerserver.controller;



import cn.lhr.demo.consumerserver.pojo.User;
import cn.lhr.demo.consumerserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ConsumerController  {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> consumer(@RequestParam("ids") List<Long> ids){

        return userService.queryUserByIds(ids);

    }
}
