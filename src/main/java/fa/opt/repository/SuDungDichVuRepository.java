package fa.opt.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import fa.opt.entities.SuDungDichVu;
import fa.opt.page.PageAble;

public interface SuDungDichVuRepository {

	void saveOrUpdate(SuDungDichVu suDungDichVu);

	List<SuDungDichVu> findWithPageAble(PageAble pageAble);

	long count();
	
	void delete(List<SuDungDichVu> suDungDichVu);

	List<SuDungDichVu> search(String searchKey);
	List<SuDungDichVu> findById(String maDV, String maKH , LocalDate ngaySuDung, LocalTime gioSuDung);

}