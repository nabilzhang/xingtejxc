package org.xingte.jxc.stock.actions;

import java.util.List;

import org.xingte.jxc.service.InStoreOrderService;
import org.xingte.jxc.service.OutStoreOrderService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class OutStoreAction extends ActionSupport implements ModelDriven{
	
		private OutStoreOrderService outStoreOrderService=new OutStoreOrderService();
		private List outStoreList;
		

		public List getOutStoreList() {
			return outStoreList;
		}


		public void setOutStoreList(List outStoreList) {
			this.outStoreList = outStoreList;
		}


		
		
		public String getAll(){
			outStoreList=this.outStoreOrderService.getOutStoreOrderDTOs();
			return "all";
		}

		@Override
		public Object getModel() {
			// TODO Auto-generated method stub
			return outStoreList;
		}
}
