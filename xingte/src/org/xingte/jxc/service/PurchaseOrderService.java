package org.xingte.jxc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xingte.jxc.util.*;
import org.xingte.jxc.model.Product;
import org.xingte.jxc.model.PurchaseOrder;
import org.xingte.jxc.dto.ProductDTO;
import org.xingte.jxc.dto.PurchaseOrderDTO;
import org.xingte.jxc.daoimpl.PurchaseOrderDaoImpl;
import org.xingte.jxc.daoimpl.SupplierDaoImpl;
import org.xingte.jxc.daoimpl.PersonnelDaoImpl;
import org.xingte.jxc.model.Supplier;

public class PurchaseOrderService {
	private PurchaseOrderDaoImpl purchaseOrderDaoImpl=new PurchaseOrderDaoImpl();
	private SupplierDaoImpl supplierDaoImpl=new SupplierDaoImpl();
	private PersonnelDaoImpl personnelDaoImpl=new PersonnelDaoImpl();
	public void addPurchaseOrder(PurchaseOrder purchaseOrder){
    	purchaseOrderDaoImpl.addPurchaseOrder(purchaseOrder);
    }
    public PurchaseOrder getById(int id){
    	return purchaseOrderDaoImpl.getById(id);
    }
    public PurchaseOrder getByNum(String num){
    	return purchaseOrderDaoImpl.getByNum(num);
    }
    public List<PurchaseOrder> getPurchaseOrders(){
    	return purchaseOrderDaoImpl.getPurchaseOrders();
    }
    public List<PurchaseOrderDTO> getPurchaseOrdersBySupplierName(String suppliername){
    	int supplierid;
    	Supplier s=supplierDaoImpl.getByName(suppliername);
    	supplierid=s.getId();
    	
    	Iterator<PurchaseOrder> iter=purchaseOrderDaoImpl.
    		getPurchaseOrdersBySupplierName(supplierid).iterator();
		List<PurchaseOrderDTO> purchaseOrderDTOs=new ArrayList<PurchaseOrderDTO>();

    	while(iter.hasNext()){
    		PurchaseOrderDTO purchaseOrderDTO=this.ConvertToDTO(iter.next());
        	purchaseOrderDTOs.add(purchaseOrderDTO);
		}
		return purchaseOrderDTOs;
    	
    }
    public void deleteById(int id){
    	purchaseOrderDaoImpl.deleteById(id);
    }
    public void deleteOne(PurchaseOrder purchaseOrder){
    	purchaseOrderDaoImpl.deleteOne(purchaseOrder);
    }
    public PurchaseOrderDTO getPurchaseOrder(int id){
    	PurchaseOrderDTO purchaseOrderDTO=new PurchaseOrderDTO();
    	PurchaseOrder p=purchaseOrderDaoImpl.getById(id);
    	return this.ConvertToDTO(p);
    }
    //将一个PurchaseOrder转换为PurchaseOrderDTO
    private PurchaseOrderDTO ConvertToDTO(PurchaseOrder p){
    	PurchaseOrderDTO purchaseOrderDTO=new PurchaseOrderDTO();
    	int supplierid=p.getSupplierid();    	
    	int salesmanid=p.getSalesmanid();
    	String suppliername;
    	String salesmanname;
    	if(supplierid==0){
    		suppliername="不明";
    	}
    	else{
    		suppliername=supplierDaoImpl.getById(supplierid).getName();
    	}
    	if(salesmanid==0){
    		salesmanname="无";
    	}
    	else{
    		salesmanname=personnelDaoImpl.getById(salesmanid).getName();
    	}
    	int state=p.getState();
    	String statename;
    	if(state==0){
    		statename=OrderState.Unsend.toString();
    	}
    	else if(state==1){
    		statename=OrderState.Send.toString();
    	}
    	else{
    		statename=OrderState.Received.toString();
    	}
    	
    	purchaseOrderDTO.setId(p.getId());
    	purchaseOrderDTO.setPurchasedate(p.getPurchasedate());
    	purchaseOrderDTO.setPurchasenumber(p.getPurchasenumber());
    	purchaseOrderDTO.setSalesmanid(p.getSalesmanid());
    	purchaseOrderDTO.setSalesmanname(salesmanname);
    	purchaseOrderDTO.setState(p.getState());
    	purchaseOrderDTO.setStatename(statename);
    	purchaseOrderDTO.setSupplierid(p.getSupplierid());
    	purchaseOrderDTO.setSuppliername(suppliername);
    	
    	return purchaseOrderDTO;
    }
    
    //将一个PurchaseOrder列表转换为PurchaseOrderDTO列表
    private List<PurchaseOrderDTO> ConvertToDTOs(List<PurchaseOrder> purchaseOrders){
    	Iterator<PurchaseOrder> iter=purchaseOrders.iterator();
		List<PurchaseOrderDTO> purchaseOrderDTOs=new ArrayList<PurchaseOrderDTO>();

    	while(iter.hasNext()){
    		PurchaseOrderDTO purchaseOrderDTO=this.ConvertToDTO(iter.next());
        	purchaseOrderDTOs.add(purchaseOrderDTO);
		}
		return purchaseOrderDTOs;
    }
    
    public List<PurchaseOrderDTO> getAllPurchaseOrders(){
    	List purchaseOrders=this.getPurchaseOrders();
		
		return this.ConvertToDTOs(purchaseOrders);
    } 
    public List<PurchaseOrderDTO> getPurchseOrdersByState(int state){
    	List purchaseOrders=purchaseOrderDaoImpl.getPurchaseOrders(state);
    	return this.ConvertToDTOs(purchaseOrders);
    }
}
