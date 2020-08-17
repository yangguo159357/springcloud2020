package com.xiaolun.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.xiaolun.springcloud.entities.CommonResult;
import com.xiaolun.springcloud.entities.Payment;
import com.xiaolun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}") //取yml文件中的server.port=8001的值。
    private String serverPort;

    //服务发现client端，获得相应的服务信息
    //依赖org.springframework.cloud.client.discovery.DiscoveryClient;
    @Autowired
    private DiscoveryClient discoveryClient;


    //不要忘记加@RequestBody注解，不然80端口传过来的数据接收不到
    @PostMapping(value = "/payment/create") //post:写操作
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("--------插入结果------"+result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")  //get:读操作
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("--------查询结果------"+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询id:"+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("-----element-----"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
