package com.example.model;

public class TagInfo
{
    private int tagId;
    private String tag;

    public TagInfo() {
    }

    public TagInfo(int tagId, String tag) {
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
}
