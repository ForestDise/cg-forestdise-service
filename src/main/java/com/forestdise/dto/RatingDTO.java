package com.forestdise.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatingDTO {
    private double percentage;
    private int count;
    public RatingDTO(int count, double percentage){
        this.count=count;
        this.percentage=percentage;
    }
}
