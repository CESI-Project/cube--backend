package com.svt.cube.entity;

import java.util.List;

public class StatistiquesInformation {
    List<Topic> topics;
    Integer myTotalViews;
    Integer totalUsers;
    Integer totalTopics;
    Integer totalTags;
    Integer totalTopicViews;
    Integer totalComments;
    Integer totalResponseComments;
    Integer averageCommentsByTopic;
    Integer averageResponseCommentsByTopic;
    List<TopicByCategories> totalTopicsByCategories;

    public StatistiquesInformation(List<Topic> topics, Integer myTotalViews, Integer totalUsers, Integer totalTopics,
            Integer totalTags, Integer totalTopicViews, Integer totalComments, Integer totalResponseComments,
            Integer averageCommentsByTopic, Integer averageResponseCommentsByTopic,
            List<TopicByCategories> totalTopicsByCategories) {
        this.topics = topics;
        this.myTotalViews = myTotalViews;
        this.totalUsers = totalUsers;
        this.totalTopics = totalTopics;
        this.totalTags = totalTags;
        this.totalTopicViews = totalTopicViews;
        this.totalComments = totalComments;
        this.totalResponseComments = totalResponseComments;
        this.averageCommentsByTopic = averageCommentsByTopic;
        this.averageResponseCommentsByTopic = averageResponseCommentsByTopic;
        this.totalTopicsByCategories = totalTopicsByCategories;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public Integer getMyTotalViews() {
        return myTotalViews;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public Integer getTotalTopics() {
        return totalTopics;
    }

    public Integer getTotalTags() {
        return totalTags;
    }

    public Integer getTotalTopicViews() {
        return totalTopicViews;
    }

    public Integer getTotalComments() {
        return totalComments;
    }

    public Integer getTotalResponseComments() {
        return totalResponseComments;
    }

    public Integer getAverageCommentsByTopic() {
        return averageCommentsByTopic;
    }

    public Integer getAverageResponseCommentsByTopic() {
        return averageResponseCommentsByTopic;
    }

    public List<TopicByCategories> getTotalTopicsByCategories() {
        return totalTopicsByCategories;
    }
}
