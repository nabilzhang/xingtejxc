package org.xingte.jxc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="xt_outstoreorder")
public class OutStoreOrder {
	@GeneratedValue
	@Id
	/**
	 * 出库单id
	 */
	private int id;
	/**
	 * 出库单编号
	 */
	private String outstorenumber;
	/**
	 * 业务员编号
	 */
	private int storeroomkeeperid;
	/**
	 * 出库类型
	 */
	private int outstoretype;
	
	/**
	 * 出库时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date outdate;
	/**
	 * 出库单状态
	 */
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOutstorenumber() {
		return outstorenumber;
	}
	public void setOutstorenumber(String outstorenumber) {
		this.outstorenumber = outstorenumber;
	}
	public int getstoreroomkeeperid() {
		return storeroomkeeperid;
	}
	public void setstoreroomkeeperid(int storeroomkeeperid) {
		this.storeroomkeeperid = storeroomkeeperid;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public int getOutstoretype() {
		return outstoretype;
	}
	public void setOutstoretype(int outstoretype) {
		this.outstoretype = outstoretype;
	}
	@Override
	public String toString() {
		return "OutStoreOrder [id=" + id + ", outstorenumber=" + outstorenumber
				+ ", storeroomkeeperid=" + storeroomkeeperid + ", outdate=" + outdate
				+ ", state=" + state + "]";
	}
	
	
}
