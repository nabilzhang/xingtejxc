package org.xingte.jxc.dto;

public class UserDTO {
	private int id;
	private String name;
	private String password;
	private String personnelname;
	private String groupname;
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPersonnelname() {
		return personnelname;
	}
	public void setPersonnelname(String personnelname) {
		this.personnelname = personnelname;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	@Override
	public String toString() {
		return "UserVo [name=" + name + ", password=" + password
				+ ", personnelname=" + personnelname + ", groupname="
				+ groupname + "]";
	}
	
	
}
