package com.serverless.rest.restapi.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.serverless.rest.restapi.model.Post;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private static Map<Long, Post> PostMap = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();
    public void createPost(Post Post){
        Post.setId(counter.incrementAndGet());
        PostMap.put(Post.getId(), Post);
    }
    public void updatePost(Long id, Post Post) {
        PostMap.remove(id);
        Post.setId(id);
        PostMap.put(Post.getId(), Post);
    }

    public void deletePost(Long id) {
        PostMap.remove(id);
        System.out.println("deleting " + id + " values count " + PostMap.values().size());
    }

    public Collection<Post> getAllPosts() {
        System.out.println(" values count " + PostMap.values().size());
        return PostMap.values();
    }

    
}