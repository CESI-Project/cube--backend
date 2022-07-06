package com.svt.cube.entity;

public class TopicByCategories {
    private Integer topicsCount;
    private String tagsName;

    public TopicByCategories(Integer topicsCount, String tagsName) {
        this.topicsCount = topicsCount;
        this.tagsName = tagsName;
    }

    public Integer getTopicsCount() {
        return this.topicsCount;
    }

    public void setTopicsCount(Integer topicsCount) {
        this.topicsCount = topicsCount;
    }

    public String getTagsName() {
        return this.tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }
}
