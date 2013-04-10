package org.xingte.jxc.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xingte.jxc.model.Limit;
import org.xingte.jxc.util.HibernateUtil;

public class LimitDaoImpl {
	private Limit limit;

	public Limit getLimit() {
		return limit;
	}

	public void setLimit(Limit limit) {
		this.limit = limit;
	}
	
	public void addOne(Limit limit){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(limit);
		s.getTransaction().commit();
	}
	
	public void deleteLimit(Limit limit){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.delete(limit);
		s.getTransaction().commit();
	}
	public Limit getOneLimitById(int id){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Limit a where a.id="+id);
		Limit limit=(Limit)q.list().get(0);
		return limit;
	}
	public List<Limit> getAll(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Limit a");
		List<Limit> limits=q.list();
		return limits;
	}
	public List<Limit> getLimitsByGroupId(int gid){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Limit a where a.usergroupid="+gid);
		List<Limit> limits=q.list();
		return limits;
	}
}
