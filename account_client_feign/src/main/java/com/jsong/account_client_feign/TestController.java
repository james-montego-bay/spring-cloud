package com.jsong.account_client_feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private AccountServiceClient accountServiceClient;



    @RequestMapping("/test")
    public String testFeignClient() {

        List<Account> accountList = accountServiceClient.getAll();
        //Account account = accountServiceClient.getUser(1L);
        return String.format("%s", accountList.size());
    }
}
