package com.forestdise.dto;
<<<<<<< HEAD

=======
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {
    private Long id;
    private String sellerName;
    private String email;
    private String password;
    private Double balance;
}
