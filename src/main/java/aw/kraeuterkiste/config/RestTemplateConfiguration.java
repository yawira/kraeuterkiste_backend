package aw.kraeuterkiste.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    // RestTemplateBuilder is used for dynamic configuration of RestTemplate through application.properties

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
