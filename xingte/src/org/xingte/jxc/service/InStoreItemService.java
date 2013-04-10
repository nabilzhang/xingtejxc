package org.xingte.jxc.service;

import java.util.List;
import org.xingte.jxc.util.*;

import org.xingte.jxc.model.InStoreItem;
import org.xingte.jxc.daoimpl.InStoreItemDaoImpl;
import org.xingte.jxc.dto.InStoreItemDTO;
import org.xingte.jxc.daoimpl.ProductDaoImpl;
public class InStoreItemService {
	private InStoreItemDaoImpl inStoreItemDaoImpl=new InStoreItemDaoImpl();
	private ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	public void addInStoreItem(InStoreItem inStoreItem){
		inStoreItemDaoImpl.addInStoreItem(inStoreItem);
    }
    public InStoreItem getById(int id){
    	
        return inStoreItemDaoImpl.getById(id);
    }
    public List<InStoreItem> getInStoreItems(){
    	return inStoreItemDaoImpl.getInStoreItems();
    }
    public void deleteById(int id){
    	inStoreItemDaoImpl.deleteById(id);
    }
    public void deleteOne(InStoreItem inStoreItem){
    	inStoreItemDaoImpl.deleteOne(inStoreItem);
    }
    public InStoreItemDTO getInStoreItem(int id){
    	InStoreItem i=inStoreItemDaoImpl.getById(id);
    	InStoreItemDTO inStoreItemDTO=new InStoreItemDTO();
    	int productid=i.getId();
    	int state=i.getState();
    	String productname;
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
    	inStoreItemDTO.setAmount(i.getAmount());
    	inStoreItemDTO.setId(i.getId());
    	inStoreItemDTO.setInprice(i.getInprice());
    	inStoreItemDTO.setInstoreid(i.getInstoreid());
    	inStoreItemDTO.setProductid(i.getProductid());
    	inStoreItemDTO.setProductname(productname);
    	inStoreItemDTO.setState(i.getState());
    	inStoreItemDTO.setStatename(statename);
    	inStoreItemDTO.setUnits(i.getUnits());
    	return inStoreItemDTO;
    }
}
