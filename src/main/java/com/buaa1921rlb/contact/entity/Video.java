package com.buaa1921rlb.contact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Video {

    private Integer id;
    private String filename;
    private String nameByUser;
    @DateTimeFormat(pattern = "yyyy-mm-dd 'T' HH:mm:ss")
    private Date uploadTime;
    private String url;
    private Integer authorId;
}
