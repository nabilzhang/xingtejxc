package org.xingte.jxc.dto;
import java.util.Date;
public class InStoreOrderDTO {
	private int id;
	private String instorenumber;
    private int salesmanid;
    private String salesmanname;
    private int instoretype;
    private String instoretypes;
    private Date indate;
    private int state;
    private String statename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstorenumber() {
		return instorenumber;
	}
	public void setInstorenumber(String instorenumber) {
		this.instorenumber = instorenumber;
	}
	public int getSalesmanid() {
		return salesmanid;
	}
	public void setSalesmanid(int salesmanid) {
		this.salesmanid = salesmanid;
	}
	public String getSalesmanname() {
		return salesmanname;
	}
	public void setSalesmanname(String salesmanname) {
		this.salesmanname = salesmanname;
	}
	public int getInstoretype() {
		return instoretype;
	}
	public void setInstoretype(int instoretype) {
		this.instoretype = instoretype;
	}
	public String getInstoretypes() {
		return instoretypes;
	}
	public void setInstoretypes(String instoretypes) {
		this.instoretypes = instoretypes;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	@Override
	public String toString() {
		return "InStoreOrderDTO [id=" + id + ", instorenumber=" + instorenumber
				+ ", salesmanid=" + salesmanid + ", salesmanname="
				+ salesmanname + ", instoretype=" + instoretype
				+ ", instoretypes=" + instoretypes + ", indate=" + indate
				+ ", state=" + state + ", statename=" + statename + "]";
	}
    
	
}
