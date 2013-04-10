package org.xingte.jxc.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import org.xingte.jxc.model.PurchaseOrder;

import org.xingte.jxc.util.HibernateUtil;
public class PurchaseOrderDaoImpl {
	 private PurchaseOrder purchaseOrder;
	    public PurchaseOrder getPurchaseOrder(){
	    	return this.purchaseOrder;
	    }
	    public void setPurchaseOrder(PurchaseOrder purchaseOrder){
	    	this.purchaseOrder=purchaseOrder;
	    }
	    public void addPurchaseOrder(PurchaseOrder purchaseOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.save(purchaseOrder);
	    	s.getTransaction().commit();

	    }
	    public PurchaseOrder getById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from PurchaseOrder s where s.id="+id);
	    	PurchaseOrder purchaseOrder=(PurchaseOrder)q.list().get(0);
	    	return purchaseOrder;
	    }
	    
	    public PurchaseOrder getByNum(String num){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from PurchaseOrder s where s.purchasenumber='"+num+"'");
	    	PurchaseOrder purchaseOrder=(PurchaseOrder)q.list().get(0);
	    	return purchaseOrder;
	    }
	    public List<PurchaseOrder> getPurchaseOrders(){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from PurchaseOrder s");
	    	List<PurchaseOrder> purchaseOrders=q.list();
	    	return purchaseOrders;
	    }
	    public List<PurchaseOrder> getPurchaseOrdersBySupplierName(int supplierid){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from PurchaseOrder s where s.supplierid="+supplierid);
	    	List<PurchaseOrder> purchaseOrders=q.list();
	    	return purchaseOrders;
	    }
	    public List<PurchaseOrder> getPurchaseOrders(int state){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from PurchaseOrder s where s.state="+state);
	    	List<PurchaseOrder> purchaseOrders=q.list();
	    	return purchaseOrders;
	    }
	    
	    public void deleteById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from PurchaseOrder s where s.id="+id);
	    	PurchaseOrder purchaseOrder=(PurchaseOrder)q.list().get(0);
	    	s.delete(purchaseOrder);
	    	s.flush();
	    	s.close();
	    }
	    public void deleteOne(PurchaseOrder purchaseOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.delete(purchaseOrder);
	    	s.flush();
	    	s.close();
	    }
}
