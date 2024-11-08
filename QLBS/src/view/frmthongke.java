package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.hoadon;
import bean.khachhang;
import bean.sua;
import bo.hoadonbo;
import bo.khachhangbo;
import bo.suabo;
import dao.coso;

import java.awt.List;
import javax.swing.JScrollPane;
import java.awt.Label;
import java.awt.Choice;
import java.awt.TextField;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class frmthongke extends JFrame {

	private JPanel contentPane;
	hoadonbo hdbo = new hoadonbo();
	List list = new List();
	TextField txttshd = new TextField();
	khachhangbo khbo = new khachhangbo();
	suabo sbo = new suabo();
	TextField txttongtien = new TextField();
	TextField txtbnn = new TextField();
	TextField txtslbnn = new TextField();
	TextField txttsls = new TextField();
	TextField txtloaisua = new TextField();
	TextField txtbin = new TextField();
	TextField txtsli = new TextField();
	TextField txtslbin = new TextField();
	TextField txtsln = new TextField();
	ArrayList<hoadon> ds;
	ArrayList<sua> ds1;
	ArrayList<khachhang> ds2;
	int kt=0;// de kiem tra xem da nap di lieu vao list1 hay chua
	public hoadon hd;

	/**
	 * Launch the application.
	 */
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmthongke frame = new frmthongke();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmthongke() {
		setBackground(new Color(255, 255, 255));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				new coso().KetNoi();// goi ham KetNoi() cua class CoSo trong dao
				try {
					setTitle("Thong Ke: "+ frmdangnhap.dangnhap);
					ds = hdbo.getHD();
					ds1=sbo.getSua();
					ds2=khbo.getKH();
				} catch (Exception e2) {
	  				// TODO: handle exception
					JOptionPane.showMessageDialog(null,"loi");
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("MaSua");
		label.setBounds(0, 200, 59, 21);
		contentPane.add(label);
		list.setBackground(Color.WHITE);
		
		
		list.setBounds(355, 10, 233, 264);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Thong Ke");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int demtonghoadon = 0;
				int demhang = 0;
				Double sum = 0.0;
			    BigDecimal tempBig = null;
				for(hoadon h : ds) {
					demtonghoadon++;
					sum += h.getThanhtien();
					tempBig = new BigDecimal(Double.toString(sum));
					//System.out.println(sum);
				}
				int max = 0;
				int min = 1000;
				int soluong = 0;
				String tenhanglon = null;
				String tenhangbe = null;
				String masualon = null;
				String masuabe = null;
				ArrayList<hoadon> tam = new ArrayList<hoadon>();
				for(sua s : ds1) {	
					for(hoadon d : ds) {
						if(d.getMasua().equals(s.getMasua())) {
							soluong+=d.getSoluong();
						}
					} 	
					if(soluong >= max) {
						   max=soluong;
						   tenhanglon = s.getTensua();
						   masualon=	 s.getMasua();
					   }
					if(soluong <= min){
						   min=soluong;
						   tenhangbe=s.getTensua();
						   masuabe=s.getMasua();
					   }
					demhang++;
					soluong = 0;
				}
				int soluongtong = 0;
				for(sua s : ds1) {	
					for(hoadon d : ds) {
						if(d.getMasua().equals(s.getMasua())) {
							soluongtong+=d.getSoluong();
						}
					} 
				}

				//hien thi len textfield
				txtloaisua.setText(String.valueOf(demhang));
				txttshd.setText(String.valueOf(demtonghoadon));
				txttsls.setText(String.valueOf(soluongtong));
				txttongtien.setText(String.valueOf(tempBig));
				txtbnn.setText(String.valueOf(tenhanglon));
				txtsln.setText(String.valueOf(masualon));
				txtslbnn.setText(String.valueOf(max));				
				txtbin.setText(String.valueOf(tenhangbe));	
				txtsli.setText(String.valueOf(masuabe));
				txtslbin.setText(String.valueOf(min));
				
				
				//hien thi vao list
				list.add("-----------------THONGKESOLIEU-------------------");
				list.add("So loai Sua hien co : " + " " + String.valueOf(demhang));
				list.add("Tong so hoa don: " + " " + String.valueOf(demtonghoadon));
				list.add("Tong so luong Sua da ban : " + " " + String.valueOf(soluongtong));	
				list.add("Tong tien thu duoc : " + " " + String.valueOf(tempBig));	
				list.add("Loai Sua ban nhieu nhat : " + " " + String.valueOf(tenhanglon));
				list.add("MaSua : " + " " + String.valueOf(masualon));	
				list.add("So luong : " + " " + String.valueOf(max));
				list.add("Loai Sua ban it nhat : " + " " + String.valueOf(tenhangbe));
				list.add("MaSua : " + " " + String.valueOf(masuabe));	
				list.add("So luong : " + " " + String.valueOf(min));
				list.add("----------------------------------------------------------");
				
				}
		});
		btnNewButton.setBounds(408, 303, 138, 47);
		contentPane.add(btnNewButton);
		
		Label label_1 = new Label("Tongsohoadon");
		label_1.setBounds(0, 49, 81, 21);
		contentPane.add(label_1);
		
		
		txttshd.setBounds(111, 49, 144, 21);
		contentPane.add(txttshd);
		
		Label label_2 = new Label("Tongtien");
		label_2.setBounds(0, 119, 59, 21);
		contentPane.add(label_2);
		
		
		txttongtien.setBounds(111, 119, 144, 21);
		contentPane.add(txttongtien);
		
		Label label_3 = new Label("Suabannhieunhat");
		label_3.setBounds(0, 158, 81, 21);
		contentPane.add(label_3);
		
	
		txtbnn.setBounds(111, 158, 144, 21);
		contentPane.add(txtbnn);
		
		Label label_4 = new Label("Soluong");
		label_4.setBounds(0, 233, 81, 21);
		contentPane.add(label_4);
		
		
		txtslbnn.setBounds(111, 233, 144, 21);
		contentPane.add(txtslbnn);
		
		Label label_5 = new Label("Tongsoluongsua");
		label_5.setBounds(0, 84, 59, 21);
		contentPane.add(label_5);
		
		
		txttsls.setBounds(111, 84, 144, 21);
		contentPane.add(txttsls);
		
		Label label_6 = new Label("Soloaisua");
		label_6.setBounds(0, 10, 59, 21);
		contentPane.add(label_6);
		
		
		txtloaisua.setBounds(111, 10, 144, 21);
		contentPane.add(txtloaisua);
		
		
		txtsln.setBounds(111, 200, 144, 21);
		contentPane.add(txtsln);
		
		Label lable_7 = new Label("Suabanitnhat");
		lable_7.setBounds(0, 275, 59, 21);
		contentPane.add(lable_7);
		
		Label lable_8 = new Label("MaSua");
		lable_8.setBounds(0, 317, 59, 21);
		contentPane.add(lable_8);
		
		Label label_9 = new Label("Soluong");
		label_9.setBounds(0, 355, 59, 21);
		contentPane.add(label_9);
		
		
		txtbin.setBounds(111, 275, 144, 21);
		contentPane.add(txtbin);
		
		txtsli.setBounds(111, 317, 144, 21);
		contentPane.add(txtsli);
		
		txtslbin.setBounds(111, 355, 144, 21);
		contentPane.add(txtslbin);
	}
}
