package org.xingte.jxc.stock.actions;

import java.util.List;

import org.xingte.jxc.service.InStoreOrderService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InStoreAction extends ActionSupport implements ModelDriven {
	private InStoreOrderService inStoreOrderService=new InStoreOrderService();
	private List inStoreList;
	

	public List getInStoreList() {
		return inStoreList;
	}


	public void setInStoreList(List inStoreList) {
		this.inStoreList = inStoreList;
	}
	
	public String getAll(){
		inStoreList=this.inStoreOrderService.getInStoreOrderDTOs();
		return "all";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return inStoreList;
	}

}
