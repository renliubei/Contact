package com.buaa1921rlb.contact.services.impl;

import com.buaa1921rlb.contact.dao.VideoCutDao;
import com.buaa1921rlb.contact.entity.VideoCut;
import com.buaa1921rlb.contact.services.VIdeoCutService;
import org.springframework.stereotype.Service;

@Service
public class VideoCutServiceImpl implements VIdeoCutService {
    private final VideoCutDao videoCutDao;
    public VideoCutServiceImpl(VideoCutDao videoCutDao){this.videoCutDao=videoCutDao;}
    @Override
    public VideoCut getById(long Id){return videoCutDao.selectVideoCutByid(Id);}
    @Override
    public VideoCut countByAuthor(Integer authorId){return videoCutDao.countByAuthor(authorId);}
}
