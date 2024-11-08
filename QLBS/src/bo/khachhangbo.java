package bo;

import java.util.ArrayList;

import bean.khachhang;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();
	ArrayList<khachhang> ds; // dai chi cua phan tu dau tien cua mang ( khi nao "add" thi moi "new")
	public ArrayList<khachhang> getKH() throws Exception{
		ds = khdao.getKH();
		return ds;
	}
	public ArrayList<khachhang> TimKiem(String tenkh) throws Exception{
		//tao ra 1 mang dong:tam
		 ArrayList<khachhang> tam= new ArrayList<khachhang>();
			for(khachhang kh: ds)
			  if(kh.getHoten().toLowerCase().contains(tenkh.toLowerCase()) 
			    || kh.getMakh().toLowerCase().contains(tenkh.toLowerCase()))
				  // contain la kiem tra chuoi co chua key hay khong
			     tam.add(kh);
			return tam;
	}
	
	 public int Them(String makh, String hoten, String diachi, String sdt, String tendn, String matkhau) throws Exception{
			   for(khachhang kh: ds)
				   if(kh.getMakh().equals(makh))
					   return 0;
			   //Them vao bo nho
			   ds.add(new khachhang(makh, hoten, diachi, sdt, tendn, matkhau));
			return khdao.Them(makh, hoten, diachi, sdt, tendn, matkhau);
		   }
		 
		 public int Sua(String makh, String hoten, String diachi, String sdt, String tendn, String matkhau) throws Exception{
		    	for(khachhang kh: ds)
		    		if(kh.getMakh().equals(makh)) {
		    			kh.setHoten(hoten);
		    			kh.setDiachi(diachi);
		    			kh.setSdt(sdt);
		    			kh.setTendn(tendn);
		    			kh.setMatkhau(matkhau);
		    			//Sua trong csdl
		    			return khdao.Sua(makh, hoten, diachi, sdt, tendn, matkhau);
		    		}
		    	return 0;
		    }
		
		 public int Xoa(String makh) throws Exception{
		    	for(khachhang kh: ds)
		    		if(kh.getMakh().equals(makh)) {
		    			ds.remove(kh);//Xoa trong bo nho
		    			return khdao.Xoa(makh);//Xoa trong csdl
		    		}
		    	return 0;
		    }
	
}
