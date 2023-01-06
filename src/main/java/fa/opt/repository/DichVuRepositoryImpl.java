package fa.opt.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.opt.entities.DichVu;
import fa.opt.page.PageAble;


@Repository
public class DichVuRepositoryImpl implements DichVuRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DichVu> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<DichVu> dichVus = session.createQuery("SELECT p FROM DichVu p", DichVu.class).getResultList();
		return dichVus;
	}

	@Override
	public void saveOrUpdate(DichVu dichVu) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(dichVu);
	}

	@Override
	public void delete(DichVu dichVu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(dichVu);
	}

	@Override
	public DichVu findById(String maDV) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(DichVu.class, maDV);
	}

	@Override
	public List<DichVu> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<DichVu> dichVus = session.createQuery("SELECT p FROM DichVu p", DichVu.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return dichVus;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM DichVu p", Long.class).getSingleResult();
	}
	@Override
	public List<DichVu> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<DichVu> createQuery = session.createQuery("SELECT p FROM DichVu p where p.tenDV like :searchKey",
				DichVu.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<DichVu> dichVus = createQuery.getResultList();
		return dichVus;
	}
	
}
