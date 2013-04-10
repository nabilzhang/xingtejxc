package org.xingte.jxc.daoimpl;
import java.util.List;
import org.xingte.jxc.model.InStoreOrder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.util.HibernateUtil;

public class InStoreOrderDaoImpl {
	 private InStoreOrder inStoreOrder;
	    public InStoreOrder getInStoreOrder(){
	    	return this.inStoreOrder;
	    }
	    public void setInStoreOrder(InStoreOrder inStoreOrder){
	    	this.inStoreOrder=inStoreOrder;
	    }
	    public void addInStoreOrder(InStoreOrder inStoreOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.save(inStoreOrder);
	    	s.flush();
	    	s.getTransaction().commit();
	        s.close();
	    }
	    public InStoreOrder getById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from InStoreOrder i where i.id="+id);
	    	InStoreOrder inStoreOrder =(InStoreOrder)q.list().get(0);
	    	return inStoreOrder;
	    }
	    public List<InStoreOrder> getInStoreOrders(){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from InStoreOrder i");
	    	List<InStoreOrder> inStoreOrders =q.list();
	    	return inStoreOrders;
	    }
	    public void deleteById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from InStoreOrder i where i.id="+id);
	    	InStoreOrder inStoreOrder =(InStoreOrder)q.list().get(0);
	    	s.delete(inStoreOrder);
	    	s.flush();
	    	s.close();
	    }
	    public void deleteOne(InStoreOrder inStoreOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.delete(inStoreOrder);
	    	s.flush();
	    	s.close();
	    }
}
