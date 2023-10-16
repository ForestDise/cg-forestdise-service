package com.forestdise.service;

import com.forestdise.dto.CommentDto;

import java.util.List;

public interface ICommentService {
    public List<CommentDto> getCommentsByReviewId(Long reviewId);
}
