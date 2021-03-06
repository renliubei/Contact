package com.buaa1921rlb.contact.controller.api;

import com.buaa1921rlb.contact.entity.other.RestResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static com.buaa1921rlb.contact.constant.FileType.*;
import static com.buaa1921rlb.contact.constant.UploadPath.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/file")
public class FileController {
    
    @PostMapping("/upload")
    RestResp uploadFile(@RequestParam("type") int fileType, MultipartFile file) {
        String path;
        switch(fileType) {
            case PICTURE_PORTRAIT: path = PICTURE_PORTRAIT_PATH;
            case PICTURE_VIDEO_SUB: path = PICTURE_VIDEO_SUB_PATH;
            case PICTURE_INTERACTIVE_VIDEO_SUB: path = PICTURE_INTERACTIVE_VIDEO_SUB_PATH;
            case VIDEO: path = VIDEO_PATH;
        }

        if(file.isEmpty())
            return RestResp.fail("文件为空, 请重试");
     return RestResp.OK;
    }
}
