package com.aern.paymentreekordservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "aws.sns.text.sms")
public class SNSProperties {

    private String awsRegion;
    private String awsAccessKeyId;
    private String awsSecretKey;
}
