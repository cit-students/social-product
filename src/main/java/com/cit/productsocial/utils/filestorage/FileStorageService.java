package com.cit.productsocial.utils.filestorage;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileStorageService {
    void createDir(String dirName);
    void uploadFile(File file);
    void uploadFile(MultipartFile file);
    void uploadFile(String id, File file);
    void uploadFile(String id, MultipartFile file);
    File getFile(String id);
    void updateFile(String id, File file);
    void updateFile(String id, MultipartFile file);
    void deleteFile(String id);
    List getAllFileUrl();
    List getFileUrlByKey(String id);
}
