package com.cit.productsocial.utils.filestorage.amazons3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AWS3Client {

    private static final String AWS3_ACCESS_KEY_ID = "AKIAJ3J4N2KFHHELQ3BA";
    private static final String AWS3_SECRET_ACCESS_KEY = "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";
    public static final String AWS3_REGION = "ap-southeast-1";
    public static final String AWS3_DEFAULT_BUCKET = "new-albums";

    public AWS3Client() {

    }

    public final AmazonS3 init() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AWS3_ACCESS_KEY_ID, AWS3_SECRET_ACCESS_KEY);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(AWS3_REGION))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
