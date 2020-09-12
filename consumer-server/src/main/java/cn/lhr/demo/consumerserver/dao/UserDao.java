package cn.lhr.demo.consumerserver.dao;

import cn.lhr.demo.consumerserver.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
//    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryById(Long id){
        Long begin = System.currentTimeMillis();
//        String url = "http://localhost:8081/user/" + id;
        String url = "http://user-server/user" + id;
        User user = restTemplate.getForObject(url,User.class);
        Long end  = System.currentTimeMillis();
        logger.info("访问用时：{}",end-begin);
        return user;
     }

 /*   public User queryUserByIdFallback(Long id){
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常！");
        System.out.println(user);
        return user;
    }*/
}
