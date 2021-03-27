package com.buaa1921rlb.contact.services;

import com.buaa1921rlb.contact.entity.Video;
import com.buaa1921rlb.contact.entity.VideoProject;

import java.util.Date;

public interface VideoService {
    Video getById(long id);
    public Video VideoUpload( String filename, String nameByUser, Date uploadTime, String url);
    public Video countByAuthor(Integer authorId);
}
