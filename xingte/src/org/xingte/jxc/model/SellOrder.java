package org.xingte.jxc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="xt_sellorder")
public class SellOrder {
	@Id
	@GeneratedValue
	/**
	 * 订单id
	 */
	private int id;
	/**
	 * 销售订单号
	 */
	private String sellnumber;
	/**
	 * 客户号
	 */
	private int customerid;
	/**
	 * 业务员号
	 */
	private int salesmanid;
	/**
	 * 销售日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date selldate;
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
	public String getSellnumber() {
		return sellnumber;
	}
	public void setSellnumber(String sellnumber) {
		this.sellnumber = sellnumber;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getSalesmanid() {
		return salesmanid;
	}
	public void setSalesmanid(int salesmanid) {
		this.salesmanid = salesmanid;
	}
	public Date getSelldate() {
		return selldate;
	}
	public void setSelldate(Date selldate) {
		this.selldate = selldate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "SellOrder [id=" + id + ", sellnumber=" + sellnumber
				+ ", customerid=" + customerid + ", salesmanid=" + salesmanid
				+ ", selldate=" + selldate + ", state=" + state + "]";
	}
	
	
}
