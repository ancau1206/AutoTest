package untils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
	private static SessionFactory factory = null;

	private MySessionFactory() {
	}
	
	public static SessionFactory getSessionFactory() {
		if(factory == null) {
			factory = new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
}
