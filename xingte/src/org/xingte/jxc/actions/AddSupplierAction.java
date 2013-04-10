package org.xingte.jxc.actions;

import org.xingte.jxc.model.Supplier;
import org.xingte.jxc.service.SupplierService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddSupplierAction extends ActionSupport implements ModelDriven {
	private SupplierService supplierService=new SupplierService();
	private Supplier supplier =new Supplier();
	private String result;
	
	

	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}



	public String getResult() {
		return result;
	}
	
	public String add(){
		supplierService.addSupplier(supplier);
		return "add";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return supplier;
	}

}
