package com.cybersecure.tokenbasedapi.controller;

import com.cybersecure.tokenbasedapi.models.Post;
import com.cybersecure.tokenbasedapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/getAllPost")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/post")
    public ResponseEntity<Post> savePostDetails(@RequestBody Post post){
        return new ResponseEntity<>(postService.savePostDetails(post), HttpStatus.CREATED);
    }
}
