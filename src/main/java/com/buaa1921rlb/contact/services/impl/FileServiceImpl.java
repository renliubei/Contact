package com.buaa1921rlb.contact.services.impl;

import com.buaa1921rlb.contact.dao.FileDao;
import com.buaa1921rlb.contact.dao.UserDao;
import com.buaa1921rlb.contact.entity.MyFile;
import com.buaa1921rlb.contact.entity.User;
import com.buaa1921rlb.contact.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static com.buaa1921rlb.contact.constant.StatusType.FAIL;
import static com.buaa1921rlb.contact.constant.StatusType.SUCCESS;

@Service
public class FileServiceImpl implements FileService {

    private final FileDao fileDao;
    private final UserDao userDao;

    public FileServiceImpl(FileDao fileDao, UserDao userDao) {
        this.fileDao = fileDao;
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public Integer addFile(User user, int fileType, String path, MultipartFile file) {

        try {
            String filename = fileType + user.getMobile() + (fileDao.countByAuthorAndType(fileType, user.getId()) + 1);
            String OriginalFileName = file.getOriginalFilename();
            String suffixName = OriginalFileName.substring(OriginalFileName.lastIndexOf("."));
            File targetFile = new File(path + "\\" + filename + suffixName);
            if (!targetFile.exists()) targetFile.mkdir();
            file.transferTo(targetFile);

            // FileOutputStream out = new FileOutputStream(path);
            // out.write(file.getBytes());

            MyFile myFile = new MyFile(file);
            myFile.setFileType(fileType);
            myFile.setFilename(filename);
            myFile.setAuthorId(user.getId());
            myFile.setUrl(path + "\\" + myFile.getFilename());
            if (1 != fileDao.insertFile(myFile)) return FAIL;
        } catch (Exception e) {
            e.printStackTrace();
            return FAIL;
        }
        return SUCCESS;
    }

    @Override
    public MyFile getFileById(Integer fileId) {
        return fileDao.selectFileById(fileId);
    }

    @Override
    public Integer deleteFile(String path, String fileName) {
        return null;
    }
}
