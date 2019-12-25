package com.example.demo03work.mapper

import com.example.demo03work.entity.User
import org.apache.ibatis.annotations.*

/**
 * 说明: 对用户表进行操作
 * 编写人: 蔡
 * 编写时间: 2019-12-25
 * 修改时间:
 */
@Mapper //mapper直接加载包 scan是引进包
interface UserMapper {

    @Insert("insert into user" +
            "(id, appid, username, passwd, createTime)" +
            "VALUES (\n" +
            "#{id,jdbcType= INTEGER},\n" +
            "#{appid,jdbcType=INTEGER},\n" +
            "#{username,jdbcType=VARCHAR},\n" +
            "#{passwd,jdbcType=VARCHAR},\n" +
            "#{createTime,jdbcType=TIMESTAMP} )")
    fun insertUser(tuser: User): Int

    @Delete("DELETE FROM user WHERE id=#{id}")
    fun deleteUser(id: Int): Int

    /**
     * 更新用户信息
     * @return 是否成功
     */
    @Update("<script>" +
            "UPDATE user" +
            "<set>" +
            "<if test=\"appid != null and appid != '' \">\n" +
                "appid = #{appid,jdbcType=INTEGER},\n" +
            "</if>\n" +
            "<if test=\"username != null and username != '' \">\n" +
                "username=#{username,jdbcType=VARCHAR},\n" +
            "</if>\n" +
            "<if test=\"passwd != null and passwd != '' \">\n" +
                "passwd=#{passwd,jdbcType=VARCHAR},\n" +
            "</if>\n" +
            "<if test=\"createTime != null\">\n" +
                "createTime=#{createTime,jdbcType=TIMESTAMP}\n" +
            "</if>\n" +
            "</set>" +
            "WHERE id = #{id}" +
            "</script>")
    fun updateUser(tuser: User): Int

    /**
     * 根据条件获得用户
     * @return 用户列表
     */
    @Select("<script>" +
            "SELECT id,appid,username,passwd,createTime FROM user\n" +
            "        <where>\n" +
            "            <if test=\"id!=null and id!=''\">\n" +
            "                id = #{id}\n" +
            "            </if>\n" +
            "            <if test=\"appid!=null and appid!='' \">\n" +
            "                AND appid = #{appid}\n" +
            "            </if>\n" +
            "            <if test=\"username!=null and username!=''\">\n" +
            "                AND username = #{username}\n" +
            "            </if>\n" +
            "            <if test=\"passwd!=null and passwd!=''\">\n" +
            "                AND passwd = #{passwd}\n" +
            "            </if>\n" +
            "            <if test=\"createTime!=null\">\n" +
            "                AND createTime = #{createTime}\n" +
            "            </if>\n" +
            "        </where>"+
            "</script>")
    fun selectUser(tuser: User):List<User>
}