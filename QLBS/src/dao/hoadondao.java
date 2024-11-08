package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.hoadon;

public class hoadondao {
	public ArrayList<hoadon> getHD() throws Exception{
		//Khai bao 1 mang chua all thong tin hoa don
		 ArrayList<hoadon> ds = new ArrayList<hoadon>();
		 //b1: Tao cau lenh sql
		 String sql="select * from HOADON";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 //b3. Thuc hien cau lenh sql
		 ResultSet rs= cmd.executeQuery();
		//b4: duyet qua rs
		 while(rs.next()) {
				String mahoadon=rs.getString("MAHOADON");
				String masua=rs.getString("MASUA");
				String makh=rs.getString("MAKH");
				String tensua=rs.getString("TENSUA");
				Double gia=rs.getDouble("GIA");
				int soluong=rs.getInt("SOLUONG");
				Double thanhtien=rs.getDouble("THANHTIEN");
				Date ngaymua=rs.getDate("NGAYMUA");
				hoadon hd = new hoadon(mahoadon, masua, makh, tensua, gia, soluong, thanhtien, ngaymua);
				ds.add(hd);//Luu vao mang: ds
			}
			rs.close();
			return ds;
	}
	public int HienThiHoaDon(String mahd, String masua,String makh, String tensua, Double gia, int soluong,
			Double thanhtien, Date ngay) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="insert into HOADON(MAHOADON,MASUA,MAKH,TENSUA,GIA,SOLUONG,THANHTIEN,NGAYMUA) values(?,?,?,?,?,?,?,?)";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 cmd.setString(1, mahd);	
		 cmd.setString(2, masua);
		 cmd.setString(3, makh);
		 cmd.setString(4, tensua);
		 cmd.setDouble(5, gia);
		 cmd.setInt(6, soluong);
		 cmd.setDouble(7, thanhtien);
		 cmd.setDate(8, new java.sql.Date(ngay.getTime()));
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
}
