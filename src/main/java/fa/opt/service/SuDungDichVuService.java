package fa.opt.service;

import java.util.List;

import fa.opt.entities.SuDungDichVu;
import fa.opt.page.PageAble;

public interface SuDungDichVuService {

	void saveOrUpdate(SuDungDichVu suDungDichVu);

	List<SuDungDichVu> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<SuDungDichVu> search(String searchKey);

}