package org.xingte.jxc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class HibernateUtil {
	private static SessionFactory sf;
	static{
		sf=new AnnotationConfiguration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
