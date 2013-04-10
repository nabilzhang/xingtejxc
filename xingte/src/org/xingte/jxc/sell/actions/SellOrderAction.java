package org.xingte.jxc.sell.actions;

import java.util.List;

import org.xingte.jxc.service.SellOrderService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SellOrderAction extends ActionSupport implements ModelDriven {
	private SellOrderService sellOrderService=new SellOrderService();
	private List sellOrderList;
	
	public List getSellOrderList() {
		return sellOrderList;
	}

	public void setSellOrderList(List sellOrderList) {
		this.sellOrderList = sellOrderList;
	}
	public String getAll(){
		this.sellOrderList=sellOrderService.getSellOrderDTOs();
		
		return "all";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return sellOrderList;
	}

}
