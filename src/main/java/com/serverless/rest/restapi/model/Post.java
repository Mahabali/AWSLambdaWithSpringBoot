package com.serverless.rest.restapi.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Post {
    private  long id;
    @NotNull(message = "Please provide a content")
    @NotEmpty(message = "Please provide a content")
    private  String content;

    // public Post(long id, String content) {
    //     this.id = id;
    //     this.content = content;
    // }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
     }
}