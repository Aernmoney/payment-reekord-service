package com.aern.paymentreekordservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerDetail {

    @NotBlank(message = "FullName cannot be null")
    private String fullName;
    @NotBlank(message = "BusinessName cannot be null")
    private String businessName;
    @NotBlank(message = "PhoneNumber cannot be null")
    private String phoneNumber;
    @NotBlank(message = "EmailId cannot be null")
    @Email(message = "provide correct mail address")
    private String emailId;
    @Valid
    private AddressDetail businessAddress;
    @NotBlank(message = "BusinessType cannot be null")
    private String businessType;
    private String haskKey;
}
