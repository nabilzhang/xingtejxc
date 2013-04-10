package org.xingte.jxc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xt_sellitem")
public class SellItem {
	@Id
	@GeneratedValue
	/**
	 * 订单项id
	 */
	private int id;
	/**
	 * 对应订单号
	 */
	private int saleid;
	/**
	 * 货物号
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
	 * 销售价格
	 */
	private Double sellprice;
	/**
	 * 状态
	 */
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSaleid() {
		return saleid;
	}
	public void setSaleid(int saleid) {
		this.saleid = saleid;
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
	public Double getSellprice() {
		return sellprice;
	}
	public void setSellprice(Double sellprice) {
		this.sellprice = sellprice;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "SellItem [id=" + id + ", saleid=" + saleid + ", productid="
				+ productid + ", amount=" + amount + ", units=" + units
				+ ", sellprice=" + sellprice + ", state=" + state + "]";
	}
	
	

}
