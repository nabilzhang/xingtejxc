package org.xingte.jxc.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xingte.jxc.model.Post;
import org.xingte.jxc.util.HibernateUtil;

public class PostDaoImpl {
	private Post post;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public void addOne(Post post){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.save(post);
		s.getTransaction().commit();
	}
	
	public void deleteOne(Post post){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.delete(post);
		s.getTransaction().commit();
	}
	
	public Post getOneById(int id){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Post p where p.id="+id);
		Post post=(Post)q.list().get(0);
		return post;
	}
	
	public List<Post> getAll(){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Query q=(Query)s.createQuery("from Post p");
		List<Post> posts=q.list();
		return posts;
	}

}
