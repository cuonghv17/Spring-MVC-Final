package fa.opt.service;

import java.util.List;

import fa.opt.entities.DichVu;
import fa.opt.page.PageAble;

public interface DichVuService {

	List<DichVu> findAll();

	void saveOrUpdate(DichVu dichVu);

	void delete(String maDV);

	DichVu findById(String maDV);

	List<DichVu> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<DichVu> search(String searchKey);

}