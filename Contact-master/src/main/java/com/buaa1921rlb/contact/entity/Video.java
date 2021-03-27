package com.buaa1921rlb.contact.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Video {

    private long id;
    private String filename;
    private String nameByUser;
    private String description;
    @DateTimeFormat(pattern = "yyyy-mm-dd 'T' HH:mm:ss")
    private Date uploadTime;
    private String url;
    private Integer authorId;
    private class VideoNode{
        //the id of the videoCut
        private long Id;
        //the name of the videoCut
        private String name;

        //list of its fathers' index
        private List<Integer> fathers;
        //the index of its parent that was last accessed it
        private int lastNodeIndex;

        //list of its sons' index
        private List<Integer> sons;

        //its own index in the list
        private int index;
    }
    public String toString(){
        return "id:"+id+"name:"+filename+"description:"+description+"`coverUrl:"+url;
    }
}
