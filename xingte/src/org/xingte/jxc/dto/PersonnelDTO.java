package org.xingte.jxc.dto;

import java.io.Serializable;

public class PersonnelDTO implements Serializable{
	private int id;
	private String name;
	private int postid;
	private String postname;
	private String degree;
	private String workexperience;
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
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getWorkexperience() {
		return workexperience;
	}
	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public PersonnelDTO(){
		
	}
	
	public PersonnelDTO(int id, String name, int postid, String postname,
			String degree, String workexperience, int state) {
		super();
		this.id = id;
		this.name = name;
		this.postid = postid;
		this.postname = postname;
		this.degree = degree;
		this.workexperience = workexperience;
		this.state = state;
	}
	@Override
	public String toString() {
		return "PersonnelDTO [id=" + id + ", name=" + name + ", postid="
				+ postid + ", postname=" + postname + ", degree=" + degree
				+ ", workexperience=" + workexperience + ", state=" + state
				+ "]";
	}
	
	
}
