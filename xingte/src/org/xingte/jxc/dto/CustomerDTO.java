package org.xingte.jxc.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable{
	private int id;
	private String customernumber;
	private String name;
	private String address;
	private String postcode;
	private String areacode;
	private int areaid;
	private String areaname;
	private String telephone;
	private String fax;
	private int salesmanid;
	private String salesmanname;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", customernumber=" + customernumber
				+ ", name=" + name + ", address=" + address + ", postcode="
				+ postcode + ", areacode=" + areacode + ", areaid=" + areaid
				+ ", areaname=" + areaname + ", telephone=" + telephone
				+ ", fax=" + fax + ", salesmanid=" + salesmanid
				+ ", salesmanname=" + salesmanname + ", state=" + state + "]";
	}
	
	
}
