package fa.opt.repository;

import java.util.List;

import fa.opt.entities.DichVu;
import fa.opt.page.PageAble;

/**
 * @author hocuong
 *
 */
public interface DichVuRepository {

	
	
	List<DichVu> findAll();

	void saveOrUpdate(DichVu dichVu);

	
	void delete(DichVu dichVu);

	DichVu findById(String maDV);

	List<DichVu> findWithPageAble(PageAble pageAble);

	long count();

	List<DichVu> search(String searchKey);

}