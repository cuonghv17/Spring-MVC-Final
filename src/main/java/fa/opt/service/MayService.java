package fa.opt.service;

import java.util.List;

import fa.opt.entities.May;
import fa.opt.page.PageAble;

public interface MayService {

	List<May> findAll();

	void saveOrUpdate(May may);

	void delete(String maMay);

	May findById(String maMay);

	List<May> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<May> search(String searchKey);

}