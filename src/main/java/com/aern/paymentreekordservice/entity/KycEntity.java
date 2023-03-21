package com.aern.paymentreekordservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kyc_details")
public class KycEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DOC_NAME")
    private String docName;
    @Column(name = "DOC_URL")
    private String docURL;
    @Column(name = "DOC_NUMBER")
    private String docNumber;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
