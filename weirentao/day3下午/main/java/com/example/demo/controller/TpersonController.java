package com.example.demo.controller;

import com.example.demo.entity.Tperson;
import com.example.demo.mapper.TpersonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Api(tags="user")
@RestController
@EnableSwagger2
public class TpersonController { @Autowired
private TpersonMapper tpersonMapper;
    @ApiOperation(value ="用户添加")
    @GetMapping("/addPerson")
    public int AddPerson(Tperson tperson ){
        if(tperson!=null){
            if(tperson.getPid()!=0) {

            }
        }
        return tpersonMapper.insertTperson(int pid);
    }

    @ApiOperation(value ="更新信息")
    @PostMapping("/updateTperson")
    public int updateTperson(Tperson tperson){
        return TpersonMapper.updateTperson;
    }
    @ApiOperation(value ="删除信息")
    @GetMapping("/deleteTperson")
    public int deleteTperson(int pid){
        return TpersonMapper.deleteTperson(pid);
    }
    @ApiOperation(value ="查询信息")
    @GetMapping("/selectAllPids")
    public List<Tperson> selectAllPids(){
        return TpersonMapper.selectAllPids();
    }
}
