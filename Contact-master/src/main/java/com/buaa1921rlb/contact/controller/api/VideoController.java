package com.buaa1921rlb.contact.controller.api;

import com.buaa1921rlb.contact.entity.Video;
import com.buaa1921rlb.contact.services.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class VideoController {
private VideoService videoService;
@GetMapping("/get1")
public Video getById(long id){
    return videoService.getById(id);
}
@GetMapping("/get2")
public String countByAuthor(Integer authorId){return videoService.countByAuthor(authorId).toString();}
@PostMapping("/videoupload")
    public Video VideoUpload(String filename, String nameByUser, Date uploadTime, String url){
    return videoService.VideoUpload(filename, nameByUser, uploadTime, url);
}
}
