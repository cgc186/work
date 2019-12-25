package com.example.demo.mapper;


import com.example.demo.entity.Trole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 说明：对角色表进行一系列操作
 * wrt
 * 编写时间：12-25
 * 修改时间：暂定
 */

public interface TroleMapper {
    //对角色表进行添加
    @Insert("insert into Trole(rid,Rname,note)values(#{rid},#{Rname},#{note})")
    int insertTrole(int rid);
    //对角色表进行修改
    @Update("update Trole set rid=#{rid},Rname=#{Rname},note=#{note}where rid = #{rid}")
    int updateTrole(Trole trole) ;

    //对角色表进行删除
    @Delete("delete from Trole where rid = #{rid}")
    int deleteTrole(int rid);
    //查询角色表所有内容
    @Select("select * from Trole")
    List<Trole> selectAllTroles();

}
