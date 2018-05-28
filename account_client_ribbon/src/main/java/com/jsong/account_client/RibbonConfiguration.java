package com.jsong.account_client;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }

/*    @Bean
    public ServerListFilter<Server> serverListFilter() {
        return new VersionedNIWSServerListFilter<>(this.discoveryClient, RibbonClientApi.DEMO_REGISTRATION_API_1_V1);
    }*/
}