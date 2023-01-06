package fa.opt.repository;

import java.util.List;

import fa.opt.entities.SuDungDichVu;
import fa.opt.page.PageAble;

public interface SuDungDichVuRepository {

	void saveOrUpdate(SuDungDichVu suDungDichVu);

	List<SuDungDichVu> findWithPageAble(PageAble pageAble);

	long count();

	List<SuDungDichVu> search(String searchKey);

}