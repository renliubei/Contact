package com.buaa1921rlb.contact.entity;

public class VideoCut {
    //its own Id
    private long Id;
    //its  own name
    private String name;
    //its own description
    private String description;
    //url of the cover
    private String coverUrl;
    //url of the resource
    private String sourceUrl;
    private Integer authorId;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    public String toString(){
        return "Id:"+Id+"name:"+name+"`description`:"+description+"`coverUrl:"+coverUrl;
    }
}
