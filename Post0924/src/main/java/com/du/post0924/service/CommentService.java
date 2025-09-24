package com.du.post0924.service;


import com.du.post0924.domain.Comment;
import com.du.post0924.mapper.CommentMappler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMappler commentMappler;

    public List<Comment> getCommentsByPostId(Long postId){
        return commentMappler.findByPostId(postId);
    }

    public void addComment(Comment comment){
        commentMappler.insert(comment);
    }
}
