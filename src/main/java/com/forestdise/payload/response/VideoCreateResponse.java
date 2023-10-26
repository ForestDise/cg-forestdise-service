package com.forestdise.payload.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.forestdise.entity.StoreCategory;
import com.forestdise.entity.Variant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoCreateResponse {
    private Long videoId;

    private String message;
}
