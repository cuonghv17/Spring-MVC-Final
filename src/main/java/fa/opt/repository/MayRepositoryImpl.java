package fa.opt.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.opt.entities.May;
import fa.opt.page.PageAble;


@Repository
public class MayRepositoryImpl implements MayRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<May> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<May> mays = session.createQuery("SELECT p FROM May p", May.class).getResultList();
		return mays;
	}

	@Override
	public void saveOrUpdate(May may) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(may);
	}

	@Override
	public void delete(May may) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(may);
	}

	@Override
	public May findById(String maMay) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(May.class, maMay);
	}

	@Override
	public List<May> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<May> mays = session.createQuery("SELECT p FROM May p", May.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return mays;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM May p", Long.class).getSingleResult();
	}
	@Override
	public List<May> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<May> createQuery = session.createQuery("SELECT p FROM May p where p.viTri like :searchKey",
				May.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<May> mays = createQuery.getResultList();
		return mays;
	}
	
}
