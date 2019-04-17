package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import pojo.Departs;
import pojo.Staffs;
import sun.print.PSPrinterJob.EPSPrinter;

@Repository
@Transactional(rollbackFor = Exception.class)

public class DepartsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Departs> getListDeparts(int First, int End) {
		Session session = sessionFactory.getCurrentSession();
		List<Departs> list = session.createQuery("from Departs").setFirstResult(First).setMaxResults(End).list();
		return list;
	}

	public Departs getDeparts(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Departs) session.get(Departs.class, id);
	}
	
	public boolean addDepart(Departs departs) {
		Session session = sessionFactory.openSession();
		try {
			session.save(departs);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	public boolean updateDepart(Departs departs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(departs);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} 
	}
	public boolean deleteDepart(Departs departs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(departs);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} 
	}
	@SuppressWarnings("unchecked")
	public List<Departs>  getByCodeId(String codeId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Departs S where S.codeId = :codeId";
		List<Departs> list = session.createQuery(hql).setParameter("codeId", codeId).list();
		return list;
	}
	public void deleteAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			String hql = "delete from Departs";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
	}
	

}