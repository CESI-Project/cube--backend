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
    List<TopicByCategories> TotalTopicsByCategories;

    public StatistiquesInformation(List<Topic> topics, Integer myTotalViews, Integer totalUsers, Integer totalTopics,
            Integer totalTags, Integer totalTopicViews, Integer totalComments, Integer totalResponseComments,
            Integer averageCommentsByTopic, Integer averageResponseCommentsByTopic,
            List<TopicByCategories> TotalTopicsByCategories) {
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
        this.TotalTopicsByCategories = TotalTopicsByCategories;
    }
}
