package org.xingte.jxc.dto;
import java.io.Serializable;
public class ProductDTO implements Serializable{
	private int id;
	private String productnumber;
	private String name;
	private String units;
	private int supplierid;
	private String suppliername;
	private int areaid;
	private String areaname;
	private int catalogid;
	private String catalogname;
	private double inprice;
	private double saleprice;
	private double lowprice;
	private int store;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductnumber() {
		return productnumber;
	}
	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
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
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public int getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}
	public String getCatalogname() {
		return catalogname;
	}
	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}
	public double getInprice() {
		return inprice;
	}
	public void setInprice(double inprice) {
		this.inprice = inprice;
	}
	public double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}
	public double getLowprice() {
		return lowprice;
	}
	public void setLowprice(double lowprice) {
		this.lowprice = lowprice;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productnumber=" + productnumber
				+ ", name=" + name + ", units=" + units + ", supplierid="
				+ supplierid + ", suppliername=" + suppliername + ", areaid="
				+ areaid + ", areaname=" + areaname + ", catalogid="
				+ catalogid + ", catalogname=" + catalogname + ", inprice="
				+ inprice + ", saleprice=" + saleprice + ", lowprice="
				+ lowprice + ", store=" + store + ", state=" + state + "]";
	}
	
}
