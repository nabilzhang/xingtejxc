package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.model.PurchaseItem;
import org.xingte.jxc.model.SellItem;
import org.xingte.jxc.util.ItemState;
import org.xingte.jxc.daoimpl.SellItemDaoImpl;
import org.xingte.jxc.dto.PurchaseItemDTO;
import org.xingte.jxc.dto.SellItemDTO;
import org.xingte.jxc.daoimpl.ProductDaoImpl;
public class SellItemService {
	private SellItemDaoImpl sellItemDaoImpl=new SellItemDaoImpl();
	private ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	public void addSellItem(SellItem sellItem){
		sellItemDaoImpl.addSellItem(sellItem);
    }
    public SellItem getById(int id){
    	return sellItemDaoImpl.getById(id);
    }
    public List<SellItem> getSellItems(){
    	return sellItemDaoImpl.getSellItems();
    }
    public void deleteById(int id){
    	sellItemDaoImpl.deleteById(id);
    }
    public void deleteOne(SellItem sellItem){
    	sellItemDaoImpl.deleteOne(sellItem);
    }
    public SellItemDTO getSellItemDTO(int id){
    	SellItem s=sellItemDaoImpl.getById(id);
    	SellItemDTO sellItemDTO=this.ConvertToDTO(s);
    	
    	return sellItemDTO;
    }
    private SellItemDTO ConvertToDTO(SellItem s){
    	SellItemDTO sellItemDTO=new SellItemDTO();
    	int productid=s.getId();
    	String productname;
    	int state=s.getSaleid();
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
    	sellItemDTO.setAmount(s.getAmount());
    	sellItemDTO.setId(s.getId());
    	sellItemDTO.setProductid(s.getProductid());
    	sellItemDTO.setProductname(productname);
    	sellItemDTO.setSellid(s.getSaleid());
    	sellItemDTO.setSellprice(s.getSellprice());
    	sellItemDTO.setState(s.getState());
    	sellItemDTO.setStatename(statename);
    	sellItemDTO.setUnits(s.getUnits());
    	return sellItemDTO;
    }
    public List<SellItemDTO> getSellItemDTOs(){
    	List sellItems=this.getSellItems();
		Iterator<SellItem> iter=sellItems.iterator();
		List<SellItemDTO> sellItemDTOs=new ArrayList<SellItemDTO>();
		
    	while(iter.hasNext()){
    		SellItem s=iter.next();
        	SellItemDTO sellItemDTO=this.ConvertToDTO(s);
        	
        	sellItemDTOs.add(sellItemDTO);
    	}
    	return sellItemDTOs;
    }
    public List<SellItemDTO> getSellItemDTOs(int sellid){
    	List sellItems=sellItemDaoImpl.getSellItems(sellid);
		Iterator<SellItem> iter=sellItems.iterator();
		List<SellItemDTO> sellItemDTOs=new ArrayList<SellItemDTO>();
		
    	while(iter.hasNext()){
    		SellItem s=iter.next();
        	SellItemDTO sellItemDTO=this.ConvertToDTO(s);
        	
        	sellItemDTOs.add(sellItemDTO);
    	}
    	return sellItemDTOs;
    }
}
