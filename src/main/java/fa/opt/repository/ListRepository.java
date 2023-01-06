package fa.opt.repository;

import java.util.List;

import fa.opt.page.PageAble;

public interface ListRepository {

	List<Object[]> findWithPageAble(PageAble pageAble);

	long count();

	List<Object[]> search(String searchKey);

}