package bo;

import java.util.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.hoadon;
import bean.khachhang;
import bean.hoadon;
import dao.coso;
import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();
	ArrayList<hoadon> ds; // dai chi cua phan tu dau tien cua mang ( khi nao "add" thi moi "new")
	public ArrayList<hoadon> getHD() throws Exception{
		ds = hddao.getHD();
		return ds;
	}
	public int HienThiHoaDon(String mahd, String mahoadon,String makh, String tenhoadon, Double gia, int soluong,
			Double thanhtien, Date ngay) throws Exception{
		   for(hoadon hd: ds)
			   if(hd.getMahd().equals(mahd))
				   return 0;
		   //Them vao bo nho
		   ds.add(new hoadon(mahd, mahoadon, makh, tenhoadon, gia, soluong, thanhtien, ngay));
		return hddao.HienThiHoaDon(mahd, mahoadon, makh, tenhoadon, gia, soluong, thanhtien, ngay);
	   }
}
