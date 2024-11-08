package bean;

public class khachhang {
	private String makh;
	private String hoten;
	private String diachi;
	private String sdt;
	private String tendn;
	private String matkhau;
	
	public khachhang(String makh, String hoten, String diachi, String sdt, String tendn, String matkhau) {
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.tendn = tendn;
		this.matkhau = matkhau;
	}

	public khachhang() {
		
	}

	public String getMakh() {
		return makh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String std) {
		this.sdt = sdt;
	}

	public String getTendn() {
		return tendn;
	}

	public void setTendn(String tendn) {
		this.tendn = tendn;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	@Override
	public String toString() {
		return "khachhang [makh=" + makh + ", hoten=" + hoten + ", diachi=" + diachi + ", sdt=" + sdt + ", tendn="
				+ tendn + ", matkhau=" + matkhau + "]";
	}
	
	
}
