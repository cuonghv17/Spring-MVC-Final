package fa.opt.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.opt.entities.SuDungDichVu;
import fa.opt.page.PageAble;
import fa.opt.repository.SuDungDichVuRepository;

@Service
public class SuDungDichVuServiceImpl implements SuDungDichVuService  {
	
	@Autowired
	private SuDungDichVuRepository suDungDichVuRepositoryImpl;

	

	@Override
	@Transactional
	public void saveOrUpdate(SuDungDichVu suDungDichVu) {
		suDungDichVuRepositoryImpl.saveOrUpdate(suDungDichVu);
	}

	
	@Override
	@Transactional
	public List<SuDungDichVu> findWithPageAble(PageAble pageAble) {
		return suDungDichVuRepositoryImpl.findWithPageAble(pageAble);
	}
	
	@Override
	@Transactional
	public void delete(String maDV, String maKH , LocalDate ngaySuDung, LocalTime gioSuDung){
		List<SuDungDichVu> suDungDichVu = findById(maDV,maKH,ngaySuDung,gioSuDung);
		if (suDungDichVu != null) {
			suDungDichVuRepositoryImpl.delete(suDungDichVu);
		}
	}
	@Override
	@Transactional
	public List<SuDungDichVu> findById(String maDV, String maKH , LocalDate ngaySuDung, LocalTime gioSuDung) {
		return suDungDichVuRepositoryImpl.findById(maDV, maKH, ngaySuDung, gioSuDung);
	}
	
	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = suDungDichVuRepositoryImpl.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}
	@Override
	@Transactional
	public List<SuDungDichVu> search(String searchKey) {
		return suDungDichVuRepositoryImpl.search(searchKey);
	}

	
}
