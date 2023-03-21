package com.aern.paymentreekordservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {
    @NotBlank(message = "Phone Number cannot be blank")
   // @Pattern(regexp = RegexUtils.PHONE_REGEX , message = "Invalid Phone Number provided")
    private String phoneNumber;
    @NotBlank(message = "Otp Number cannot be blank")
    //@Pattern(regexp = RegexUtils.OTP_REGEX , message = "Invalid Otp Number provided")
    private String otpNumber;
}
