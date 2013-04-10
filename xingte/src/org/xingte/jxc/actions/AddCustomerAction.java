package org.xingte.jxc.actions;

import org.xingte.jxc.model.Customer;
import org.xingte.jxc.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddCustomerAction extends ActionSupport implements ModelDriven{
	private CustomerService customerService=new CustomerService();
	private Customer customer=new Customer();
	private String result;
	

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String add(){
		customerService.addCustomer(customer);
		result="1";
		return "add";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

}
