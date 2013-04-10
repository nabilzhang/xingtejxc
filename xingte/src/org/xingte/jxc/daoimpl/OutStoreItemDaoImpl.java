package org.xingte.jxc.daoimpl;
import java.util.List;
import org.xingte.jxc.model.OutStoreItem;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.util.HibernateUtil;

public class OutStoreItemDaoImpl {
	 private OutStoreItem outStoreItem;
	    public OutStoreItem getOutStoreItem(){
	    	return this.outStoreItem;
	    }
	    public void setOutStoreItem(OutStoreItem outStoreItem){
	    	this.outStoreItem=outStoreItem;
	    }
	    public void addOutStoreItem(OutStoreItem outStoreItem){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.save(outStoreItem);
	    	s.flush();
	    	s.getTransaction().commit();
	        s.close();
	    }
	    public OutStoreItem getById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from OutStoreItem i where i.id="+id);
	    	OutStoreItem outStoreItem =(OutStoreItem)q.list().get(0);
	    	return outStoreItem;
	    }
	    public List<OutStoreItem> getOutStoreItems(){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from OutStoreItem i");
	    	List<OutStoreItem> outStoreItems =q.list();
	    	return outStoreItems;
	    }
	    public List<OutStoreItem> getOutStoreItems(int outstoreid){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from OutStoreItem i where i.outstoreid="+outstoreid);
	    	List<OutStoreItem> outStoreItems =q.list();
	    	return outStoreItems;
	    }
	    public void deleteById(int id){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	Query q=(Query)s.createQuery("from OutStoreItem i where i.id="+id);
	    	OutStoreItem outStoreItem =(OutStoreItem)q.list().get(0);
	    	s.delete(outStoreItem);
	    	s.flush();
	    	s.close();
	    }
	    public void deleteOne(OutStoreItem outStoreItem){
	    	SessionFactory sf=HibernateUtil.getSessionFactory();
	    	Session s=sf.getCurrentSession();
	    	s.beginTransaction();
	    	s.delete(outStoreItem);
	    	s.flush();
	    	s.close();
	    }
}
