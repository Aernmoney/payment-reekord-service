package com.aern.paymentreekordservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressDetail {

    @NotBlank(message = "AddressLine1 cannot be null")
    private String addressLine1;
    private String addressLine2;
    @NotBlank(message = "State cannot be null")
    private String state;
    @NotBlank(message = "Pincode cannot be null")
    private String pinCode;

}
