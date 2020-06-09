package com.springboot.sample.service.accident.impl;

import com.springboot.sample.dao.accident.accidentMapper;
import com.springboot.sample.entity.Accident;
import com.springboot.sample.service.accident.accidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class accidentServiceImpl implements accidentService {

    @Autowired
    private accidentMapper accidentMapper;

    @Override
    public void saveAccident(Accident accident) {
        accident.setAccidentId(UUID.randomUUID().toString());
        accident.setAccidentTitle("事故1");
        accidentMapper.save(accident);
    }
}
