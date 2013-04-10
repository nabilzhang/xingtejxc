package org.xingte.jxc.purchase.actions;

import java.util.List;

import org.xingte.jxc.service.PurchaseItemService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PurchaseItemAction extends ActionSupport implements ModelDriven {
	private int pcseid;
	private PurchaseItemService purchaseItemService =new PurchaseItemService();
	private List PurchaseItems;
	
	public int getPcseid() {
		return pcseid;
	}

	public void setPcseid(int pcseid) {
		this.pcseid = pcseid;
	}

	public List getPurchaseItems() {
		return PurchaseItems;
	}

	public void setPurchaseItems(List purchaseItems) {
		PurchaseItems = purchaseItems;
	}
	public String GetPurchaseItemList(){
		PurchaseItems=purchaseItemService.getPurchaseItemDTOs(pcseid);
		
		return "all";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return PurchaseItems;
	}
	

}
