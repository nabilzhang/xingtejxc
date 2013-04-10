package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.xingte.jxc.model.SellOrder;
import org.xingte.jxc.util.*;
import org.xingte.jxc.daoimpl.SellOrderDaoImpl;

import org.xingte.jxc.dto.SellOrderDTO;
import org.xingte.jxc.daoimpl.CustomerDaoImpl;
import org.xingte.jxc.daoimpl.PersonnelDaoImpl;
public class SellOrderService {
	private SellOrderDaoImpl sellOrderDaoImpl=new SellOrderDaoImpl();
	private CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	private PersonnelDaoImpl personnelDaoImpl=new PersonnelDaoImpl();
	public void addSellOrder(SellOrder sellOrder){
		sellOrderDaoImpl.addSellOrder(sellOrder);
    }
    public SellOrder getById(int id){
    	return sellOrderDaoImpl.getById(id);
    }
    public List<SellOrder> getSellOrders(){
    	return sellOrderDaoImpl.getSellOrders();
    }
    public void deleteById(int id){
    	sellOrderDaoImpl.deleteById(id);
    }
    public void deleteOne(SellOrder sellOrder){
    	sellOrderDaoImpl.deleteOne(sellOrder);
    }
    public SellOrderDTO getSellOrderDTO(int id){
    	SellOrder s=sellOrderDaoImpl.getById(id);
    	
    	
    	SellOrderDTO sellOrderDTO=this.ConvertToDTO(s);
    	
    	return sellOrderDTO;
    	
    }
    private SellOrderDTO ConvertToDTO(SellOrder s){

    	
    	int customerid=s.getCustomerid();
    	String customername;
    	int salesmanid=s.getSalesmanid();
    	String salesmanname;
    	int state=s.getState();
    	String statename;
    	 if(customerid==0){
    		 customername="不明";
	    	}
	    	else{
	    		customername=customerDaoImpl.getOneById(customerid).getName();
	    	}
	    	if(salesmanid==0){
	    		salesmanname="不明";
	    	}
	    	else{
	    		salesmanname=personnelDaoImpl.getById(salesmanid).getName();
	    	}
	    	if(state==0){
	    		statename=OrderState.Unsend.toString();
	    	}
	    	else if(state==1){
	    		statename=OrderState.Send.toString();
	    	}
	    	else {
	    		statename=OrderState.Received.toString();
	    	}
    	SellOrderDTO sellOrderDTO=new SellOrderDTO();
    	sellOrderDTO.setCustomerid(s.getCustomerid());
    	sellOrderDTO.setCustomername(customername);
    	sellOrderDTO.setId(s.getId());
    	sellOrderDTO.setSalesmanid(s.getSalesmanid());
    	sellOrderDTO.setSalesmanname(salesmanname);
    	sellOrderDTO.setSelldate(s.getSelldate());
    	sellOrderDTO.setSellnumber(s.getSellnumber());
    	sellOrderDTO.setState(s.getState());
    	sellOrderDTO.setStatename(statename);
    	return sellOrderDTO;
    }
    public List<SellOrderDTO> getSellOrderDTOs(){
    	List sellorders=this.getSellOrders();
    	Iterator<SellOrder> iter=sellorders.iterator();
    	List<SellOrderDTO> sellOrderDTOs=new ArrayList<SellOrderDTO>();
    	while(iter.hasNext()){
    		SellOrder s=iter.next();
        	SellOrderDTO sellOrderDTO=this.ConvertToDTO(s);
        	
        	sellOrderDTOs.add(sellOrderDTO);
    	}
    	return sellOrderDTOs;
    }
}
