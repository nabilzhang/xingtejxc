package org.xingte.jxc.dto;

public class InStoreItemDTO {
    private int id;
    private int instoreid;
    private int productid;
    private String productname;
    private int amount;
    private String units;
    private double inprice;
    private int state;
    private String statename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInstoreid() {
		return instoreid;
	}
	public void setInstoreid(int instoreid) {
		this.instoreid = instoreid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public double getInprice() {
		return inprice;
	}
	public void setInprice(double inprice) {
		this.inprice = inprice;
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
		return "InStoreItemDTO [id=" + id + ", instoreid=" + instoreid
				+ ", productid=" + productid + ", productname=" + productname
				+ ", amount=" + amount + ", units=" + units + ", inprice="
				+ inprice + ", state=" + state + ", statename=" + statename
				+ "]";
	}
}
