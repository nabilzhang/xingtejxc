package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.daoimpl.AreaDaoImpl;
import org.xingte.jxc.daoimpl.CustomerDaoImpl;
import org.xingte.jxc.daoimpl.PersonnelDaoImpl;
import org.xingte.jxc.daoimpl.PostDaoImpl;
import org.xingte.jxc.dto.CustomerDTO;
import org.xingte.jxc.model.Customer;

public class CustomerService {
	private CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	private PostDaoImpl postDaoImpl=new PostDaoImpl();
	private AreaDaoImpl areaDaoImpl=new AreaDaoImpl();
	private PersonnelDaoImpl personnelDaoImpl=new PersonnelDaoImpl();
	
	public void addCustomer(Customer customer){
		customerDaoImpl.addCustomer(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return customerDaoImpl.getCustomers();
	}
	public List<CustomerDTO> getAllCustomerDTOs(){
		List customers=this.getAllCustomers();
		Iterator<Customer> iter=customers.iterator();
		List<CustomerDTO> customerDTOs=new ArrayList<CustomerDTO>();
		
		while(iter.hasNext()){
			Customer c=iter.next();
			int areaid=c.getAreaid();
			int salesmanid=c.getSalesmanid();
			String areaname,salesmanname;
			if(areaid==0){
				areaname="不明";
			}else{
				areaname=areaDaoImpl.getOneAreaById(areaid).getName();
			}
			
			if(salesmanid==0){
				salesmanname="未指定";
			}else{
				salesmanname=personnelDaoImpl.getById(salesmanid).getName();
			}
			
			CustomerDTO customerDTO=new CustomerDTO();
			customerDTO.setId(c.getId());
			customerDTO.setCustomernumber(c.getCustomernumber());
			customerDTO.setName(c.getName());
			customerDTO.setPostcode(c.getPostcode());
			customerDTO.setAreacode(c.getAreacode());
			customerDTO.setAreaid(c.getAreaid());
			customerDTO.setAreaname(areaname);
			customerDTO.setTelephone(c.getTelephone());
			customerDTO.setAddress(c.getAddress());
			customerDTO.setFax(c.getFax());
			customerDTO.setSalesmanid(salesmanid);
			customerDTO.setSalesmanname(salesmanname);
			customerDTO.setState(c.getState());
			customerDTOs.add(customerDTO);
		}
		return customerDTOs;
		
	}
}
