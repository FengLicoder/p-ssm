package cn.lhr.demo.consumerserver.service;

import cn.lhr.demo.consumerserver.dao.UserDao;
import cn.lhr.demo.consumerserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate; //基于HTTP协议的远程请求对象


    @Autowired
    private DiscoveryClient discoveryClient;//服务发现对象

    public List<User> queryUserByIds(List<Long> ids){
        List<User> users = new ArrayList<>();

        //不使用负载均衡，根据服务名称获取服务实例
     /*   List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
        ServiceInstance serviceInstance = instances.get(0);
        String baseUrl = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/";*/
//        String baseUrl = "http://localhost:8081/user/";

      ///地址可以直接写服务名称，负载均衡根据服务名称自动获取IP和端口
        String baseUrl = "http://user-server/user/";
        /*for (Long id : ids) {
            users.add(userDao.queryById(id));
        }*/
        ids.forEach(id->{
            users.add(restTemplate.getForObject(baseUrl+id,User.class));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return users;
    }
/*
    @Autowired
    UserDao userDao;

    public List<User> queryUserByIds(List<Long> ids){
        List<User> users = new ArrayList<>();

        ids.forEach(id->{
            users.add(userDao.queryById(id));
        });
        return users;
    }*/
}

