package fa.opt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.opt.page.PageAble;
import fa.opt.repository.ListRepository;

@Service
public class ListServiceImpl implements ListService  {
	
	@Autowired
	private ListRepository listRepositoryImpl;

	

	@Override
	@Transactional
	public List<Object[]> findWithPageAble(PageAble pageAble) {
		return listRepositoryImpl.findWithPageAble(pageAble);
	}
	
	
	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = listRepositoryImpl.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	@Override
	@Transactional
	public List<Object[]> search(String searchKey) {
		return listRepositoryImpl.search(searchKey);
	}

}
