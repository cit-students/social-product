package com.cit.productsocial.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.cit.productsocial.utils.filestorage.amazons3.AWS3Client;
import com.cit.productsocial.utils.filestorage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.cit.productsocial.utils.filestorage.amazons3.AWS3Client.AWS3_DEFAULT_BUCKET;
import static com.cit.productsocial.utils.filestorage.amazons3.AWS3Client.AWS3_REGION;

@Service
public class AWS3FileStorageService implements FileStorageService {

    private final AmazonS3 s3Client;

    @Autowired
    public AWS3FileStorageService() {
        s3Client = new AWS3Client().init();
    }

    @Override
    public void createDir(String dirName) {
        //
    }

    @Override
    public void uploadFile(File file) {
        //
    }

    @Override
    public void uploadFile(MultipartFile file) {
        //
    }

    @Override
    public void uploadFile(String id, File file) {
        //
    }

    @Override
    public void uploadFile(String id, MultipartFile file) {
        if (file.isEmpty()) throw new RuntimeException(file.getName() + " is Empty.");
        try {
            s3Client.putObject(AWS3_DEFAULT_BUCKET, id, convert(file));
        } catch (AmazonServiceException ase) {
            ase.printStackTrace();
        } catch (AmazonClientException ace) {
            System.out.println("ERROR: " + ace.getMessage());
        }
    }

    @Override
    public File getFile(String id) {
        return null;
    }

    @Override
    public void updateFile(String id, File file) {
        //
    }

    @Override
    public void updateFile(String key, MultipartFile file) {
        deleteFile(key);
        uploadFile(key, file);
    }

    @Override
    public void deleteFile(String key) {
        try {
            s3Client.deleteObject(AWS3_DEFAULT_BUCKET, key);
        } catch (AmazonServiceException ase) {
            ase.printStackTrace();
        } catch (AmazonClientException ace) {
            System.out.println("ERROR: " + ace.getMessage());
        }
    }

    @Override
    public List<String> getAllFileUrl() {
        List<String> listUrls = new ArrayList<>();
        List<S3ObjectSummary> result = s3Client.listObjects(AWS3_DEFAULT_BUCKET).getObjectSummaries();
        for (S3ObjectSummary obj : result) {
            listUrls.add(genUrl(obj.getKey()));
        }
        return listUrls;
    }

    @Override
    public List<String> getFileUrlByKey(String id) {
        List<String> listUrls = new ArrayList<>();
        List<S3ObjectSummary> result = s3Client.listObjects(AWS3_DEFAULT_BUCKET, id).getObjectSummaries();
        for (S3ObjectSummary obj : result) {
            listUrls.add(genUrl(obj.getKey()));
        }
        return listUrls;
    }

    private String genUrl(String id) {
        return "https://s3-" + AWS3_REGION + ".amazonaws.com/" + AWS3_DEFAULT_BUCKET + "/" + id;
    }

    private File convert(MultipartFile file) {
        try {
            File convFile = new File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            return convFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
