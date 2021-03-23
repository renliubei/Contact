package com.buaa1921rlb.contact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "file", schema = "contact")
public class MyFile {

    @Id
    private Integer id;
    private String filename;
    private String nameByUser;
    @DateTimeFormat(pattern = "yyyy-mm-dd 'T' HH:mm:ss")
    private LocalDateTime uploadTime;
    private String url;
    private Integer authorId;
    private int fileType;
    private boolean deleted;

    public MyFile(MultipartFile file) {
        this.nameByUser = file.getOriginalFilename();
        this.uploadTime = LocalDateTime.now();
        this.deleted = false;
    }
}
