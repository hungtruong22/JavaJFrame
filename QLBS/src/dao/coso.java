package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class coso {
	public static Connection cn;//bien tinh
 	public void KetNoi() {
 		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("OK da nap Driver");
			String st = "jdbc:sqlserver://DESKTOP-RQV86U4:1433;databaseName=quanlybansua;user=sa; password=truongminhhung";
			cn = DriverManager.getConnection(st);//ham tinh(static)
			System.out.println("Da ket noi den csdl quanlybansua"); 	 	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
 	}
 	public static void main(String[] args) {
		coso cs = new coso();
		cs.KetNoi();
	}
}
