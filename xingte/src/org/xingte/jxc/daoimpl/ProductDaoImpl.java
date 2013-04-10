package org.xingte.jxc.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.model.Product;
import org.xingte.jxc.util.HibernateUtil;
public class ProductDaoImpl {
     private Product product;
     public Product getProduct(){
    	 return this.product;
     }
     public void setProduct(Product product){
    	 this.product=product;
     }
     public void addProduct(Product product){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 s.save(product);
    	 s.flush();
    	 s.getTransaction().commit();
    	 s.close();
     }
     public Product getById(int id){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Product p where id="+id);
    	 Product product=(Product)q.list().get(0);
    	 return product;
     }
     public List<Product> getProducts(){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Product p");
    	 List<Product> products=q.list();
    	 return products;
     }
     
     public List<Product> getProducts(int supplierid,int catalogid){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Product p where p.supplierid="+
    			 supplierid+"and p.catalogid+"+catalogid);
    	 List<Product> products=q.list();
    	 return products;
     }
     
     public List<Product> getProductsByCatalogid(int catalogid){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Product p where p.catalogid="+
    			 catalogid);
    	 List<Product> products=q.list();
    	 return products;
     }
     
     public List<Product> getProducts(int supplierid){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Product p where p.supplierid="+
    			 supplierid);
    	 List<Product> products=q.list();
    	 return products;
     }
     
     public void deleteById(int id){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Product p where id="+id);
    	 Product product=(Product)q.list().get(0);
    	 s.delete(product);
    	 s.flush();
    	 s.close();
     }
     public void deleteOne(Product product){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	
    	 s.delete(product);
    	 s.flush();
    	 s.close();
     }
}
