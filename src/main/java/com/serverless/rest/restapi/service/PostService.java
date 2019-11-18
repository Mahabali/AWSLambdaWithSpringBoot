package com.serverless.rest.restapi.service;

import java.util.Collection;

import com.serverless.rest.restapi.model.*;
public interface PostService{
    public abstract Collection<Post> getAllPosts();
    public abstract void createPost(Post Post);
    public abstract void updatePost(Long id, Post Post);
    public abstract void deletePost(Long id);
}