package org.xingte.jxc.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.UserGroup;
import org.xingte.jxc.util.HibernateUtil;

public class UserGroupDaoImpl {
	private UserGroup userGroup;
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	public Boolean existById(int id){
		Boolean b=false;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from UserGroup u where id="+id);
		int count=q.list().size();
		if(count>0){
			b=true;
		}
		return b;
	}
	
	public void add(UserGroup u){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}
	public List<UserGroup> getUserGroups(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from UserGroup u");
		List<UserGroup> userGroups=q.list();
		s.getTransaction().commit();
		return userGroups;
	}
	
	public UserGroup getOneById(int id){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from UserGroup u where u.id ="+id);
		UserGroup userGroup=(UserGroup)q.list().get(0);
		return userGroup;
	}
	public void deleteById(int id){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from UserGroup u where u.id="+id);
    	UserGroup userGroup=(UserGroup)q.list().get(0);
    	s.delete(userGroup);
    	s.flush();
    	s.close();
    }
    public void deleteOne(UserGroup userGroup){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.delete(userGroup);
    	s.flush();
    	s.close();
    }
}
