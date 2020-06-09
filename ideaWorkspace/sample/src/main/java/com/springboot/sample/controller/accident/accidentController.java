package com.springboot.sample.controller.accident;

import com.springboot.sample.common.BaseResult;
import com.springboot.sample.entity.Accident;
import com.springboot.sample.service.accident.accidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/accident")
public class accidentController {

    @Autowired
    private accidentService accidentService;

    @RequestMapping("/save")
    public BaseResult saveAccident(){
        try {
            Accident accident = new Accident();
            accidentService.saveAccident(accident);
            return new BaseResult(null,true);
        }catch (Exception e) {
            System.err.println(e);
            return new BaseResult("保存事故信息失败",null,false);
        }
    }
}
