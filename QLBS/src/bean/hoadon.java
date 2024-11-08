package bean;

import java.util.Date;

public class hoadon {
	private String mahd;
	private String masua;
	private String makh;
	private String tensua;
	private Double gia;
	private Integer soluong;
	private Double thanhtien;
	private Date ngay;
	public hoadon() {

	}
	public hoadon(String mahd, String masua,String makh, String tensua, Double gia, Integer soluong,
		Double thanhtien, Date ngay) {
		this.mahd = mahd;
		this.masua = masua;
		this.makh = makh;
		this.tensua = tensua;
		this.gia = gia;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
		this.ngay = ngay;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMasua() {
		return masua;
	}
	public void setMasua(String masua) {
		this.masua = masua;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTensua() {
		return tensua;
	}
	public void setTensua(String tensua) {
		this.tensua = tensua;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	public Integer getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Double thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	@Override
	public String toString() {
		return "hoadon [mahd=" + mahd + ", masua=" + masua + ", makh=" + makh + ", tensua=" + tensua + ", gia=" + gia
				+ ", soluong=" + soluong + ", thanhtien=" + thanhtien + ", ngay=" + ngay + "]";
	}
}
