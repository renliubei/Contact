package com.buaa1921rlb.contact.services;

import com.buaa1921rlb.contact.entity.MyFile;
import com.buaa1921rlb.contact.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 上传文件
     *
     * @param user     对应用户
     * @param fileType 文件类型
     * @param path     文件路径
     * @param file     文件
     * @return 成功返回 1
     */
    Integer addFile(User user, int fileType, String path, MultipartFile file);

    /**
     * 根据文件名查找文件
     *
     * @param fileId 文件 id
     * @return 成功返回 file
     */
    MyFile getFileById(Integer fileId);


    /**
     * 删除文件
     *
     * @param path     文件路径
     * @param fileName 文件名
     * @return 成功返回 1
     */
    Integer deleteFile(String path, String fileName);
}
