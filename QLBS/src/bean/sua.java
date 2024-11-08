package bean;

public class sua {
	private String masua;
	private String tensua;
	private Double gia;
	private String ncc;
	
	public sua(String masua, String tensua, Double gia ,String ncc) {
		super();
		this.masua = masua;
		this.tensua = tensua;
		this.gia = gia;
		this.ncc=ncc;
	}

	public sua() {
	}

	public String getMasua() {
		return masua;
	}
	
	public void setMasua(String masua) {
		this.masua=masua;
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
	
	public String getNcc() {
		return ncc;
	}

	public void setNcc(String ncc) {
		this.ncc = ncc;
	}

	@Override
	public String toString() {
		return "sua [masua=" + masua + ", tensua=" + tensua + ", gia=" + gia + ", ncc=" + ncc + "]";
	}

	
	
}
