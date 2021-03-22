package com.buaa1921rlb.contact.controller.api;

import com.buaa1921rlb.contact.entity.MyFile;
import com.buaa1921rlb.contact.entity.User;
import com.buaa1921rlb.contact.entity.other.RestResp;
import com.buaa1921rlb.contact.services.FileService;
import com.buaa1921rlb.contact.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static com.buaa1921rlb.contact.constant.FileType.*;
import static com.buaa1921rlb.contact.constant.StatusType.SUCCESS;
import static com.buaa1921rlb.contact.constant.UploadPath.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;
    UserService userService;

    @PostMapping("/upload")
    RestResp uploadFile(@RequestParam("type") int fileType,
                        @RequestParam("id") Integer authorId,
                        MultipartFile file) {
        User user = userService.getUserById(authorId);
        String path = getFilePath(fileType);
        if (path.equals("")) return RestResp.fail("文件类型错误");
        if (file.isEmpty())
            return RestResp.fail("文件为空, 请重试");
        if (SUCCESS != fileService.addFile(user, fileType, path, file))
            return RestResp.fail("添加失败");
        return RestResp.OK;
    }

    @PostMapping("/download")
    RestResp downloadFile(@RequestParam("type") int fileType,
                          @RequestParam("id") Integer fileId,
                          HttpServletResponse response) throws UnsupportedEncodingException {
        String path = getFilePath(fileType);
        if (path.equals("")) return RestResp.fail("文件类型错误");
        MyFile myFile = fileService.getFileById(fileId);
        if (null == myFile) return RestResp.fail("无文件");

        File file = new File(myFile.getUrl());
        if (!file.exists()) return RestResp.fail("无文件");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        // response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(myFile.getNameByUser(), "UTF-8"));
        byte[] buffer = new byte[1024];
        FileInputStream fis = null; //文件输入流
        BufferedInputStream bis = null;

        OutputStream os = null; //输出流
        try {
            os = response.getOutputStream();
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer);
                i = bis.read(buffer);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            bis.close();
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return RestResp.fail("下载失败,请重试");
        }
        return RestResp.OK;
    }

    private String getFilePath(int fileType) {
        switch (fileType) {
            case PICTURE_PORTRAIT:
                return PICTURE_PORTRAIT_PATH;
            case PICTURE_VIDEO_SUB:
                return PICTURE_VIDEO_SUB_PATH;
            case PICTURE_INTERACTIVE_VIDEO_SUB:
                return PICTURE_INTERACTIVE_VIDEO_SUB_PATH;
            case VIDEO:
                return VIDEO_PATH;
        }
        return "";
    }
}
