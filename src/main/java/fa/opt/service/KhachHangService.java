package fa.opt.service;

import java.util.List;

import fa.opt.entities.KhachHang;
import fa.opt.page.PageAble;

public interface KhachHangService {

	List<KhachHang> findAll();

	void saveOrUpdate(KhachHang khachHang);

	void delete(String maKH);

	KhachHang findById(String maKH);

	List<KhachHang> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<KhachHang> search(String searchKey);

}