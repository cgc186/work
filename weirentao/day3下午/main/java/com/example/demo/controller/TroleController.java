package com.example.demo.controller;

import com.example.demo.entity.Trole;
import com.example.demo.mapper.TroleMapper;
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
public class TroleController { @Autowired
private TroleMapper troleMapper;
    @ApiOperation(value ="用户添加")
    @GetMapping("/addRole")
    public int AddRole(Trole trole ){
        if(trole!=null){
            if(trole.getRid()!=0) {
                //是否可以添加此主键
            }
        }
        return troleMapper.insertTrole(trole);
    }

    @ApiOperation(value ="更新信息")
    @PostMapping("/updateTrole")
    public int updateUser(Trole trole){
        return TroleMapper.updateTrole;
    }
    @ApiOperation(value ="删除信息")
    @GetMapping("/deleteUser")
    public int deleteUser(int rid){
        return TroleMapper.deleteTrole(rid);
    }
    @ApiOperation(value ="查询信息")
    @GetMapping("/selectAllrids")
    public List<Trole> selectAllTroles(){
        return TroleMapper.selectAlltroles();
    }
}
