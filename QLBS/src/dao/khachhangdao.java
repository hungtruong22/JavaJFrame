package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhang;

public class khachhangdao {
	public ArrayList<khachhang> getKH() throws Exception{
		//Khai bao 1 mang chua all khachhang
		 ArrayList<khachhang> ds = new ArrayList<khachhang>();
		 //b1: Tao cau lenh sql
		 String sql="select * from KHACHHANG";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 //b3. Thuc hien cau lenh sql
		 ResultSet rs= cmd.executeQuery();
		//b4: duyet qua rs
		 while(rs.next()) {
			 
				String makh=rs.getString("MAKH");
				String hoten=rs.getString("HOTEN");
				String diachi=rs.getString("DIACHI");
				String sdt=rs.getString("SDT");
				String tendn=rs.getString("TENDN");
				String matkhau=rs.getString("MATKHAU");
				
				khachhang kh= new khachhang(makh, hoten, diachi, sdt, tendn, matkhau);
				ds.add(kh);//Luu vao mang: ds
			}
			rs.close();
			return ds;
	}
	
	public int Them(String makh, String hoten, String diachi, String sdt, String tendn, String matkhau) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="insert into KHACHHANG(MAKH,HOTEN,DIACHI,SDT,TENDN,MATKHAU) values(?,?,?,?,?,?)";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 cmd.setString(1, makh);
		 cmd.setString(2, hoten);
		 cmd.setString(3,diachi);
		 cmd.setString(4, sdt);
		 cmd.setString(5, tendn);
		 cmd.setString(6, matkhau);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int Sua(String makh, String hoten, String diachi, String sdt, String tendn, String matkhau) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="update KHACHHANG set HOTEN=?,DIACHI=?,SDT=?,TENDN=?,MATKHAU=? where MAKH=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 cmd.setString(1, hoten);
		 cmd.setString(2, diachi);
		 cmd.setString(3, sdt);
		 cmd.setString(4, tendn);
		 cmd.setString(5, matkhau);
		 cmd.setString(6, makh);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	
	public int Xoa(String makh) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="delete from KHACHHANG where MAKH=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 cmd.setString(1, makh);
		//b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
}
