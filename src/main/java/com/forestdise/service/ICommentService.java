package com.forestdise.service;

import com.forestdise.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentService {
    public List<CommentDto> getCommentsByReviewId(Long reviewId);
}
