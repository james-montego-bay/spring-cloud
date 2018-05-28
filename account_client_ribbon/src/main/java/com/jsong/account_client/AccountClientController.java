package com.jsong.account_client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
/* If Ribbon customization is needed
@RibbonClient(name = "account_service", configuration = RibbonConfiguration.class)
*/
public class AccountClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    /*
     * Two ways to call other service by name, without hardcoding the URL
     */
    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "id") int id) {

        final List<ServiceInstance> instances = this.discoveryClient.getInstances("account-service");
        for (final ServiceInstance instance : instances) {
            LOGGER.info("Instance: " + instance.getHost().toString());
            LOGGER.info("Port: " + instance.getPort());
            LOGGER.info("URI: " + instance.getUri().toString());
        }

        Account account = this.restTemplate.getForObject("http://account-service/accounts/" + id, Account.class);
        return String.format("%s", account);
    }

}
