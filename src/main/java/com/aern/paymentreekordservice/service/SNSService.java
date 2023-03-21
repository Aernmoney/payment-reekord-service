package com.aern.paymentreekordservice.service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SNSService {

    private final static String AWS_SNS_SMS_TYPE = "AWS.SNS.SMS.SMSType";
    private final AmazonSNSClient amazonSNSClient;

    public SNSService(AmazonSNSClient amazonSNSClient) {
        this.amazonSNSClient = amazonSNSClient;
    }

    public void sendTextSMS(String phoneNumber , String message) {

        Map<String, MessageAttributeValue> smsAttribute = new HashMap<>();
        smsAttribute.put(AWS_SNS_SMS_TYPE,new MessageAttributeValue()
                .withStringValue("Transactional").withDataType("String"));

        PublishRequest publishRequest = new PublishRequest();
        publishRequest.setPhoneNumber(phoneNumber);
        publishRequest.setMessage(message);
        publishRequest.setMessageAttributes(smsAttribute);

        amazonSNSClient.publish(publishRequest);
    }
}
