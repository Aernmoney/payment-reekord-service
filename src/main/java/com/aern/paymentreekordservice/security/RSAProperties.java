package com.aern.paymentreekordservice.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "rsa")
public class RSAProperties {

    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;
}
