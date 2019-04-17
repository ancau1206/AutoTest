package dao;

import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Records;
import pojo.Staffs;

@Repository
@Transactional(rollbackFor = Exception.class)
public class RecordsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	StaffsDAO staffsDao;


	public List<Object[]> getTop10Records() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "SELECT r.staffs.name, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end), (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end)), r.staffs.departs.name, r.staffs.photo "
				+ " FROM Records r " + "GROUP BY r.staffs.name,r.staffs.departs.name,r.staffs.photo "
				+ "ORDER BY (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end)) desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		return list;
	}

	public List<Records> getListRecords() {

		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT r.staffs.codeId, r.staffs.name, SUM(case when r.type=1 then 1 else 0 end), SUM(case when r.type=0 then 1 else 0 end), (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end)), r.staffs.departs.name, r.staffs.id "
				+ " FROM Records r " + "GROUP BY r.staffs.codeId,r.staffs.name,r.staffs.departs.name,r.staffs.id";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Records> list = query.list();
		return list;
	}

	public List<Object[]> getListRecordsDeparts() {

		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT r.staffs.departs.name, (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type=0 then 1 else 0 end))"
				+ " FROM Records r " + "GROUP BY r.staffs.departs.name";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		return list;
	}
	public boolean deleteRecord(Records records) {
		Session session = this.sessionFactory.openSession();
		try {
			session.delete(records);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean insertRecord(long id, String reason, int type) {
		Staffs staffs= staffsDao.getByid(id);
		Session session = this.sessionFactory.openSession();
		try {
			session.save(new Records(staffs, type, reason, new java.sql.Date(1)));
			return true;
		} catch (Exception e) {
			System.out.println("Loi: " + e);
			return false;
		} finally {
			session.close();
		}
	}

}
