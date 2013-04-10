package org.xingte.jxc.dto;

public class OutStoreItemDTO {
    private int id;
    private int outstoreid;
    private int productid;
    private String productname;
    private int amount;
    private String units;
    private double outprice;
    private int state;
    private String statename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOutstoreid() {
		return outstoreid;
	}
	public void setOutstoreid(int outstoreid) {
		this.outstoreid = outstoreid;
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
	public double getOutprice() {
		return outprice;
	}
	public void setOutprice(double outprice) {
		this.outprice = outprice;
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
		return "OutStoreItemDTO [id=" + id + ", outstoreid=" + outstoreid
				+ ", productid=" + productid + ", productname=" + productname
				+ ", amount=" + amount + ", units=" + units + ", outprice="
				+ outprice + ", state=" + state + ", statename=" + statename
				+ "]";
	}
}
