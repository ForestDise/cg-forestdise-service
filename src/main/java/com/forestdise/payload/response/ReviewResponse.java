package com.forestdise.payload.response;

import com.forestdise.dto.ReviewDto;
import com.forestdise.dto.SummaryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private List<ReviewDto> reviewDtoList;
    private SummaryDto summaryDto;
    // % cua moi sao
    //tong so review
    // trung binh sao
}
