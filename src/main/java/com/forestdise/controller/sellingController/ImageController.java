package com.forestdise.controller.sellingController;

import com.forestdise.dto.ImageDTO;
import com.forestdise.entity.Image;
import com.forestdise.payload.request.ImageRequest;
import com.forestdise.payload.response.ImageCreateResponse;
import com.forestdise.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/image/{variant_id}")
public class ImageController {
    public final ImageServiceImpl imageService;
    @Autowired
    public ImageController(ImageServiceImpl imageService ) {
        this.imageService = imageService;
    }
    @PostMapping("/create")
    public ResponseEntity<ImageCreateResponse> createImage(@RequestBody ImageRequest imageRequest, @PathVariable("variant_id") Long variant_id){
        ImageCreateResponse imageCreateResponse= new ImageCreateResponse();
        ImageDTO imageDto = ImageDTO.builder()
                .imgPath(imageRequest.getImagePath())
                .build();
        Image image =imageService.createImage(imageDto,variant_id);
        if (image != null) {
            imageCreateResponse.setMessage("Image created successfully");
            imageCreateResponse.setImageId(image.getId());
            return new ResponseEntity<>(imageCreateResponse, HttpStatus.CREATED);
        } else {
            imageCreateResponse.setMessage("Failed to create Image");
            return new ResponseEntity<>(imageCreateResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
