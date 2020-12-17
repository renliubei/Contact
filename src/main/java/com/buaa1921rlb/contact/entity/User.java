package com.buaa1921rlb.contact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String mobile;
    private Integer sex;
    private String token;
    @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss")
    private Date registrationTime;
    private Boolean deleted;

    public void removeSensitiveData() {
        this.password = null;
        this.token = null;
    }
}
