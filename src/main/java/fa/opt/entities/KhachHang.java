package fa.opt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class KhachHang {
	@Id
	@GeneratedValue(generator = "my_generator")  
	@GenericGenerator(name = "my_generator", strategy = "fa.opt.mygenerator.MyGeneratorKhachHang")
	@Column(columnDefinition = "varchar(5)")
	private String maKH;
	
	@Column(columnDefinition = "varchar(50)")
	private String tenKH;
	
	@Column(columnDefinition = "varchar(100)")
	private String diaChi;
	
	@Column(columnDefinition = "varchar(16)")
	private String soDienThoai;
	
	@Column(columnDefinition = "varchar(80)")
	private String diaChiEmail;
	
	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SuDungDichVu> suDungDichVu;
	
	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SuDungMay> suDungMay;

	public KhachHang(String tenKH, String diaChi, String soDienThoai, String diaChiEmail) {
		super();
		
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.diaChiEmail = diaChiEmail;
		
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiEmail() {
		return diaChiEmail;
	}

	public void setDiaChiEmail(String diaChiEmail) {
		this.diaChiEmail = diaChiEmail;
	}

	public List<SuDungDichVu> getSuDungDichVu() {
		return suDungDichVu;
	}

	public void setSuDungDichVu(List<SuDungDichVu> suDungDichVu) {
		this.suDungDichVu = suDungDichVu;
	}

	public List<SuDungMay> getSuDungMay() {
		return suDungMay;
	}

	public void setSuDungMay(List<SuDungMay> suDungMay) {
		this.suDungMay = suDungMay;
	}

	@Override
	public String toString() {
		return "khachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", diaChiEmail=" + diaChiEmail + "]";
	}
	

}
