package org.xingte.jxc.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xingte.jxc.model.Area;
import org.xingte.jxc.util.HibernateUtil;

public class AreaDaoImpl {
	private Area area;

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	public void addOne(Area area){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(area);
		s.getTransaction().commit();
	}
	
	public void deleteArea(Area area){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.delete(area);
		s.getTransaction().commit();
	}
	public Area getOneAreaById(int id){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Area a where a.id="+id);
		Area area=(Area)q.list().get(0);
		return area;
	}
	public List<Area> getAll(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Area a");
		List<Area> areas=q.list();
		return areas;
	}
}
