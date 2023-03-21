package com.aern.paymentreekordservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankDetail {

    private String beneficiaryName;
    private String bankName;
    private String accountType;
    private String accountNumber;
    private String ifscCode;
    private String chequeURL;
}
