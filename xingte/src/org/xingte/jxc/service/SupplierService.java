package org.xingte.jxc.service;

import java.util.List;

import org.xingte.jxc.daoimpl.SupplierDaoImpl;
import org.xingte.jxc.model.Supplier;

public class SupplierService {
	private SupplierDaoImpl supplierDaoImpl=new SupplierDaoImpl();
	
	public void addSupplier(Supplier supplier){
		supplierDaoImpl.addSupplier(supplier);
	}
	
	public List<Supplier> getAllSuppliers(){
		return supplierDaoImpl.getSuppliers();
	}
	
	public Supplier getSupplier(int id){
		return supplierDaoImpl.getById(id);
	}
}
