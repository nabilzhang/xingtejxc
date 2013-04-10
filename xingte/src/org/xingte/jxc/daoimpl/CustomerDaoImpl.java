package org.xingte.jxc.daoimpl;
import java.util.List;
import org.xingte.jxc.model.Customer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.xingte.jxc.util.HibernateUtil;
public class CustomerDaoImpl {
     private Customer customer;
     public Customer getCustomer()
     {
	    return this.customer;
     }
     public void setCustomer(Customer customer){
        this.customer=customer;
     }
     public void addCustomer(Customer c){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 s.save(c);
    	 s.getTransaction().commit();
     }
     public Customer getOneById(int id){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Customer c where c.id="+id);
    	 Customer customer=(Customer)q.list().get(0);
    	 return customer;
     }
     public List<Customer> getCustomers(){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Customer c");
    	 List<Customer> customers=q.list();
    	 return customers;
     }
     public void deleteById(int id){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 Query q=(Query)s.createQuery("from Customer c where c.id="+id);
    	 Customer c=(Customer)q.list().get(0);
    	 s.delete(c);
    	 s.flush();
    	 s.close();
     }
     public void deleteOne(Customer c){
    	 SessionFactory sf=HibernateUtil.getSessionFactory();
    	 Session s=sf.getCurrentSession();
    	 s.beginTransaction();
    	 s.delete(c);
    	 s.flush();
    	 s.close();
     }
}

