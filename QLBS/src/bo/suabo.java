package bo;

import java.util.ArrayList;
import java.sql.Date;
import bean.sua;
import dao.suadao;

public class suabo {
	suadao sdao = new suadao();
	ArrayList<sua> ds; // dai chi cua phan tu dau tien cua mang ( khi nao "add" thi moi "new")
	public ArrayList<sua> getSua() throws Exception{
		ds = sdao.getSua();
		return ds;
	}
	public ArrayList<sua> TimKiem(String tensua) throws Exception{
		//tao ra 1 mang dong:tam
		 ArrayList<sua> tam= new ArrayList<sua>();
			for(sua s: ds)
			  if(s.getTensua().toLowerCase().contains(tensua.toLowerCase()) 
			    || s.getMasua().toLowerCase().contains(tensua.toLowerCase()))
				  // contain la kiem tra chuoi co chua key hay khong
			     tam.add(s);
			return tam;
	}
	
	 public int Them(String masua, String tensua, Double gia ,String ncc) throws Exception{
			   for(sua s: ds)
				   if(s.getMasua().equals(masua))
					   return 0;
			   //Them vao bo nho
			   ds.add(new sua(masua , tensua , gia , ncc));
			return sdao.Them(masua , tensua , gia , ncc);
		   }
		 
		 public int Sua(String masua, String tensua, Double gia ,String ncc) throws Exception{
		    	for(sua s: ds)
		    		if(s.getMasua().equals(masua)) {
		    			s.setTensua(tensua);
		    			s.setGia(gia);
		    			s.setNcc(ncc);
		    			//Sua trong csdl
		    			return sdao.Sua(masua , tensua , gia , ncc);
		    		}
		    	return 0;
		    }
		
		 public int Xoa(String masua) throws Exception{
		    	for(sua s: ds)
		    		if(s.getMasua().equals(masua)) {
		    			ds.remove(s);//Xoa trong bo nho
		    			return sdao.Xoa(masua);//Xoa trong csdl
		    		}
		    	return 0;
		    }
}
