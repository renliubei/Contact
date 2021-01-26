package com.buaa1921rlb.contact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Video {
    private Integer id;
    private Integer[] parent;
    private Integer[] child;
    private Integer[] author;
}