package com.buaa1921rlb.contact.services.impl;

import com.buaa1921rlb.contact.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

import static com.buaa1921rlb.contact.constant.StatusType.FAIL;
import static com.buaa1921rlb.contact.constant.StatusType.SUCCESS;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public Integer addFile(String path, MultipartFile file) {

        File targetFile = new File(path);
        if (!targetFile.exists()) targetFile.mkdir();

        try (FileOutputStream out = new FileOutputStream(path + file.getOriginalFilename());) {
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return FAIL;
        }
        return SUCCESS;
    }

    @Override
    public Integer getFileById(String path, String fileId) {
        return null;
    }

    @Override
    public Integer deleteFile(String path, String fileName) {
        return null;
    }
}
