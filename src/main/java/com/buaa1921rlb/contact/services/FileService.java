package com.buaa1921rlb.contact.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 上传文件
     *
     * @param path 文件路径
     * @param file 文件
     * @return 成功返回 1
     */
    Integer addFile(String path, MultipartFile file);

    /**
     * 删除文件
     *
     * @param path     文件路径
     * @param fileName 文件名
     * @return 成功返回 1
     */
    Integer deleteFile(String path, String fileName);
}
