package com.jsong.account_client_feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "account-service")
//@RibbonClient(name = "account-service")
public interface AccountServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    List<Account> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    Account getUser(@PathVariable("id") long id);

}
