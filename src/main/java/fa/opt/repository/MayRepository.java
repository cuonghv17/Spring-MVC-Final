package fa.opt.repository;

import java.util.List;

import fa.opt.entities.May;
import fa.opt.page.PageAble;

public interface MayRepository {

	List<May> findAll();

	void saveOrUpdate(May may);

	void delete(May may);

	May findById(String maMay);

	List<May> findWithPageAble(PageAble pageAble);

	long count();

	List<May> search(String searchKey);

}