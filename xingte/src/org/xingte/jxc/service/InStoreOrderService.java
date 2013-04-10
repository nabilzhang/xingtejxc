package org.xingte.jxc.service;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.xingte.jxc.model.InStoreOrder;
import org.xingte.jxc.daoimpl.InStoreOrderDaoImpl;
import org.xingte.jxc.daoimpl.PersonnelDaoImpl;
import org.xingte.jxc.dto.InStoreOrderDTO;
import org.xingte.jxc.util.*;
public class InStoreOrderService {
	InStoreOrderDaoImpl inStoreOrderDaoImpl=new InStoreOrderDaoImpl();
	PersonnelDaoImpl personnelDaoImpl=new PersonnelDaoImpl();
	public void addInStoreOrder(InStoreOrder inStoreOrder){
		inStoreOrderDaoImpl.addInStoreOrder(inStoreOrder);
    }
    public InStoreOrder getById(int id){
    	return inStoreOrderDaoImpl.getById(id);
    }
    public List<InStoreOrder> getInStoreOrders(){
    	return inStoreOrderDaoImpl.getInStoreOrders();
    }
    public void deleteById(int id){
    	inStoreOrderDaoImpl.deleteById(id);
    }
    public void deleteOne(InStoreOrder inStoreOrder){
    	inStoreOrderDaoImpl.deleteOne(inStoreOrder);
    }
    public InStoreOrderDTO getInStoreOrderDTO(int id){
    	InStoreOrderDTO inStoreOrderDTO=new InStoreOrderDTO();
    	InStoreOrder i=inStoreOrderDaoImpl.getById(id);
    	//InStoreType in=new InStoreType();
    	int salesmanid;
    	int instoretype;
    	String salemanname;
    	String instoretypes;
    	salesmanid=i.getSalesmanid();
    	instoretype=i.getInstoretype();
    	int state=i.getState();
    	String statename;
    	if(salesmanid==0){
    		salemanname="不明";
    	}
    	else{
    		salemanname=personnelDaoImpl.getById(salesmanid).getName();
    	}
    	if(instoretype==0){
    		instoretypes=InStoreType.PurchaseInStore.toString();
    	}
    	else{
    		instoretypes=InStoreType.SellBackInStore.toString();
    	}
    	if(state==0){
    		statename=OrderState.Unsend.toString();
    	}
    	else if(state==1){
    		statename=OrderState.Send.toString();
    	}
    	else{
    		statename=OrderState.Received.toString();
    	}
    	inStoreOrderDTO.setId(i.getId());
    	inStoreOrderDTO.setIndate(i.getIndate());
    	inStoreOrderDTO.setInstorenumber(i.getInstorenumber());
    	inStoreOrderDTO.setInstoretype(i.getInstoretype());
    	inStoreOrderDTO.setInstoretypes(instoretypes);
    	inStoreOrderDTO.setSalesmanid(i.getSalesmanid());
    	inStoreOrderDTO.setSalesmanname(salemanname);
    	inStoreOrderDTO.setState(i.getState());
    	inStoreOrderDTO.setStatename(statename);
    	return inStoreOrderDTO;
    }
    public List<InStoreOrderDTO> getInStoreOrderDTOs(){
    	List instoreorders=this.getInStoreOrders();
    	Iterator<InStoreOrder> iter=instoreorders.iterator();
    	List<InStoreOrderDTO> inStoreOrderDTOs=new ArrayList<InStoreOrderDTO>();
    	while(iter.hasNext()){
    		InStoreOrder i=iter.next();
    		int salesmanid;
        	int instoretype;
        	String salemanname;
        	String instoretypes;
        	salesmanid=i.getSalesmanid();
        	instoretype=i.getInstoretype();
        	int state=i.getState();
        	String statename;
        	if(salesmanid==0){
        		salemanname="不明";
        	}
        	else{
        		salemanname=personnelDaoImpl.getById(salesmanid).getName();
        	}
        	if(instoretype==0){
        		instoretypes=InStoreType.PurchaseInStore.toString();
        	}
        	else{
        		instoretypes=InStoreType.SellBackInStore.toString();
        	}
        	if(state==0){
        		statename=OrderState.Unsend.toString();
        	}
        	else if(state==1){
        		statename=OrderState.Send.toString();
        	}
        	else{
        		statename=OrderState.Received.toString();
        	}
        	InStoreOrderDTO inStoreOrderDTO=new InStoreOrderDTO();
        	inStoreOrderDTO.setId(i.getId());
        	inStoreOrderDTO.setIndate(i.getIndate());
        	inStoreOrderDTO.setInstorenumber(i.getInstorenumber());
        	inStoreOrderDTO.setInstoretype(i.getInstoretype());
        	inStoreOrderDTO.setInstoretypes(instoretypes);
        	inStoreOrderDTO.setSalesmanid(i.getSalesmanid());
        	inStoreOrderDTO.setSalesmanname(salemanname);
        	inStoreOrderDTO.setState(i.getState());
        	inStoreOrderDTO.setStatename(statename);
        	inStoreOrderDTOs.add(inStoreOrderDTO);
    	}
    	return inStoreOrderDTOs;
    }
}
