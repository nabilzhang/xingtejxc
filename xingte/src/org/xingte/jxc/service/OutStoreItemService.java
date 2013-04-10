package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.xingte.jxc.model.OutStoreItem;

import org.xingte.jxc.util.*;
import org.xingte.jxc.daoimpl.OutStoreItemDaoImpl;
import org.xingte.jxc.dto.OutStoreItemDTO;
import org.xingte.jxc.daoimpl.ProductDaoImpl;
public class OutStoreItemService {
	private OutStoreItemDaoImpl outStoreItemDaoImpl=new OutStoreItemDaoImpl();
	private ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	 public void addOutStoreItem(OutStoreItem outStoreItem){
		 outStoreItemDaoImpl.addOutStoreItem(outStoreItem);
	    }
	    public OutStoreItem getById(int id){
	    	return outStoreItemDaoImpl.getById(id);
	    }
	    public List<OutStoreItem> getOutStoreItems(){
	    	return outStoreItemDaoImpl.getOutStoreItems();
	    }
	    public void deleteById(int id){
	    	outStoreItemDaoImpl.deleteById(id);
	    }
	    public void deleteOne(OutStoreItem outStoreItem){
	    	outStoreItemDaoImpl.deleteOne(outStoreItem);
	    }
	    public OutStoreItemDTO getOutStoreItemDTO(int id){
	    	OutStoreItem o=outStoreItemDaoImpl.getById(id);
	    	OutStoreItemDTO outStoreItemDTO=this.ConvertToDTO(o);
	       
	        return outStoreItemDTO;
	    }
	    private OutStoreItemDTO ConvertToDTO(OutStoreItem o){
	    	
	    	OutStoreItemDTO outStoreItemDTO=new OutStoreItemDTO();
	        int productid=o.getProductid();
	        String productname;
	        int state=o.getState();
	        String statename;
	        if(productid==0){
	        	productname="不明";
	    	}
	    	else{
	    		productname=productDaoImpl.getById(productid).getName();
	    	}
	    	if(state==0){
	    		statename=ItemState.Unfinish.toString();
	    	}
	    	else{
	    		statename=ItemState.Finished.toString();
	    	}
	    	
	    	outStoreItemDTO.setAmount(o.getAmount());
	    	outStoreItemDTO.setId(o.getId());
	    	outStoreItemDTO.setOutprice(o.getOutprice());
	    	outStoreItemDTO.setOutstoreid(o.getOutstoreid());
	    	outStoreItemDTO.setProductid(o.getProductid());
	    	outStoreItemDTO.setProductname(productname);
	    	outStoreItemDTO.setState(o.getState());
	    	outStoreItemDTO.setStatename(statename);
	    	outStoreItemDTO.setUnits(o.getUnits());
	        return outStoreItemDTO;
	    }
	    public List<OutStoreItemDTO> getOutStoreItemDTOs(){
	    	List outstoreitems=this.getOutStoreItems();
	    	Iterator<OutStoreItem> iter=outstoreitems.iterator();
	    	List<OutStoreItemDTO> inStoreItemDTOs=new ArrayList<OutStoreItemDTO>();
	    	while(iter.hasNext()){
	    		OutStoreItem o=iter.next();
		    	OutStoreItemDTO outStoreItemDTO=this.ConvertToDTO(o);
		        
		    	inStoreItemDTOs.add(outStoreItemDTO);
	    	}
	    	return inStoreItemDTOs;
	    }
	    public List<OutStoreItemDTO> getOutStoreItemDTOs(int outstoreid){
	    	List outstoreitems=outStoreItemDaoImpl.getOutStoreItems(outstoreid);
	    	Iterator<OutStoreItem> iter=outstoreitems.iterator();
	    	List<OutStoreItemDTO> inStoreItemDTOs=new ArrayList<OutStoreItemDTO>();
	    	while(iter.hasNext()){
	    		OutStoreItem o=iter.next();
		    	OutStoreItemDTO outStoreItemDTO=this.ConvertToDTO(o);
		        
		    	inStoreItemDTOs.add(outStoreItemDTO);
	    	}
	    	return inStoreItemDTOs;
	    }
}
