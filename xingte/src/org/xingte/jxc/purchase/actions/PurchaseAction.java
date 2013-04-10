package org.xingte.jxc.purchase.actions;

import java.util.List;

import org.xingte.jxc.dto.PurchaseOrderDTO;
import org.xingte.jxc.service.PurchaseOrderService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PurchaseAction extends ActionSupport implements ModelDriven{
	private PurchaseOrderService purchaseOrderService=
		new PurchaseOrderService();
	
	private int pstate;
	private String sname;
	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getPstate() {
		return pstate;
	}


	public void setPstate(int pstate) {
		this.pstate = pstate;
	}


	private List<PurchaseOrderDTO> purchaseOrderList;
	
	
	public List<PurchaseOrderDTO> getPurchaseOrderList() {
		return purchaseOrderList;
	}


	public void setPurchaseOrderList(List<PurchaseOrderDTO> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}


	public String getAllPurchaseOrders(){
		if(sname!=null){
			purchaseOrderList=purchaseOrderService.getPurchaseOrdersBySupplierName(sname);
			return "all";
		}
		
		
		if(1==pstate){
			purchaseOrderList=purchaseOrderService.getPurchseOrdersByState(pstate);
		}else{
			purchaseOrderList=purchaseOrderService.getAllPurchaseOrders();
		}
		
		
		return "all";
	}
    

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return purchaseOrderList;
	}
	
}
