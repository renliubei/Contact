package com.buaa1921rlb.contact.services.impl;

import com.buaa1921rlb.contact.dao.VideoDao;
import com.buaa1921rlb.contact.entity.Video;
import com.buaa1921rlb.contact.entity.VideoProject;
import com.buaa1921rlb.contact.services.VideoService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VideoServiceImpl implements VideoService {
private final VideoDao videoDao;
public VideoServiceImpl(VideoDao videoDao){this.videoDao=videoDao;}
@Override
public Video getById(long id){
return videoDao.selectVideoByid(id);
}
@Override
    public Video VideoUpload(String filename, String nameByUser, Date uploadTime, String url){
     videoDao.insertVideo(filename, nameByUser, uploadTime, url);
     return new Video();
    }
    @Override
    public Video countByAuthor(Integer authorId){
    videoDao.countByAuthor(authorId);
    return new Video();
    }
}
