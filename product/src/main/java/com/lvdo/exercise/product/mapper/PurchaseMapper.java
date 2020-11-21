package com.lvdo.exercise.product.mapper;

import java.util.Optional;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.lvdo.exercise.product.dto.PurchaseDto;
import com.lvdo.exercise.product.entity.PurchaseEntity;

/**
 * 
 * @author lvdo
 *
 */
@Component
public class PurchaseMapper {

    public PurchaseMapper(ModelMapper modelMapper, MessageSource messageSource) {
        modelMapper.createTypeMap(PurchaseEntity.class, PurchaseDto.class)
                .setPostConverter(new Converter<PurchaseEntity, PurchaseDto>() {

                    @Override
                    public PurchaseDto convert(MappingContext<PurchaseEntity, PurchaseDto> context) {
                        PurchaseDto dto = Optional.ofNullable(context.getDestination()).orElse(new PurchaseDto());
                        PurchaseEntity entity = context.getSource();
                        dto.setItemId(entity.getItemEntity().getId());
                        return dto;
                    }
                });
    }

}
