package com.forestdise.controller.sellingController;

import com.forestdise.dto.VideoDTO;
import com.forestdise.entity.Video;
import com.forestdise.payload.request.VideoRequest;
import com.forestdise.payload.response.VideoCreateResponse;
import com.forestdise.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/video/{variant_id}")
public class VideoController {
    private final VideoServiceImpl videoService;

    @Autowired
    public VideoController(VideoServiceImpl videoService ) {
        this.videoService = videoService;
    }
    @PostMapping("/create")
    public ResponseEntity<VideoCreateResponse> createVideo(@RequestBody VideoRequest videoRequest, @PathVariable("variant_id") Long variant_id){
        VideoCreateResponse videoCreateResponse= new VideoCreateResponse();
        VideoDTO videoDto = VideoDTO.builder()
                .videoPath(videoRequest.getVideoPath())
                .build();

        Video video =videoService.createVideo(videoDto,variant_id);
        if (video != null) {
            videoCreateResponse.setMessage("Video created successfully");
            videoCreateResponse.setVideoId(video.getId());
            return new ResponseEntity<>(videoCreateResponse, HttpStatus.CREATED);
        } else {
            videoCreateResponse.setMessage("Failed to create Video");
            return new ResponseEntity<>(videoCreateResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
