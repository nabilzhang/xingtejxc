package org.xingte.jxc.dto;

public class UserGroupDTO {
	/**
	 * 用户组号
	 */
	private int id;
	/**
	 * 用户组名称
	 */

	private String name;
	/**
	 * 用户组所有权限
	 */
	private String limits;
	
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
	public String getLimits() {
		return limits;
	}
	public void setLimits(String limits) {
		this.limits = limits;
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
		return "UserGroupDTO [id=" + id + ", name=" + name + ", limits="
				+ limits + ", decription=" + decription + ", state=" + state
				+ "]";
	}
	
}
