package org.xingte.jxc.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xingte.jxc.model.Department;
import org.xingte.jxc.util.HibernateUtil;

public class DepartmentDaoImpl {
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void addOne(Department department){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(department);
		s.getTransaction().commit();
	}
	
	public void deleteOne(Department department){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.delete(department);
		s.getTransaction().commit();
	}
	
	public Department getOneById(int id){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Department d where d.id="+id);
		Department department=(Department)q.list().get(0);
		return department;
	}
	
	public List<Department> getAll(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Department d");
		List<Department> departments=q.list();
		return departments;
	}
}
