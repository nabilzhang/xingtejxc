package org.xingte.jxc.dto;
import java.util.Date;
public class PurchaseOrderDTO {
    private int id;
	private String purchasenumber;
    private int supplierid;
    private String suppliername;
    private int salesmanid;
    private String salesmanname;
    private Date purchasedate;
    private int state;
    private String statename;
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
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
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
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	@Override
	public String toString() {
		return "PurchaseOrderDTO [id=" + id + ", purchasenumber="
				+ purchasenumber + ", supplierid=" + supplierid
				+ ", suppliername=" + suppliername + ", salesmanid="
				+ salesmanid + ", salesmanname=" + salesmanname
				+ ", purchasedate=" + purchasedate + ", state=" + state
				+ ", statename=" + statename + "]";
	}
	
}
