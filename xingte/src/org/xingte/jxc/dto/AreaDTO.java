package org.xingte.jxc.dto;

import java.io.Serializable;

public class AreaDTO implements Serializable {
	private int id;
	private String name;
	private int parentid;
	private String parentname;
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
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public AreaDTO(int id, String name, int parentid, String parentname,
			int state) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.parentname = parentname;
		this.state = state;
	}
	@Override
	public String toString() {
		return "AreaDTO [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", parentname=" + parentname + ", state=" + state
				+ "]";
	}
	
	
	
	
}
