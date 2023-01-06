package fa.opt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.opt.entities.DichVu;
import fa.opt.page.PageAble;
import fa.opt.repository.DichVuRepository;

@Service
public class DichVuServiceImpl implements DichVuService {
	
	@Autowired
	private DichVuRepository dichVuRepositoryImpl;

	@Override
	@Transactional
	public List<DichVu> findAll() {
		return dichVuRepositoryImpl.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(DichVu dichVu) {
		dichVuRepositoryImpl.saveOrUpdate(dichVu);
	}

	@Override
	@Transactional
	public void delete(String maDV) {
		DichVu dichVu = findById(maDV);
		if (dichVu != null) {
			dichVuRepositoryImpl.delete(dichVu);
		}
	}

	@Override
	@Transactional
	public DichVu findById(String maDV) {
		return dichVuRepositoryImpl.findById(maDV);
	}

	@Override
	@Transactional
	public List<DichVu> findWithPageAble(PageAble pageAble) {
		return dichVuRepositoryImpl.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = dichVuRepositoryImpl.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	@Override
	@Transactional
	public List<DichVu> search(String searchKey) {
		return dichVuRepositoryImpl.search(searchKey);
	}
}
