package dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Users;
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAO {
	@Autowired
	private SessionFactory factory;
	@SuppressWarnings("unchecked")
	public boolean checkLogin(String username, String pass) {
		Session ses= factory.getCurrentSession();
		List<Users> listuser = null;
		String sql = "FROM Users WHERE Username='"+ username+ "' AND Password = '" + pass +"'";
		Query qe = ses.createQuery(sql);
		listuser = qe.list();
		if(listuser.size()>0) {
			return true;
		} else {
			return false;
		}
		
	}
}
