package com.springboot.sample.dao.accident;

import com.springboot.sample.entity.Accident;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface accidentMapper {
    void save(Accident accident);
}
