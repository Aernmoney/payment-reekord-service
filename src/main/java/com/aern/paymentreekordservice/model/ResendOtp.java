package com.aern.paymentreekordservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResendOtp {

    @NotBlank(message = "phoneNumber cannot be blank")
    private String phoneNumber;
    @NotBlank(message = "hashKey cannot be blank")
    private String hashKey;
}
