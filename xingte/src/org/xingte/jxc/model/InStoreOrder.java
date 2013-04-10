package org.xingte.jxc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="xt_instoreorder")
public class InStoreOrder {
	@Id
	@GeneratedValue
	/**
	 * 订单id
	 */
	private int id;
	/**
	 * 订单编号
	 */
	private String instorenumber;
	/**
	 * 业务员编号
	 */
	private int salesmanid;
	/**
	 * 入库类型
	 */
	private int instoretype;
	/**
	 * 入库日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date indate;
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
	public int getInstoretype() {
		return instoretype;
	}
	public void setInstoretype(int instoretype) {
		this.instoretype = instoretype;
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
	@Override
	public String toString() {
		return "InStoreOrder [id=" + id + ", instorenumber=" + instorenumber
				+ ", salesmanid=" + salesmanid + ", instoretype=" + instoretype
				+ ", indate=" + indate + ", state=" + state + "]";
	}
	
	
}
