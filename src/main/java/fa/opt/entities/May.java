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


/**
 * entity may
 * @author cuonghv17
 * @since 19/08/1999
 * @version 1.0
 */

@Entity
public class May {
	@Id
	@GeneratedValue(generator = "my_generator")  
	@GenericGenerator(name = "my_generator", strategy = "fa.opt.mygenerator.MyGeneratorMay")
	@Column(columnDefinition = "varchar(5)")
	private String maMay;

	@Column(columnDefinition = "nvarchar(255)")

	private String viTri;

	@Column(columnDefinition = "nvarchar(255)")

	private String trangThai;

	@OneToMany(mappedBy = "may", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SuDungMay> suDungMay;

	public May() {
		super();
	}

	/**
	 * @param viTri
	 * @param trangThai
	 */
	public May(String viTri, String trangThai) {
		super();
		this.viTri = viTri;
		this.trangThai = trangThai;
	}

	

	public String getMaMay() {
		return maMay;
	}

	public void setMaMay(String maMay) {
		this.maMay = maMay;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<SuDungMay> getSuDungMay() {
		return suDungMay;
	}

	public void setSuDungMay(List<SuDungMay> suDungMay) {
		this.suDungMay = suDungMay;
	}

	@Override
	public String toString() {
		return "May [maMay=" + maMay + ", viTri=" + viTri + ", trangThai=" + trangThai 
				+ "]";
	}

}
