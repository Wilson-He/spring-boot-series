package io.apollo.client.property;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.annotation.PostConstruct;

/**
 * @author Wilson
 * @since 2020/2/26
 **/
@ConfigurationProperties("datasource")
@Slf4j
@ConstructorBinding
@Getter
@ToString
public class DataSourceProperties {
    private String url;
    private String username;
    private String password;
    private String driver;

    public DataSourceProperties(String url, String username, String password, @DefaultValue("com.mysql.jdbc.Driver") String driver) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    @PostConstruct
    public void init() {
        log.info(toString());
        log.info("DataSourceProperties initialized");
    }
}
