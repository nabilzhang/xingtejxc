package org.xingte.jxc.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.User;
import org.xingte.jxc.util.HibernateUtil;

public class UserDaoImpl {
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public boolean existByUsername(String username){
		boolean flag=false;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from User u where u.name='"+username+"'");
		int count=q.list().size();
		if(count>0){
			flag=true;
		}
		return flag;
	}
	public boolean existByUsernameAndPassWord(String username,String password){
		boolean flag=false;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from User u where u.name='"+username+"' and u.password='"+password+"'");
		int count=q.list().size();
		if(count>0){
			flag=true;
		}
		return flag;
	}
	public void add(User u){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}
	
	public List<User> getUsers(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from User u");
		List<User> users=q.list();
		s.getTransaction().commit();
		return users;
	}
	
	public User getOneById(int id){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from User u where u.id ="+id);
		User user=(User)q.list().get(0);
		return user;
	}
	public User getOneByName(String name){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query) s.createQuery("from User u where u.name ='"+name+"'");
		User user=(User)q.list().get(0);
		return user;
	}
}
