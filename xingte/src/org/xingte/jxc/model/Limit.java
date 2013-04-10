package org.xingte.jxc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xt_limit")
public class Limit implements Serializable {
	@Id
	@GeneratedValue
	/**
	 * 权限标号
	 */
	private int id;
	/**
	 * 权限名称
	 */
	private String name;
	/**
	 * 权限编码
	 */
	private int code;
	/**
	 * 权限描述
	 */
	private String decription;
	/**
	 * 权限对应用户组号
	 */
	private int usergroupid;
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public int getUsergroupid() {
		return usergroupid;
	}
	public void setUsergroupid(int usergroupid) {
		this.usergroupid = usergroupid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Limit [id=" + id + ", name=" + name + ", decription="
				+ decription + ", usergroupid=" + usergroupid + ", state="
				+ state + "]";
	}
	
	
}
