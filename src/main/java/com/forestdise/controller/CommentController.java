package com.forestdise.controller;

import com.forestdise.dto.CommentDto;
import com.forestdise.payload.response.CommentResponse;
import com.forestdise.service.ICommentService;
import com.forestdise.service.impl.CommentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/comments")
@AllArgsConstructor
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/{review_id}")
    public ResponseEntity<CommentResponse> getCommentsByReviewId(@PathVariable("review_id") Long reviewId){
        CommentResponse commentResponse = new CommentResponse();
        List<CommentDto> commentDtoList = commentService.getCommentsByReviewId(reviewId);
         commentResponse.setCommentDtoList(commentDtoList);
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);

    }
}
