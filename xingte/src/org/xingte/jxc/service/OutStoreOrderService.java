package org.xingte.jxc.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xingte.jxc.util.*;
import org.xingte.jxc.dto.InStoreOrderDTO;
import org.xingte.jxc.dto.OutStoreOrderDTO;
import org.xingte.jxc.model.InStoreOrder;
import org.xingte.jxc.model.OutStoreOrder;
import org.xingte.jxc.util.InStoreType;
import org.xingte.jxc.daoimpl.OutStoreOrderDaoImpl;
import org.xingte.jxc.daoimpl.PersonnelDaoImpl;
import org.xingte.jxc.daoimpl.ProductDaoImpl;
public class OutStoreOrderService {
	private OutStoreOrderDaoImpl outStoreOrderDaoImpl=new OutStoreOrderDaoImpl();
	private ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	private PersonnelDaoImpl personnelDaoImpl=new PersonnelDaoImpl();
	 public void addOutStoreOrder(OutStoreOrder outStoreOrder){
		 outStoreOrderDaoImpl.addOutStoreOrder(outStoreOrder);
	    }
	    public OutStoreOrder getById(int id){
	    	return outStoreOrderDaoImpl.getById(id);
	    }
	    public List<OutStoreOrder> getOutStoreOrders(){
	    	return outStoreOrderDaoImpl.getOutStoreOrders();
	    }
	    public void deleteById(int id){
	    	outStoreOrderDaoImpl.deleteById(id);
	    }
	    public void deleteOne(OutStoreOrder outStoreOrder){
	    	outStoreOrderDaoImpl.deleteOne(outStoreOrder);
	    }
	    public OutStoreOrderDTO getOutStoreOrderDTO(int id){
	    	OutStoreOrder o=outStoreOrderDaoImpl.getById(id);
	    	return this.ConvertToDTO(o);
	        
	    }
	    private OutStoreOrderDTO ConvertToDTO(OutStoreOrder o){
	    	
	    	OutStoreOrderDTO outStoreOrderDTO=new OutStoreOrderDTO();
	        int storeroomkeeperid=o.getstoreroomkeeperid();
	        String storeroomkeepername;
	        int state=o.getState();
	        String statename;
	        int outstoretype=o.getOutstoretype();
	        String outstoretypes;
	        if(storeroomkeeperid==0){
	        	storeroomkeepername="不明";
	    	}
	    	else{
	    		storeroomkeepername=personnelDaoImpl.getById(storeroomkeeperid).getName();
	    	}
	    	if(outstoretype==0){
	    		outstoretypes=OutStoreType.ForSellOutStore.toString();
	    	}
	    	else{
	    		outstoretypes=OutStoreType.PurchaseBackStore.toString();
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
	        outStoreOrderDTO.setId(o.getId());
	        outStoreOrderDTO.setOutdate(o.getOutdate());
	        outStoreOrderDTO.setOutstorenumber(o.getOutstorenumber());
	        outStoreOrderDTO.setOutstoretype(o.getOutstoretype());
	        outStoreOrderDTO.setOutstoretypes(outstoretypes);
	        outStoreOrderDTO.setState(o.getState());
	        outStoreOrderDTO.setStatename(statename);
	        outStoreOrderDTO.setStoreroomkeeperid(o.getstoreroomkeeperid());
	        outStoreOrderDTO.setStoreroomkeepername(storeroomkeepername);
	        return outStoreOrderDTO;
	    }
	    public List<OutStoreOrderDTO> getOutStoreOrderDTOs(){
	    	List outstoreorders=this.getOutStoreOrders();
	    	Iterator<OutStoreOrder> iter=outstoreorders.iterator();
	    	List<OutStoreOrderDTO> inStoreOrderDTOs=new ArrayList<OutStoreOrderDTO>();
	    	while(iter.hasNext()){
	    		OutStoreOrder o=iter.next();
		    	OutStoreOrderDTO outStoreOrderDTO=this.ConvertToDTO(o);
		       
		        inStoreOrderDTOs.add(outStoreOrderDTO);
	    	}
	    	return inStoreOrderDTOs;
	    }
	    
}
