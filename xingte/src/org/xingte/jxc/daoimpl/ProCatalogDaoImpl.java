package org.xingte.jxc.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.ProCatalog;
import org.xingte.jxc.util.HibernateUtil;

public class ProCatalogDaoImpl {
	private ProCatalog proCatalog;

	public ProCatalog getProCatalog() {
		return proCatalog;
	}

	public void setProCatalog(ProCatalog proCatalog) {
		this.proCatalog = proCatalog;
	}
	
	public void addOne(ProCatalog proCatalog){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(proCatalog);
		s.getTransaction().commit();
	}
	
	public List<ProCatalog> getAll(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from ProCatalog p");
		List<ProCatalog> proCatalogs=q.list();
		s.getTransaction().commit();
		return proCatalogs;
	}
	public ProCatalog getOne(int id){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from ProCatalog p where p.id ="+id);
		ProCatalog proCatalog=(ProCatalog)q.list().get(0);
		return proCatalog;
	}
	public void deleteById(int id){
	     SessionFactory sf=HibernateUtil.getSessionFactory();
	     Session s=sf.getCurrentSession();
	     s.beginTransaction();
	     Query q=(Query)s.createQuery("from ProCatalog p where id="+id);
	     ProCatalog proCatalog=(ProCatalog)q.list().get(0);
	     s.delete(proCatalog);
	     s.flush();
	     s.close();
	    }
	public void deleteOne(ProCatalog proCatalog){
	     SessionFactory sf=HibernateUtil.getSessionFactory();
	     Session s=sf.getCurrentSession();
	     s.beginTransaction();
	   
	     s.delete(proCatalog);
	     s.flush();
	     s.close();
	    }
}
