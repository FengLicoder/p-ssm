package cn.lhr.demo.consumerserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerServerApplication.class)
public class LoadBalanceTest {
    @Autowired
    private RibbonLoadBalancerClient ribbonLoadBalancerClient;

    @Test
    public void test(){

        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = ribbonLoadBalancerClient.choose("user-server");
            System.out.println(instance.getHost()+":"+instance.getPort());
        }
    }
}
