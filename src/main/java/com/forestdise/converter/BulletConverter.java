package com.forestdise.converter;

import com.forestdise.dto.BulletDTO;
import com.forestdise.entity.Bullet;

import java.util.List;

public interface IBulletConverter {
    List<BulletDTO> entitiesToDTOs(List<Bullet> element);
    BulletDTO entityToDTO(Bullet element);
    Bullet dtoToEntity(BulletDTO element);
}
