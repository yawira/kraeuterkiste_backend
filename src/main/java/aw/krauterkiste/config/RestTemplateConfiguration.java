package aw.krauterkiste.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Value("${raspi.url}")
    private String raspiURL;

    @Bean("raspiRestTemplate")
    public RestTemplate raspiRestTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return raspiRestTemplateBuilder(builder);
    }

    public RestTemplate raspiRestTemplateBuilder(RestTemplateBuilder builder) {
       return builder
               .rootUri(raspiURL)
               .build();
    }
}
