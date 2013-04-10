package org.xingte.jxc.daoimpl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.Supplier;
import org.xingte.jxc.util.HibernateUtil;
public class SupplierDaoImpl {
    private Supplier supplier;
    public Supplier getSupplier(){
    	return this.supplier;
    }
    public void setSupplier(Supplier supplier){
    	this.supplier=supplier;
    }
    //添加一个供货商
    /**
     * @param id
     * @return null
     */
    public void addSupplier(Supplier supplier){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.save(supplier);
        s.flush();
    	s.getTransaction().commit();
    	s.close();
    }
    /**
     * 返回一个供货商
     * @param id
     * @return Supplier
     */
    public Supplier getById(int id){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from Supplier s where s.id="+id);
    	Supplier supplier=(Supplier)q.list().get(0);
    	return supplier;
    }
    public Supplier getByName(String name){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from Supplier s where s.name="+name);
    	Supplier supplier=(Supplier)q.list().get(0);
    	return supplier;
    }
    /**
     *返回供货商列表
     * @return List
     */
    public List<Supplier> getSuppliers(){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from Supplier s");
    	List<Supplier> suppliers=q.list();
    	return suppliers;
    }
    
    /**
     * 删除一个供货商通过id
     * @param id
     */
    public void deleteById(int id){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	Query q=(Query)s.createQuery("from Supplier s where s.id="+id);
    	Supplier supplier=(Supplier)q.list().get(0);
    	s.delete(supplier);
    	s.flush();
    	s.close();
    }
    public void deleteOne(Supplier supplier){
    	SessionFactory sf=HibernateUtil.getSessionFactory();
    	Session s=sf.getCurrentSession();
    	s.beginTransaction();
    	s.delete(supplier);
    	s.flush();
    	s.close();
    }
    
}
