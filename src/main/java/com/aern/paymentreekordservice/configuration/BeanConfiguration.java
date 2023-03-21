package com.aern.paymentreekordservice.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3Builder;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private SNSProperties snsProperties;

    @Autowired
    private S3Properties s3Properties;

    @Bean
    public AmazonSNSClient amazonSNSClient() {
        BasicAWSCredentials credentials =
                new BasicAWSCredentials(snsProperties.getAwsAccessKeyId(),snsProperties.getAwsSecretKey());
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(snsProperties.getAwsRegion())
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    }

    @Bean
    public AmazonS3Client amazonS3Client() {
        BasicAWSCredentials credentials =
                new BasicAWSCredentials(s3Properties.getAwsAccessKeyId(),s3Properties.getAwsSecretKey());
        return (AmazonS3Client) AmazonS3ClientBuilder.standard().withRegion(s3Properties.getAwsRegion())
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    }
}
