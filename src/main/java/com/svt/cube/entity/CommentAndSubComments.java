package com.svt.cube.entity;

import java.util.List;

public class CommentAndSubComments {
    private Comment comment;
    private List<ResponseComment> responseComments;

    public CommentAndSubComments(Comment comment, List<ResponseComment> responseComments) {
        this.comment = comment;
        this.responseComments = responseComments;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<ResponseComment> getResponseComments() {
        return this.responseComments;
    }

    public void setResponseComments(List<ResponseComment> responseComments) {
        this.responseComments = responseComments;
    }
}