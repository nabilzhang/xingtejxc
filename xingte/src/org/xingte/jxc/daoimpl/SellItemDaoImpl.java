package org.xingte.jxc.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.SellItem;

import org.xingte.jxc.util.HibernateUtil;
public class SellItemDaoImpl {
	 private SellItem sellItem;
	    public SellItem getSellItem(){
	    	return this.sellItem;
	    }
	    public void setSellItem(SellItem sellItem){
	    	this.sellItem=sellItem;
	    }
	    public void addSellItem(SellItem sellItem){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.save(sellItem);
	        s.flush();
	    	s.getTransaction().commit();
	    	s.close();
	    }
	    public SellItem getById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from SellItem s where s.id="+id);
	    	SellItem sellItem=(SellItem)q.list().get(0);
	    	return sellItem;
	    }
	    public List<SellItem> getSellItems(){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from SellItem s");
	    	List<SellItem> sellItems=q.list();
	    	return sellItems;
	    }
	    public List<SellItem> getSellItems(int sellid){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from SellItem s where s.sellid="+sellid);
	    	List<SellItem> sellItems=q.list();
	    	return sellItems;
	    }
	    public void deleteById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from SellItem s where s.id="+id);
	    	SellItem sellItem=(SellItem)q.list().get(0);
	    	s.delete(sellItem);
	    	s.flush();
	    	s.close();
	    }
	    public void deleteOne(SellItem sellItem){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.delete(sellItem);
	    	s.flush();
	    	s.close();
	    }
}
