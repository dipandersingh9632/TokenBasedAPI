package com.cybersecure.tokenbasedapi.service;

import com.cybersecure.tokenbasedapi.models.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAllPost();
    public Post savePostDetails(Post post);
}
