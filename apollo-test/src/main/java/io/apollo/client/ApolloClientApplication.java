package io.apollo.client;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import io.apollo.client.property.DataSourceProperties;
import io.springframework.common.response.ServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wilson
 * @since 2020/2/24
 **/
@SpringBootApplication
//@EnableApolloConfig
@RestController
@RequestMapping("/")
public class ApolloClientApplication {
//    @Value("${app.name}")
    private String name;
//    @Value("${test.age:age}")
    private String age;

    @GetMapping("/name")
    public ServerResponse<String> name() {
        System.err.println(name + ":" + age);
        return ServerResponse.success(name + ":" + age);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApolloClientApplication.class, args);
    }
}
