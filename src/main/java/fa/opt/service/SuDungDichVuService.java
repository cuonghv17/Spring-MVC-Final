package fa.opt.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fa.opt.entities.SuDungDichVu;
import fa.opt.page.PageAble;

public interface SuDungDichVuService {

	void saveOrUpdate(SuDungDichVu suDungDichVu);

	List<SuDungDichVu> findWithPageAble(PageAble pageAble);

	int totalPages(PageAble pageAble);
	
	void delete(String maDV, String maKH , LocalDate ngaySuDung, LocalTime gioSuDung);
	List<SuDungDichVu> search(String searchKey);
	List<SuDungDichVu> findById(String maDV, String maKH , LocalDate ngaySuDung, LocalTime gioSuDung);

}