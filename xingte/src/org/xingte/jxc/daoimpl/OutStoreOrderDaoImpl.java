package org.xingte.jxc.daoimpl;
import java.util.List;
import org.xingte.jxc.model.OutStoreOrder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.util.HibernateUtil;

public class OutStoreOrderDaoImpl {
	 private OutStoreOrder outStoreOrder;
	    public OutStoreOrder getOutStoreOrder(){
	    	return this.outStoreOrder;
	    }
	    public void setOutStoreOrder(OutStoreOrder outStoreOrder){
	    	this.outStoreOrder=outStoreOrder;
	    }
	    public void addOutStoreOrder(OutStoreOrder outStoreOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.save(outStoreOrder);
	    	s.flush();
	    	s.getTransaction().commit();
	        s.close();
	    }
	    public OutStoreOrder getById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from OutStoreOrder i where i.id="+id);
	    	OutStoreOrder outStoreOrder =(OutStoreOrder)q.list().get(0);
	    	return outStoreOrder;
	    }
	    public List<OutStoreOrder> getOutStoreOrders(){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from OutStoreOrder i");
	    	List<OutStoreOrder> outStoreOrders =q.list();
	    	return outStoreOrders;
	    }
	    public void deleteById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from OutStoreOrder i where i.id="+id);
	    	OutStoreOrder outStoreOrder =(OutStoreOrder)q.list().get(0);
	    	s.delete(outStoreOrder);
	    	s.flush();
	    	s.close();
	    }
	    public void deleteOne(OutStoreOrder outStoreOrder){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.delete(outStoreOrder);
	     	s.flush();
	    	s.close();
	    }
}
