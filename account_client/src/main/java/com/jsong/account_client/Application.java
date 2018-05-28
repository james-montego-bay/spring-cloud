package com.jsong.account_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
/*
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
*/


@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Account account = restTemplate.getForObject("http://localhost:8082/accounts/1", Account.class);
        log.info("++++" + account.toString() + "++++");
    }

    /*

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }*/

}
