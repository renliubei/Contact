package com.buaa1921rlb.contact.entity;

import lombok.Data;

import java.util.List;

@Data
public class VideoProject {
    //project's own id
    private long Id;
    //project's own name
    private String name;
    //project's own description
    private String description;

    //all nodes of videoCuts
    private List<VideoNode> videoNodeList;
    //temp left nodes which is used faster
    private List<VideoNode> isolateNodeList;

    //url of the cover
    private String coverUrl;
    public String toString(){
        return "Id:"+this.Id+"\nName:"+this.name+"\nDescription"+this.description+"\nCoverUrl"+this.coverUrl;
    }
}
 class VideoNode{
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
