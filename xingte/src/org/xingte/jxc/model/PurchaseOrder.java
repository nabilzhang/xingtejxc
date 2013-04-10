package org.xingte.jxc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="xt_purchaseorder")
public class PurchaseOrder {
	@Id
	@GeneratedValue
	/**
	 * 采购id
	 */
	private int id;
	/**
	 * 采购单编号
	 */
	private String purchasenumber;
	/**
	 * 供货商号
	 */
	private int supplierid;
	/**
	 * 业务员编号
	 */
	private int salesmanid;
	/**
	 * 采购日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchasedate;
	/**
	 * 订单状态
	 */
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPurchasenumber() {
		return purchasenumber;
	}
	public void setPurchasenumber(String purchasenumber) {
		this.purchasenumber = purchasenumber;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public int getSalesmanid() {
		return salesmanid;
	}
	public void setSalesmanid(int salesmanid) {
		this.salesmanid = salesmanid;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", purchasenumber=" + purchasenumber
				+ ", supplierid=" + supplierid + ", salesmanid=" + salesmanid
				+ ", purchasedate=" + purchasedate + ", state=" + state + "]";
	}
	
	
}
