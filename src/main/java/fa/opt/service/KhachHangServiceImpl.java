package fa.opt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.opt.entities.KhachHang;
import fa.opt.page.PageAble;
import fa.opt.repository.KhachHangRepository;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	
	@Autowired
	private KhachHangRepository KhachHangRepositoryImpl;

	@Override
	@Transactional
	public List<KhachHang> findAll() {
		return KhachHangRepositoryImpl.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(KhachHang khachHang) {
		KhachHangRepositoryImpl.saveOrUpdate(khachHang);
	}

	@Override
	@Transactional
	public void delete(String maKH) {
		KhachHang khachHang = findById(maKH);
		if (khachHang != null) {
			KhachHangRepositoryImpl.delete(khachHang);
		}
	}

	@Override
	@Transactional
	public KhachHang findById(String maKH) {
		return KhachHangRepositoryImpl.findById(maKH);
	}

	@Override
	@Transactional
	public List<KhachHang> findWithPageAble(PageAble pageAble) {
		return KhachHangRepositoryImpl.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = KhachHangRepositoryImpl.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	@Override
	@Transactional
	public List<KhachHang> search(String searchKey) {
		return KhachHangRepositoryImpl.search(searchKey);
	}
}
