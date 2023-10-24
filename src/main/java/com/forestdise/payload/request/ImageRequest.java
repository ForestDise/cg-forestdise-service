package com.forestdise.payload.request;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ImageRequest {
    private List<String> imagePath;

}
