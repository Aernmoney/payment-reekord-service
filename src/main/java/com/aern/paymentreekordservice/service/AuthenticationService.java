package com.aern.paymentreekordservice.service;

import com.aern.paymentreekordservice.entity.CustomerEntity;
import com.aern.paymentreekordservice.model.AuthenticationRequest;
import com.aern.paymentreekordservice.model.AuthenticationResponse;
import com.aern.paymentreekordservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthenticationService {

    private final CustomerRepository customerRepository;
    @Autowired
    private JwtEncoder encoder;

    public AuthenticationService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
         CustomerEntity customer =
                customerRepository.findByPhoneNumberAndOtpNumber(authenticationRequest.getPhoneNumber(),
                        authenticationRequest.getOtpNumber());

        String token = generateToken(authenticationRequest.getPhoneNumber());
        return AuthenticationResponse.builder()
                .fullName(customer.getFullName() == null ? "NoName":customer.getFullName())
                .tokenType("Bearer")
                .token(token).build();
    }

    private String generateToken(String phoneNumber) {
            Instant now = Instant.now();
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer("http://aern.money.com")
                    .issuedAt(now)
                    .subject(phoneNumber)
                    .build();
            return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
