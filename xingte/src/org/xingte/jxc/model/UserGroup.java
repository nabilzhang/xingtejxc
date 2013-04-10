package org.xingte.jxc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xt_usergroup")
public class UserGroup {
	@Id
	@GeneratedValue
	/**
	 * 用户组号
	 */
	private int id;
	/**
	 * 用户组名称
	 */
	private String name;
	/**
	 * 用户组描述
	 */
	private String decription;
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
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", name=" + name + ", decription="
				+ decription + ", state=" + state + "]";
	}
	
	
}
