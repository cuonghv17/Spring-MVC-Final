package fa.opt.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * entity SuDungDichVu
 * @author cuonghv17
 * @since 19/08/1999
 * @version 1.0
 */

@Entity
@IdClass(SuDungDichVuID.class)
public class SuDungDichVu {
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maKH", referencedColumnName = "maKH")
	private KhachHang khachHang;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maDV", referencedColumnName = "maDV")
	private DichVu dichVu;
	
	@Id
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaySuDung;

	@Id
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioSuDung;
	
	@Range(min = 1, max = 1000, message = "Nhập soluong trong khoảng 1 - 1000")
	private int soLuong;

	/**
	 * @param khachHang
	 * @param dichVu
	 * @param ngaySuDung
	 * @param gioSuDung
	 * @param soLuong
	 */
	public SuDungDichVu(KhachHang khachHang, DichVu dichVu, LocalDate ngaySuDung, LocalTime gioSuDung, int soLuong) {
		super();
		this.khachHang = khachHang;
		this.dichVu = dichVu;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
	}

	public SuDungDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public LocalTime getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(LocalTime gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "SuDungDichVu [khachHang=" + khachHang + ", dichVu=" + dichVu + ", ngaySuDung=" + ngaySuDung
				+ ", gioSuDung=" + gioSuDung + ", soLuong=" + soLuong + "]";
	}
	
	
	
}
