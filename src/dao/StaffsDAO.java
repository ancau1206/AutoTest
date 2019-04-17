package dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Departs;
import pojo.Staffs;

@Repository
@Transactional(rollbackFor = Exception.class)

public class StaffsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Staffs> getListStaffs() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Staffs> list = session.createQuery("from Staffs").list();
		return list;
	}
	public boolean addStaffs(Staffs staffs) {
		Session session = sessionFactory.openSession();
		try {
			session.save(staffs);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		finally {
			session.close();
		}
	}
	public boolean updateStaffs(Staffs Staffs) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(Staffs);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} 
	}
	public boolean deleteStaffs(Staffs Staffs) {
		Session session=sessionFactory.openSession();
		org.hibernate.Transaction t= session.beginTransaction(); 
		try {
			session.delete(Staffs);
			t.commit();
			return true;
		} catch (HibernateException e) {
			t.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
	}
	public Staffs  getByid(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Staffs staf = (Staffs) session.get(Staffs.class, id);
		return staf;
	}
	@SuppressWarnings("unchecked")
	public List<Staffs>  getByCodeId(String codeId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Staffs S where S.codeId = :codeId";
		List<Staffs> list = session.createQuery(hql).setParameter("codeId", codeId).list();
		return list;
	}
	public void deleteAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			String hql = "delete from Staffs";
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