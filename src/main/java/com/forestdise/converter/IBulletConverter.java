package com.forestdise.converter;

import com.forestdise.dto.BulletDto;
import com.forestdise.entity.Bullet;

import java.util.List;

public interface IBulletConverter {
    List<BulletDto> entitiesToDTOs(List<Bullet> element);
    BulletDto entityToDTO(Bullet element);
    Bullet dtoToEntity(BulletDto element);
}
