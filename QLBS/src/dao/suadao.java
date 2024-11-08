package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.sua;

public class suadao {
	public ArrayList<sua> getSua() throws Exception{
		//Khai bao 1 mang chua all sua
		 ArrayList<sua> ds = new ArrayList<sua>();
		 //b1: Tao cau lenh sql
		 String sql="select * from SUA";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 //b3. Thuc hien cau lenh sql
		 ResultSet rs= cmd.executeQuery();
		//b4: duyet qua rs
		 while(rs.next()) {
				
				String masua=rs.getString("MASUA");
				String tensua=rs.getString("TENSUA");
				Double gia=rs.getDouble("GIA");
				String ncc=rs.getString("NCC");
				sua s= new sua(masua, tensua, gia , ncc);
				ds.add(s);//Luu vao mang: ds
			}
			rs.close();
			return ds;
	}
	
	public int Them(String masua, String tensua, Double gia ,String ncc) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="insert into SUA(MASUA,TENSUA,GIA,NCC) values(?,?,?,?)";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 cmd.setString(1, masua);
		 cmd.setString(2, tensua);
		 cmd.setDouble(3,gia);
		 cmd.setString(4, ncc);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	public int Sua(String masua, String tensua, Double gia ,String ncc) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="update SUA set TENSUA=?,GIA=?,NCC=? where MASUA=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 cmd.setString(1, tensua);
		 cmd.setDouble(2, gia);
		 cmd.setString(3, ncc);
		 cmd.setString(4, masua);
		 //b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	
	public int Xoa(String masua) throws Exception{
		//b1: Tao cau lenh sql
		 String sql="delete from SUA where MASUA=?";
		//b2: Tao ra prepareStatement
		 PreparedStatement cmd= coso.cn.prepareStatement(sql);
		 cmd.setString(1, masua);
		//b3. Thuc hien cau lenh sql
		return cmd.executeUpdate();
	}
	
	public static void main(String[] args) {
		try {
			suadao sdao= new suadao();
			 for(sua s: sdao.getSua())
				System.out.println( s.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
