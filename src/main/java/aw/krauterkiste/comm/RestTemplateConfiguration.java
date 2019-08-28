package aw.krauterkiste.comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Value("${raspi.url}")
    private String raspiURL;

    @Bean("RaspiRestTemplate")
    @Autowired
    public RestTemplate raspiRestTemplate(RestTemplateBuilder builder) {
        return raspiRestTemplateBuilder(builder);
    }

    public RestTemplate raspiRestTemplateBuilder(RestTemplateBuilder builder) {
       return builder
               .rootUri(raspiURL)
               .build();
    }
}
