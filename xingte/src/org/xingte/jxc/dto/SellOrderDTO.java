package org.xingte.jxc.dto;
import java.util.Date;
public class SellOrderDTO {
    private int id;
    private String sellnumber;
    private int customerid;
    private String customername;
    private int salesmanid;
    private String salesmanname;
    private Date selldate;
    private int state;
    private String statename;
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
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
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
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	@Override
	public String toString() {
		return "SellOrderDTO [id=" + id + ", sellnumber=" + sellnumber
				+ ", customerid=" + customerid + ", customername="
				+ customername + ", salesmanid=" + salesmanid
				+ ", salesmanname=" + salesmanname + ", selldate=" + selldate
				+ ", state=" + state + ", statename=" + statename + "]";
	}
	
    
}
