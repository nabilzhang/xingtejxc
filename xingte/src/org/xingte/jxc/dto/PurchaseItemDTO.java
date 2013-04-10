package org.xingte.jxc.dto;

public class PurchaseItemDTO {
    private int id;
    private int purchaseid;
    private int productid;
    private String productname;
    private int amount;
    private String units;
    private double purchaseprice;
    private int state;
    private String statename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
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
	public double getPurchaseprice() {
		return purchaseprice;
	}
	public void setPurchaseprice(double purchaseprice) {
		this.purchaseprice = purchaseprice;
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
		return "PurchaseItemDTO [id=" + id + ", purchaseid=" + purchaseid
				+ ", productid=" + productid + ", productname=" + productname
				+ ", amount=" + amount + ", units=" + units
				+ ", purchaseprice=" + purchaseprice + ", state=" + state
				+ ", statename=" + statename + "]";
	}
	
    
}
