package com.charles.eurakeclient.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * Description: my first spring cloud project for test eureka-client
 * User: Charles
 * Date: 2018-05-16 23:31
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        LOGGER.info("hello,host:" + instance.getHost() + ",serverId:" + instance.getServiceId());
        return "Hello Charles!!!!";
    }
}
