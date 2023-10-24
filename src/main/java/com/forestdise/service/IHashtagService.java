package com.forestdise.service;

import com.forestdise.entity.HashTag;
import com.forestdise.entity.Image;

import java.util.List;

public interface IHashtagService {
    List<HashTag> createHashtag(List<String> hashtagList, Long productId);
}
