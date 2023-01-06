package fa.opt.repository;

import java.util.List;

import fa.opt.entities.KhachHang;
import fa.opt.page.PageAble;

public interface KhachHangRepository {

	List<KhachHang> findAll();

	void saveOrUpdate(KhachHang khachHang);

	void delete(KhachHang khachHang);

	KhachHang findById(String maKH);

	List<KhachHang> findWithPageAble(PageAble pageAble);

	long count();

	List<KhachHang> search(String searchKey);

}