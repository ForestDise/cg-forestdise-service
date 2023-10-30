package com.forestdise.payload.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductRequest {
    private String title;
    private String description;
    private String mainPicture;

}
