package fa.opt.service;

import java.util.List;

import fa.opt.entities.SuDungMay;
import fa.opt.page.PageAble;

public interface SuDungMayService {

	void saveOrUpdate(SuDungMay suDungMay);

	List<SuDungMay> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<SuDungMay> search(String searchKey);

}