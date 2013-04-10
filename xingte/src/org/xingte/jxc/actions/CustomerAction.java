package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven {
	private CustomerService customerService=new CustomerService();
	
	private List customerDTOs;


	public void setCustomerDTOs(List customerDTOs) {
		customerDTOs = customerDTOs;
	}
	
	public String getAllCustomers(){
		customerDTOs=customerService.getAllCustomerDTOs();
		return "allcustomers";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return customerDTOs;
	}

}
