package org.xingte.jxc.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.Personnel;
import org.xingte.jxc.util.HibernateUtil;
public class PersonnelDaoImpl {
    private Personnel personnel;
    public Personnel getPersonnel(){
    	return this.personnel;
    }
    public void setPersonnel(Personnel personnel){
    	this.personnel=personnel;
    }
    public void addPersonnel(Personnel personnel){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.save(personnel);
    	s.getTransaction().commit();

    }
    public Personnel getById(int id){
     	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from Personnel p where id="+id);
    	Personnel personnel=(Personnel)q.list().get(0);
    	return personnel;
    }
    public List<Personnel> getPersonnels(){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from Personnel p");
    	List<Personnel> personnels=q.list();
    	return personnels;
    }
    public void deleteById(int id){
       	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from Personnel p where id="+id);
    	Personnel personnel=(Personnel)q.list().get(0);
    	s.delete(personnel);
    	s.flush();
    	s.close();
    }
    public void deleteOne(Personnel personnel){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.delete(personnel);
    	s.flush();
    	s.close();
    }
}
