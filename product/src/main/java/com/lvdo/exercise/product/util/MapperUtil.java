package com.lvdo.exercise.product.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author lvdo
 *
 */
@Component
public class MapperUtil {

    @Autowired
    private ModelMapper modelMapper;

    public <T, E> E convertToEntity(T dto, Class<E> clazz) {
        E e = modelMapper.map(dto, clazz);
        return e;
    }

    public <T, E> T convertToDto(E entity, Class<T> clazz) {
        T t = modelMapper.map(entity, clazz);
        return t;
    }

    public <T, E> List<T> convertToDto(List<E> entities, Class<T> clazz) {
        List<T> t = new ArrayList<T>();
        for (E e : entities) {
            T element = modelMapper.map(e, clazz);
            t.add(element);
        }
        return t;
    }

}
