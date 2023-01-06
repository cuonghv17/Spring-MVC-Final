package fa.opt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.opt.entities.May;
import fa.opt.page.PageAble;
import fa.opt.repository.MayRepository;

@Service
public class MayServiceImpl implements MayService  {
	
	@Autowired
	private MayRepository mayRepositoryImpl;

	@Override
	@Transactional
	public List<May> findAll() {
		return mayRepositoryImpl.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(May may) {
		mayRepositoryImpl.saveOrUpdate(may);
	}

	@Override
	@Transactional
	public void delete(String maMay) {
		May may = findById(maMay);
		if (may != null) {
			mayRepositoryImpl.delete(may);
		}
	}

	@Override
	@Transactional
	public May findById(String maMay) {
		return mayRepositoryImpl.findById(maMay);
	}

	@Override
	@Transactional
	public List<May> findWithPageAble(PageAble pageAble) {
		return mayRepositoryImpl.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = mayRepositoryImpl.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	@Override
	@Transactional
	public List<May> search(String searchKey) {
		return mayRepositoryImpl.search(searchKey);
	}
}
