package com.forestdise.converter.impl;

import com.forestdise.converter.IBulletConverter;
import com.forestdise.dto.BulletDto;
import com.forestdise.entity.Bullet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class BulletConverterImpl implements IBulletConverter {
    @Override
    public List<BulletDto> entitiesToDTOs(List<Bullet> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BulletDto entityToDTO(Bullet element) {
        BulletDto result = new BulletDto();
        BeanUtils.copyProperties(element, result);
        return result;    }

    @Override
    public Bullet dtoToEntity(BulletDto element) {
        Bullet result = new Bullet();
        BeanUtils.copyProperties(element, result);
        return result;    }
}
