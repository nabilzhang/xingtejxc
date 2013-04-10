package org.xingte.jxc.dto;
import java.io.Serializable;
public class ProcatalogDTO implements Serializable{
    
	private int id;
    private String catalognumber;
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
	public String getCatalognumber() {
		return catalognumber;
	}
	public void setCatalognumber(String catalognumber) {
		this.catalognumber = catalognumber;
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
	@Override
	public String toString() {
		return "ProcatalogDTO [id=" + id + ", catalognumber=" + catalognumber
				+ ", name=" + name + ", parentid=" + parentid + ", parentname="
				+ parentname + ", state=" + state + "]";
	}
}
