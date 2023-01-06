package fa.opt.service;

import java.util.List;

import fa.opt.page.PageAble;

public interface ListService {

	List<Object[]> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);

	List<Object[]> search(String searchKey);

}