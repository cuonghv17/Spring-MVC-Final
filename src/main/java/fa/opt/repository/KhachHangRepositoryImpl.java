package fa.opt.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.opt.entities.KhachHang;
import fa.opt.page.PageAble;

@Repository
public class KhachHangRepositoryImpl implements KhachHangRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<KhachHang> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> khachHangs = session.createQuery("SELECT p FROM KhachHang p", KhachHang.class).getResultList();
		return khachHangs;
	}

	@Override
	public void saveOrUpdate(KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(khachHang);
	}

	@Override
	public void delete(KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(khachHang);
	}

	@Override
	public KhachHang findById(String maKH) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(KhachHang.class, maKH);
	}

	@Override
	public List<KhachHang> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> khachHangs = session.createQuery("SELECT p FROM KhachHang p", KhachHang.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return khachHangs;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM KhachHang p", Long.class).getSingleResult();
	}

	@Override
	public List<KhachHang> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<KhachHang> createQuery = session.createQuery("SELECT p FROM KhachHang p where p.tenKH like :searchKey",
				KhachHang.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<KhachHang> khachHangs = createQuery.getResultList();
		return khachHangs;
	}

}
