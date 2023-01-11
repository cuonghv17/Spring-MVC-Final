package fa.opt.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.opt.page.PageAble;


@Repository
public class ListRepositoryImpl implements ListRepository {

	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<Object[]> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		
		List<Object[]> results =  session.createQuery("SELECT k.maKH, k.tenKH , sm.may.maMay ,m.viTri , m.trangThai ,sm.ngayBatDauSuDung ,sm.gioBatDauSuDung,sm.thoiGianSuDung ,s.dichVu.maDV, s.ngaySuDung , s.gioSuDung ,s.soLuong, d.donGia ,(s.soLuong*d.donGia)as tt  FROM SuDungMay sm JOIN KhachHang k ON sm.khachHang.maKH = k.maKH JOIN May m ON sm.may.maMay = m.maMay JOIN SuDungDichVu s ON k.maKH = s.khachHang.maKH JOIN DichVu d on s.dichVu.maDV= d.maDV WHERE m.trangThai='ban' and s.ngaySuDung = sm.ngayBatDauSuDung  ",Object[].class)
			
		.setFirstResult(pageAble.getOffset())// Offset
		.setMaxResults(pageAble.getSize()) // limit
		.getResultList();
		return results;
	}



	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM SuDungMay sm JOIN KhachHang k ON sm.khachHang.maKH = k.maKH JOIN May m ON sm.may.maMay = m.maMay JOIN SuDungDichVu s ON k.maKH = s.khachHang.maKH JOIN DichVu d on s.dichVu.maDV= d.maDV WHERE m.trangThai='ban'and s.ngaySuDung = sm.ngayBatDauSuDung", Long.class).getSingleResult();
	}
	@Override
	public List<Object[]> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<Object[]> createQuery = session.createQuery("SELECT k.maKH, k.tenKH , sm.may.maMay ,m.viTri , m.trangThai ,sm.ngayBatDauSuDung ,sm.gioBatDauSuDung,sm.thoiGianSuDung ,s.dichVu.maDV, s.ngaySuDung , s.gioSuDung ,s.soLuong, d.donGia, (s.soLuong*d.donGia)as tt  FROM SuDungMay sm JOIN KhachHang k ON sm.khachHang.maKH = k.maKH JOIN May m ON sm.may.maMay = m.maMay JOIN SuDungDichVu s ON k.maKH = s.khachHang.maKH JOIN DichVu d on s.dichVu.maDV= d.maDV WHERE m.trangThai='ban' and s.ngaySuDung = sm.ngayBatDauSuDung AND k.tenKH like :searchKey",
				Object[].class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<Object[]> results = createQuery.getResultList();
		return results;
	}


	
}
