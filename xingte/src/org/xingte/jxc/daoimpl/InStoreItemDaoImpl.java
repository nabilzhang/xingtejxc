package org.xingte.jxc.daoimpl;
import java.util.List;
import org.xingte.jxc.model.InStoreItem;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.util.HibernateUtil;

public class InStoreItemDaoImpl {
    private InStoreItem inStoreItem;
    public InStoreItem getInStoreItem(){
    	return this.inStoreItem;
    }
    public void setInStoreItem(InStoreItem inStoreItem){
    	this.inStoreItem=inStoreItem;
    }
    public void addInStoreItem(InStoreItem inStoreItem){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.save(inStoreItem);
    	s.flush();
    	s.getTransaction().commit();
        s.close();
    }
    public InStoreItem getById(int id){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from InStoreItem i where i.id="+id);
    	InStoreItem inStoreItem =(InStoreItem)q.list().get(0);
    	return inStoreItem;
    }
    public List<InStoreItem> getInStoreItems(){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from InStoreItem i");
    	List<InStoreItem> inStoreItems =q.list();
    	return inStoreItems;
    }
    public void deleteById(int id){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from InStoreItem i where i.id="+id);
    	InStoreItem inStoreItem =(InStoreItem)q.list().get(0);
    	s.delete(inStoreItem);
    	s.flush();
    	s.close();
    }
    public void deleteOne(InStoreItem inStoreItem){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.delete(inStoreItem);
    	s.flush();
    	s.close();
    }
   
}
