package com.forestdise.service.impl;

import com.forestdise.converter.ICommentConverter;
import com.forestdise.dto.CommentDto;
import com.forestdise.entity.Comment;
import com.forestdise.repository.CommentRepository;
import com.forestdise.service.ICommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    private CommentRepository commentRepository;
    private ICommentConverter commentConverter;

    public CommentServiceImpl(CommentRepository commentRepository, ICommentConverter commentConverter) {
        this.commentRepository = commentRepository;
        this.commentConverter = commentConverter;
    }

    @Override
    public List<CommentDto> getCommentsByReviewId(Long reviewId) {
        List<Comment> commentList = commentRepository.getCommentsByReviewId(reviewId);
        List<CommentDto> commentDtoList = commentConverter.entitiesToDTOs(commentList);
        return commentDtoList;
    }
}
