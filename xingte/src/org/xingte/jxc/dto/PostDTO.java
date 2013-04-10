package org.xingte.jxc.dto;

import java.io.Serializable;

public class PostDTO implements Serializable {
	/**
	 * 岗位号
	 */
	private int id;
	/**
	 * 岗位名称
	 */
	private String name;
	/**
	 * 岗位所在部门号
	 */
	private int departmentid;
	/**
	 * 岗位所在部门名称
	 */
	private String departmentname;
	/**
	 * 岗位描述
	 */
	private String description;
	/**
	 * 状态
	 */
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public PostDTO(int id, String name, int departmentid,
			String departmentname, String description, int state) {
		super();
		this.id = id;
		this.name = name;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.description = description;
		this.state = state;
	}
	@Override
	public String toString() {
		return "PostDTO [id=" + id + ", name=" + name + ", departmentid="
				+ departmentid + ", departmentname=" + departmentname
				+ ", description=" + description + ", state=" + state + "]";
	}
	
	
}
