package org.xingte.jxc.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import org.xingte.jxc.model.PurchaseItem;

import org.xingte.jxc.util.HibernateUtil;
public class PurchaseItemDaoImpl {
	private PurchaseItem purchaseItem;
    public PurchaseItem getPurchaseItem(){
    	return this.purchaseItem;
    }
    public void setPurchaseItem(PurchaseItem purchaseItem){
    	this.purchaseItem=purchaseItem;
    }
    public void addPurchaseItem(PurchaseItem purchaseItem){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.save(purchaseItem);
        s.flush();
    	s.getTransaction().commit();
    	s.close();
    }
    public PurchaseItem getById(int id){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from PurchaseItem s where s.id="+id);
    	PurchaseItem purchaseItem=(PurchaseItem)q.list().get(0);
    	return purchaseItem;
    }
    public List<PurchaseItem> getPurchaseItems(){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from PurchaseItem s");
    	List<PurchaseItem> purchaseItems=q.list();
    	return purchaseItems;
    }
    public List<PurchaseItem> getPurchaseItems(int orderid){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from PurchaseItem s where s.purchaseid="+orderid);
    	List<PurchaseItem> purchaseItems=q.list();
    	return purchaseItems;
    }
    
    public void deleteById(int id){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from PurchaseItem s where s.id="+id);
    	PurchaseItem purchaseItem=(PurchaseItem)q.list().get(0);
    	s.delete(purchaseItem);
    	s.flush();
    	s.close();
    }
    public void deleteOne(PurchaseItem purchaseItem){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.delete(purchaseItem);
    	s.flush();
    	s.close();
    }
}
