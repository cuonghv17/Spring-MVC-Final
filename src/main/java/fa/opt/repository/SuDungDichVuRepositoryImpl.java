package fa.opt.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.opt.entities.SuDungDichVu;
import fa.opt.page.PageAble;

@Repository
public class SuDungDichVuRepositoryImpl implements SuDungDichVuRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(SuDungDichVu suDungDichVu) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(suDungDichVu);
	}

	@Override
	public List<SuDungDichVu> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<SuDungDichVu> suDungDichVus = session.createQuery("SELECT p FROM SuDungDichVu p", SuDungDichVu.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return suDungDichVus;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM SuDungDichVu p", Long.class).getSingleResult();
	}
	@Override
	public List<SuDungDichVu> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<SuDungDichVu> createQuery = session.createQuery("SELECT p FROM SuDungDichVu p where p.khachHang.maKH like :searchKey",
				SuDungDichVu.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<SuDungDichVu> suDungDichVus = createQuery.getResultList();
		return suDungDichVus;
	}
	@Override
	public List<SuDungDichVu> findById(String maDV, String maKH , LocalDate ngaySuDung, LocalTime gioSuDung) {
		Session session = sessionFactory.getCurrentSession();
		Query<SuDungDichVu> createQuery = session.createQuery("SELECT p FROM SuDungDichVu p where p.khachHang.maKH = " +maKH +" and p.dichVu.maDV = "+ maDV +" AND p.ngaySuDung = "+ ngaySuDung +" AND p.gioSuDung = "+ gioSuDung,
				SuDungDichVu.class);
		
		List<SuDungDichVu> suDungDichVu = createQuery.getResultList();
		return suDungDichVu;
	
	}

	@Override
	public void delete(List<SuDungDichVu> suDungDichVu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(suDungDichVu);
	}

}
