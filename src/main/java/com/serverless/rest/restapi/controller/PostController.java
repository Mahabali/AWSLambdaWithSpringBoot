package com.serverless.rest.restapi.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.serverless.rest.restapi.model.Post;
import com.serverless.rest.restapi.service.PostService;
import com.serverless.rest.restapi.service.PostServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@RestController
public class PostController {

 
    PostService PostService = new PostServiceImpl();

    @RequestMapping(value = "/post", method = RequestMethod.POST)
   public ResponseEntity<Object> createPost(@RequestBody Post content) {
      System.out.println("" + content.getId() + "  " + content.getContent());
      PostService.createPost(content);
      return new ResponseEntity<>("Post is created successfully", HttpStatus.CREATED);
   }

   @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
      Long newId = Long.valueOf(id);
      PostService.deletePost(newId);
      return new ResponseEntity<>("Post is deleted successsfully", HttpStatus.OK);
   }

   @RequestMapping(value = "/posts")
   public ResponseEntity<Object> getPost() {
     
    return new ResponseEntity<>(PostService.getAllPosts(), HttpStatus.OK);
   }

   @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> 
      updatePost(@PathVariable("id") String id, @RequestBody Post Post) {
        Long newId = Long.valueOf(id);
      PostService.updatePost(newId, Post);
      return new ResponseEntity<>("Post is updated successsfully", HttpStatus.OK);
   }
}