package com.forestdise.converter.impl;

import com.forestdise.converter.ICommentConverter;
import com.forestdise.dto.CommentDto;
import com.forestdise.entity.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CommentConverterImpl implements ICommentConverter {
    @Override
    public List<CommentDto> entitiesToDTOs(List<Comment> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto entityToDTO(Comment element) {
        CommentDto result = new CommentDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public Comment dtoToEntity(CommentDto element) {
        Comment result = new Comment();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}
