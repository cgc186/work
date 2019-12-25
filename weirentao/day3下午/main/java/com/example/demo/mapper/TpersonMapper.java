package com.example.demo.mapper;


import com.example.demo.entity.Tperson;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 说明：对人员表进行一系列操作
 * wrt
 * 编写时间：12-25
 * 修改时间：暂定
 */

public interface TpersonMapper {
    //对人员表进行添加
    @Insert("insert into Tperson(pid,Pname,password,email,createtime)values(#{pid},#{Pname},#{password},#{email},#{createtime})")
    int insertTperson(int pid);
    //对人员表进行修改
    @Update("update Tperson set pid=#{pid},Pname=#{Pname},password=#{password},email=#{email},createtime=#{createtime}where pid = #{pid}")
    int updateTperson(Tperson tperson) ;

    //对人员表进行删除
    @Delete("delete from Tperson where pid = #{pid}")
    int deleteTperson(int pid);
    //查询人员表所有内容
    @Select("select * from Tperson")
    List<Tperson> selectAllPids();

}
