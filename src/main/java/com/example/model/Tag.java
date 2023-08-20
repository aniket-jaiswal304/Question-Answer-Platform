package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "TAGS")
public class Tag {

    @Id
    @SequenceGenerator(initialValue = 1, sequenceName = "tagSeq", name = "tagSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="tagSeq" )
    @Column(name = "ID")
    private int tagId;
    @Column(name = "NAME")
    private String tagName;

    public Tag() {
    }

    public Tag(String tag) {
        this.tagName = tag;
    }

    public Tag(int tagId, String tag) {
        this.tagId = tagId;
        this.tagName = tag;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "TagInfo{" +
                "tagId=" + tagId +
                ", tag='" + tagName + '\'' +
                '}';
    }
}
