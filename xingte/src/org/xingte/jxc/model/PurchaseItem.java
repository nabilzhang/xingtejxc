package org.xingte.jxc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xt_purchaseitem")
public class PurchaseItem {
	@Id
	@GeneratedValue
	/**
	 * 订单项编号
	 */
	private int id;
	/**
	 * 采购单号
	 */
	private int purchaseid;
	/**
	 * 货物编号
	 */
	private int productid;
	/**
	 * 货物数量
	 */
	private int amount;
	/**
	 * 货物单位
	 */
	private String units;
	/**
	 * 采购价格
	 */
	private Double purchaseprice;
	/**
	 * 采购项状态
	 */
	private int state;
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
	public Double getPurchaseprice() {
		return purchaseprice;
	}
	public void setPurchaseprice(Double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "PurchaseItem [id=" + id + ", purchaseid=" + purchaseid
				+ ", productid=" + productid + ", amount=" + amount
				+ ", units=" + units + ", purchaseprice=" + purchaseprice
				+ ", state=" + state + "]";
	}
	
	
}
