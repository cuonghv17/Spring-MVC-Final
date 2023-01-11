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
 * entity SuDungMayID 
 * @author cuonghv17
 * @since 19/08/1999
 * @version 1.0
 */

@Entity
@IdClass(SuDungMayID.class)
public class SuDungMay {
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maKH",referencedColumnName = "maKH")
	private KhachHang khachHang;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maMay",referencedColumnName = "maMay")
	private May may;
	
	@Id
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayBatDauSuDung;

	@Id
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioBatDauSuDung;
	
	@Range(min = 1, max = 1000, message = "Nhập thoi gian su dung trong khoảng 1 - 1000 phut")
	private int thoiGianSuDung;

	public SuDungMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param khachHang
	 * @param may
	 * @param ngayBatDauSuDung
	 * @param gioBatDauSuDung
	 * @param thoiGianSuDung
	 */
	public SuDungMay(KhachHang khachHang, May may, LocalDate ngayBatDauSuDung, LocalTime gioBatDauSuDung,
			@Range(min = 1, max = 1000, message = "Nhập thoi gian su dung trong khoảng 1 - 1000 phut") int thoiGianSuDung) {
		super();
		this.khachHang = khachHang;
		this.may = may;
		this.ngayBatDauSuDung = ngayBatDauSuDung;
		this.gioBatDauSuDung = gioBatDauSuDung;
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	public LocalDate getNgayBatDauSuDung() {
		return ngayBatDauSuDung;
	}

	public void setNgayBatDauSuDung(LocalDate ngayBatDauSuDung) {
		this.ngayBatDauSuDung = ngayBatDauSuDung;
	}

	public LocalTime getGioBatDauSuDung() {
		return gioBatDauSuDung;
	}

	public void setGioBatDauSuDung(LocalTime gioBatDauSuDung) {
		this.gioBatDauSuDung = gioBatDauSuDung;
	}

	public int getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(int thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	@Override
	public String toString() {
		return "SuDungMay [khachHang=" + khachHang + ", may=" + may + ", ngayBatDauSuDung=" + ngayBatDauSuDung
				+ ", gioBatDauSuDung=" + gioBatDauSuDung + ", thoiGianSuDung=" + thoiGianSuDung + "]";
	}

}
