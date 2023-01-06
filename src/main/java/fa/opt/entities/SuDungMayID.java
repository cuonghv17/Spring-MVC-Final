package fa.opt.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;


public class SuDungMayID implements Serializable {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maKH",referencedColumnName = "maKH")
	private KhachHang khachHang;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maMay",referencedColumnName = "maMay")
	private May may;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayBatDauSuDung;

	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioBatDauSuDung;


}
