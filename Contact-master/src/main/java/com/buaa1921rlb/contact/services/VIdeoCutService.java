package com.buaa1921rlb.contact.services;

import com.buaa1921rlb.contact.entity.VideoCut;

public interface VIdeoCutService {
    VideoCut getById(long id);
    VideoCut countByAuthor(Integer authorId);
}
