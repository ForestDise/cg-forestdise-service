package com.forestdise.service;

import com.forestdise.entity.Bullet;
import com.forestdise.entity.HashTag;

import java.util.List;

public interface IBulletService {
    List<Bullet> createBullet(List<String> bulletlist, Long productId);

}
