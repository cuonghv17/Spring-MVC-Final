package fa.opt.repository;

import java.util.List;

import fa.opt.entities.SuDungMay;
import fa.opt.page.PageAble;

public interface SuDungMayRepository {

	void saveOrUpdate(SuDungMay suDungMay);

	List<SuDungMay> findWithPageAble(PageAble pageAble);

	long count();

	List<SuDungMay> search(String searchKey);

}