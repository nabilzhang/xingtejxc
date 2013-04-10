package org.xingte.jxc.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.SellOrder;
import org.xingte.jxc.util.HibernateUtil;

public class SellOrderDaoImpl {
	   private SellOrder sellOrder;
	    public SellOrder getSellOrder(){
	    	return this.sellOrder;
	    }
	    public void setSellOrder(SellOrder sellOrder){
	    	this.sellOrder=sellOrder;
	    }
	    public void addSellOrder(SellOrder sellOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.save(sellOrder);
	        s.flush();
	    	s.getTransaction().commit();
	    	s.close();
	    }
	    public SellOrder getById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from SellOrder s where s.id="+id);
	    	SellOrder sellOrder=(SellOrder)q.list().get(0);
	    	return sellOrder;
	    }
	    public List<SellOrder> getSellOrders(){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from SellOrder s");
	    	List<SellOrder> sellOrders=q.list();
	    	return sellOrders;
	    }
	    public void deleteById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from SellOrder s where s.id="+id);
	    	SellOrder sellOrder=(SellOrder)q.list().get(0);
	    	s.delete(sellOrder);
	    	s.flush();
	    	s.close();
	    }
	    public void deleteOne(SellOrder sellOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.delete(sellOrder);
	    	s.flush();
	    	s.close();
	    }
}
