package com.example.demo03work.entity

/**
 * 说明: 权限表实体
 * 编写人: 蔡
 * 编写时间: 2019-12-25
 * 修改时间:
 * @property id id
 * @property permissionname 权限名
 * @property url 路径
 * @property pagename 页面名称
 * @property editname 操作名称
 * @constructor 创建一个学生对象
 */
class Permission {
    var id: Int = 0
    var permissionname: String = ""
    var url: String = ""
    var pagename: String = ""
    var editname: String = ""
}