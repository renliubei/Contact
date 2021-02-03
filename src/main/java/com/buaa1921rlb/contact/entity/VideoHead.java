package com.buaa1921rlb.contact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class VideoHead {
    private String id;
    private Integer size;
    private Integer[] author;
    private LogicTree logicTree;
}
