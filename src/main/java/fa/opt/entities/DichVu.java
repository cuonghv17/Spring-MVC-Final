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
public class DichVu {
	@Id
	@GeneratedValue(generator = "my_generator")  
	@GenericGenerator(name = "my_generator", strategy = "fa.opt.mygenerator.MyGeneratorDichVu")
	@Column(columnDefinition = "varchar(5)")
	private String maDV;
	
	@Column(columnDefinition = "varchar(50)")

	private String tenDV;

	@Column(columnDefinition = "varchar(50)")

	private String donViTinh;

	private float donGia;

	@OneToMany(mappedBy = "dichVu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SuDungDichVu> suDungDichVu;

	public DichVu() {
		super();

	}

	public DichVu( String tenDV, String donViTinh, float donGia) {
		super();
		
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
	}



	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public List<SuDungDichVu> getSuDungDichVu() {
		return suDungDichVu;
	}

	public void setSuDungDichVu(List<SuDungDichVu> suDungDichVu) {
		this.suDungDichVu = suDungDichVu;
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donViTinh=" + donViTinh + ", donGia=" + donGia
				+ ", suDungDichVu=" + suDungDichVu + "]";
	}

}
