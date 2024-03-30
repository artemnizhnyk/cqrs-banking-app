package com.artemnizhnyk.cqrsbankingapp.web.security.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Getter
@Setter
@ConfigurationProperties(prefix = "security.jwt")
@Component
public class JwtProperties {

    private String secret;
    private Duration access;
    private Duration refresh;

}

