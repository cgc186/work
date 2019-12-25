package com.example.demo02.entity;
/**
 *说明：用户实体
 * 编写人：张连壮
 * 编写时间：2019年12月25日
 * 修改时间
 */
public class Role {
	private int rid;
	private String rolename;
	private String remarks;
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
