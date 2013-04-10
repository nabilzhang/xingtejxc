package org.xingte.jxc.purchase.actions;

import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.xingte.jxc.model.PurchaseItem;
import org.xingte.jxc.model.PurchaseOrder;
import org.xingte.jxc.service.PurchaseItemService;
import org.xingte.jxc.service.PurchaseOrderService;

import com.opensymphony.xwork2.ActionSupport;

public class AddPurchaseAction extends ActionSupport{
	private PurchaseOrderService purcharOrderService=new PurchaseOrderService();
	private PurchaseItemService purchaseItemService=new PurchaseItemService();
	private String podnum;
	private String pid;
	private String sid;
	private String iteminfo;
	public String getPodnum() {
		return podnum;
	}
	public void setPodnum(String podnum) {
		this.podnum = podnum;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getIteminfo() {
		return iteminfo;
	}
	public void setIteminfo(String iteminfo) {
		this.iteminfo = iteminfo;
	}
	
	public String addOrder(){
		PurchaseOrder po=new PurchaseOrder();
		po.setPurchasenumber(podnum.trim());
		po.setSalesmanid(Integer.parseInt(pid.trim()));
		po.setSupplierid(Integer.parseInt(sid.trim()));
		po.setPurchasedate(new Date());
		System.out.println(po);
		purcharOrderService.addPurchaseOrder(po);
		
		System.out.println(iteminfo);
		String ii=new String(iteminfo);
		//po=purcharOrderService.getByNum(podnum.trim());
		//System.out.println(po);
		JSONArray jarr=(JSONArray)JSONValue.parse(ii);
		System.out.println(jarr.size());
		
		for(int i=0;i<jarr.size();i++){
			JSONObject jo=(JSONObject)jarr.get(i);
			PurchaseItem pi=new PurchaseItem();
			pi.setProductid(Integer.parseInt(jo.get("productid").toString()));
			pi.setPurchaseprice(Double.parseDouble(jo.get("purchaseprice").toString()));
			pi.setAmount(Integer.parseInt(jo.get("amount").toString()));
			pi.setPurchaseid(po.getId());
			pi.setUnits(jo.get("units").toString());
			purchaseItemService.addPurchaseItem(pi);
			System.out.println(pi.toString());
		}

		return "add";
	}
}
