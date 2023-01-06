package fa.opt.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.opt.entities.SuDungMay;
import fa.opt.page.PageAble;
import fa.opt.repository.SuDungMayRepository;

@Service
public class SuDungMayServiceImpl implements SuDungMayService {
	
	@Autowired
	private SuDungMayRepository suDungMayRepositoryImpl;



	@Override
	@Transactional
	public void saveOrUpdate(SuDungMay suDungMay) {
		suDungMayRepositoryImpl.saveOrUpdate(suDungMay);
	}
	@Override
	@Transactional
	public List<SuDungMay> findWithPageAble(PageAble pageAble) {
		return suDungMayRepositoryImpl.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = suDungMayRepositoryImpl.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	@Override
	@Transactional
	public List<SuDungMay> search(String searchKey) {
		return suDungMayRepositoryImpl.search(searchKey);
	}

	


	
}
