package org.xingte.jxc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xt_post")
public class Post implements Serializable {
	@Id
	@GeneratedValue
	/**
	 * 岗位号
	 */
	private int id;
	/**
	 * 岗位名称
	 */
	private String name;
	/**
	 * 岗位所在部门
	 */
	private int departmentid;
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


	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", departmentid="
				+ departmentid + ", description=" + description + ", state="
				+ state + "]";
	}
	
	
}
