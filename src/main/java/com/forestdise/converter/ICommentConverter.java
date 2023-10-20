package com.forestdise.converter;

import com.forestdise.dto.CommentDto;
import com.forestdise.entity.Comment;

import java.util.List;

public interface ICommentConverter {
    List<CommentDto> entitiesToDTOs(List<Comment> element);
    CommentDto entityToDTO(Comment element);
    Comment dtoToEntity(CommentDto element);
}
