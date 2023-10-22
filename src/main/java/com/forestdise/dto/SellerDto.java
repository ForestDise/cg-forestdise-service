package com.forestdise.dto;

import com.forestdise.entity.Address;
import com.forestdise.entity.Comment;
import com.forestdise.entity.Store;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class SellerDto {
    private Long id;
    private String sellerName;
    private String email;
    private Set<Address> address;
    private List<Store> storeList;
    private List<Comment> storeComments;

}
