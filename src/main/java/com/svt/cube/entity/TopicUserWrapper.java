package com.svt.cube.entity;

public class TopicUserWrapper {
    User user;
    Topic topic;

    public TopicUserWrapper() {
    }

    public TopicUserWrapper(User user, Topic topic) {
        this.user = user;
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
