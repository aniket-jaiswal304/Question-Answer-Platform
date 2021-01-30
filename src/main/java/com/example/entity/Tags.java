package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tags {

    @SequenceGenerator(initialValue = 1, sequenceName = "tagSeq", name = "tagSeq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="tagSeq" )
    private int tagId;
    private String tag;

    public Tags() {
    }

    public Tags(int tagId, String tag) {
        this.tagId = tagId;
        this.tag = tag;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TagInfo{" +
                "tagId=" + tagId +
                ", tag='" + tag + '\'' +
                '}';
    }
}
