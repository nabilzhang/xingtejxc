package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.service.SupplierService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SupplierAction extends ActionSupport implements ModelDriven {
	private SupplierService supplierService=new SupplierService();
	private List supplierList;
	

	public void setSupplierList(List supplierList) {
		supplierList = supplierList;
	}
	
	public String getAllSupplier(){
		supplierList=supplierService.getAllSuppliers();
		return "all";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return supplierList;
	}

}
