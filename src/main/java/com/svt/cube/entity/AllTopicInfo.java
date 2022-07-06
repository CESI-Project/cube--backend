package com.svt.cube.entity;

import java.util.Set;

public class AllTopicInfo {

    private Topic topic;
    private Set<CommentAndSubComments> commentsAndSubComments;

    public AllTopicInfo(Topic topic, Set<CommentAndSubComments> commentsAndSubComments) {
        this.topic = topic;
        this.commentsAndSubComments = commentsAndSubComments;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<CommentAndSubComments> getCommentsAndSubComments() {
        return this.commentsAndSubComments;
    }

    public void setCommentsAndSubComments(Set<CommentAndSubComments> commentsAndSubComments) {
        this.commentsAndSubComments = commentsAndSubComments;
    }

}