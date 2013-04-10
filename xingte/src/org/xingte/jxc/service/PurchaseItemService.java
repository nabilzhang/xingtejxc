package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.daoimpl.PurchaseItemDaoImpl;
import org.xingte.jxc.model.Product;
import org.xingte.jxc.model.PurchaseItem;
import org.xingte.jxc.model.PurchaseOrder;
import org.xingte.jxc.util.ItemState;
import org.xingte.jxc.dto.ProductDTO;
import org.xingte.jxc.dto.PurchaseItemDTO;
import org.xingte.jxc.daoimpl.ProductDaoImpl;
public class PurchaseItemService {
	PurchaseItemDaoImpl purchaseItemDaoImpl=new PurchaseItemDaoImpl();
	ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	public void addPurchaseItem(PurchaseItem purchaseItem){
		purchaseItemDaoImpl.addPurchaseItem(purchaseItem);
    }
    public PurchaseItem getById(int id){
    	return purchaseItemDaoImpl.getById(id);
    }
    public List<PurchaseItem> getPurchaseItems(){
    	return purchaseItemDaoImpl.getPurchaseItems();
    }
    public void deleteById(int id){
    	purchaseItemDaoImpl.deleteById(id);
    }
    public void deleteOne(PurchaseItem purchaseItem){
    	purchaseItemDaoImpl.deleteOne(purchaseItem);
    }
    private PurchaseItemDTO ConvertToDTO(PurchaseItem p){
    	PurchaseItemDTO purchaseItemDTO=new PurchaseItemDTO();
    	int productid=p.getId();
    	int state=p.getState();
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
    	purchaseItemDTO.setId(p.getId());
    	purchaseItemDTO.setAmount(p.getAmount());
    	purchaseItemDTO.setProductid(p.getProductid());
    	purchaseItemDTO.setProductname(productname);
    	purchaseItemDTO.setPurchaseid(p.getPurchaseid());
    	purchaseItemDTO.setPurchaseprice(p.getPurchaseprice());
    	purchaseItemDTO.setState(p.getState());
    	purchaseItemDTO.setStatename(statename);
    	purchaseItemDTO.setUnits(p.getUnits());
    	return purchaseItemDTO;
    }
    
    public PurchaseItemDTO getPurchaseItemDTO(int id){
    	PurchaseItem p=purchaseItemDaoImpl.getById(id);
    	return this.ConvertToDTO(p);
    }
    public List<PurchaseItemDTO> getPurchaseItemDTOs(){
    	List purchaseItems=this.getPurchaseItems();
		Iterator<PurchaseItem> iter=purchaseItems.iterator();
		List<PurchaseItemDTO> purchaseItemDTOs=new ArrayList<PurchaseItemDTO>();
		
    	while(iter.hasNext()){
    		PurchaseItem p=iter.next();
    		PurchaseItemDTO purchaseItemDTO=this.ConvertToDTO(p);
        	purchaseItemDTOs.add(purchaseItemDTO);
		}
		return purchaseItemDTOs;
    }
    //根据订单id返回item
    public List<PurchaseItemDTO> getPurchaseItemDTOs(int porid){
    	List purchaseItems=purchaseItemDaoImpl.getPurchaseItems(porid);
    	Iterator<PurchaseItem> iter=purchaseItems.iterator();
		List<PurchaseItemDTO> purchaseItemDTOs=new ArrayList<PurchaseItemDTO>();
		
    	while(iter.hasNext()){
    		PurchaseItem p=iter.next();
    		PurchaseItemDTO purchaseItemDTO=this.ConvertToDTO(p);
        	purchaseItemDTOs.add(purchaseItemDTO);
		}
		return purchaseItemDTOs;
    }
}
