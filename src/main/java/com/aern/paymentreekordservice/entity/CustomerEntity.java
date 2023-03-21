package com.aern.paymentreekordservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer_detail")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FULL_NM")
    private String fullName;
    @Column(name = "BUSINESS_NM")
    private String businessName;
    @Column(name = "PHONE_NO")
    private String phoneNumber;
    @Column(name = "EMAIL_ID")
    private String emailId;
    @Column(name = "BUSINESS_TYPE")
    private String businessType;
    @Column(name = "OTP")
    private String otpNumber;
    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private Set<AddressEntity> addresses = new HashSet<>();
}
