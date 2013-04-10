package org.xingte.jxc.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.xingte.jxc.daoimpl.ProductDaoImpl;
import org.xingte.jxc.daoimpl.AreaDaoImpl;
import org.xingte.jxc.daoimpl.SupplierDaoImpl;
import org.xingte.jxc.daoimpl.ProCatalogDaoImpl;

import org.xingte.jxc.model.Product;

import org.xingte.jxc.dto.ProductDTO;
public class ProductService {
	private ProductDaoImpl productDaoImpl=new ProductDaoImpl();
	private AreaDaoImpl areaDaoImpl=new AreaDaoImpl();
	private SupplierDaoImpl supplierDaoImpl=new SupplierDaoImpl();
	private ProCatalogDaoImpl proCatalogDaoImpl=new ProCatalogDaoImpl();
    public void addOne(Product product){
    	productDaoImpl.addProduct(product);
	}
	
	public List<Product> getAll(){
		return productDaoImpl.getProducts();
	}
	public Product getOne(int id){
		return productDaoImpl.getById(id);
	}
	public void deleteById(int id){
		productDaoImpl.deleteById(id);
    }
    public void deleteOne(Product product){
    	productDaoImpl.deleteOne(product);
    }
    
    private ProductDTO ConvertToDTO(Product p){
    	ProductDTO productDTO=new ProductDTO();
    	int supplierid=p.getSupplierid();
    	int areaid=p.getAreaid();
    	int catalogid=p.getCatalogid();
    	String suppliername;
    	String areaname;
    	String catalogname;
    	if(supplierid==0){
    		suppliername="不明";
    	}
    	else{
    		suppliername=supplierDaoImpl.getById(supplierid).getName();
    	}
    	if(areaid==0){
    		areaname="不明";
    	}
    	else{
    		areaname=areaDaoImpl.getOneAreaById(areaid).getName();
    	}
    	if(catalogid==0){
    		catalogname="无";
    	}
    	else{
    		catalogname=proCatalogDaoImpl.getOne(catalogid).getName();
    	}
    	productDTO.setId(p.getId());
    	productDTO.setName(p.getName());
    	productDTO.setAreaid(areaid);
    	productDTO.setAreaname(areaname);
    	productDTO.setCatalogid(catalogid);
    	productDTO.setCatalogname(catalogname);
    	productDTO.setInprice(p.getInprice());
    	productDTO.setLowprice(p.getLowprice());
    	productDTO.setProductnumber(p.getProductnumber());
    	productDTO.setSaleprice(p.getSaleprice());
    	productDTO.setState(p.getState());
    	productDTO.setStore(p.getStore());
    	productDTO.setSupplierid(supplierid);
    	productDTO.setSuppliername(suppliername);
    	productDTO.setUnits(p.getUnits());
    	return productDTO;
    }
    
    public ProductDTO getProductDTO(int id){
    	Product p=productDaoImpl.getById(id);
    	return this.ConvertToDTO(p);
    }
    public List<ProductDTO> getAllProducts(){
    	List products=this.getAll();
		Iterator<Product> iter=products.iterator();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		
    	while(iter.hasNext()){
    		Product p=iter.next();
        	ProductDTO productDTO=this.ConvertToDTO(p);
        	productDTOs.add(productDTO);
		}
		return productDTOs;
    }
    
    public List<ProductDTO> getAllProducts(int supplierid,int catalogid){
    	List products=productDaoImpl.getProducts(supplierid, catalogid);
		Iterator<Product> iter=products.iterator();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		
    	while(iter.hasNext()){
    		Product p=iter.next();
        	ProductDTO productDTO=this.ConvertToDTO(p);
        	productDTOs.add(productDTO);
		}
		return productDTOs;
    }
    
    public List<ProductDTO> getAllProducts(int catalogid){
    	List products=productDaoImpl.getProductsByCatalogid(catalogid);
		Iterator<Product> iter=products.iterator();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		
    	while(iter.hasNext()){
    		Product p=iter.next();
        	ProductDTO productDTO=this.ConvertToDTO(p);
        	productDTOs.add(productDTO);
		}
		return productDTOs;
    }
    
    public List<ProductDTO> getAllProductsBySupplierid(int supplierid){
    	List products=productDaoImpl.getProducts(supplierid);
		Iterator<Product> iter=products.iterator();
		List<ProductDTO> productDTOs=new ArrayList<ProductDTO>();
		
    	while(iter.hasNext()){
    		Product p=iter.next();
        	ProductDTO productDTO=this.ConvertToDTO(p);
        	productDTOs.add(productDTO);
		}
		return productDTOs;
    }
}
