package fa.opt.repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.opt.entities.SuDungMay;
import fa.opt.page.PageAble;

@Repository
public class SuDungMayRepositoryImpl implements SuDungMayRepository {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void saveOrUpdate(SuDungMay suDungMay) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(suDungMay);
	}
	@Override
	public List<SuDungMay> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<SuDungMay> suDungMays = session.createQuery("SELECT p FROM SuDungMay p", SuDungMay.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return suDungMays;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM SuDungMay p", Long.class).getSingleResult();
	}
	@Override
	public List<SuDungMay> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<SuDungMay> createQuery = session.createQuery("SELECT p FROM SuDungMay p where p.khachHang.maKH like :searchKey",
				SuDungMay.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<SuDungMay> suDungMays = createQuery.getResultList();
		return suDungMays;
	}


}
