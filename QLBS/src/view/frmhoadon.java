package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.hoadon;
import bean.khachhang;
import bean.sua;
import bo.khachhangbo;
import bo.suabo;
import bo.hoadonbo;
import dao.coso;
import dao.hoadondao;

import javax.swing.JList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.List;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frmhoadon extends JFrame {

	private JPanel contentPane;
	List list = new List();
	hoadonbo hdbo = new hoadonbo();
	khachhangbo khbo = new khachhangbo();
	suabo sbo = new suabo();
	ArrayList<hoadon> ds;
	ArrayList<sua> ds1;
	ArrayList<khachhang> ds2;
	TextField txtmahd = new TextField();
	TextField txtmasua = new TextField();
	TextField txtmakh = new TextField();
	TextField txttensua = new TextField();
	TextField txtgia = new TextField();
	TextField txtsl = new TextField();
	TextField txtthanhtien = new TextField();
	TextField txtngaymua = new TextField();
	private JTable table_1;
	private JTable table;
	public hoadon hd;

	/**
	 * Launch the application.
	 */

	void NapBang1(ArrayList<sua> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		String[] td = { "MaSua", "TenSua", "Gia", "NCC" };
		mh.setColumnIdentifiers(td);
		for (sua s : ds) {
			Object[] t = new Object[5];
			t[0] = s.getMasua();
			t[1] = s.getTensua();
			t[2] = s.getGia();
			t[3] = s.getNcc();
			mh.addRow(t);
		}
		table.setModel(mh);
	}

	void NapBang2(ArrayList<khachhang> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		String[] td = { "MaKH", "HoTen", "DiaChi", "SDT", "TenDN", "MatKhau" };
		mh.setColumnIdentifiers(td);
		for (khachhang kh : ds) {
			Object[] t = new Object[7];
			t[0] = kh.getMakh();
			t[1] = kh.getHoten();
			t[2] = kh.getDiachi();
			t[3] = kh.getSdt();
			t[4] = kh.getTendn();
			t[5] = kh.getMatkhau();
			mh.addRow(t);
		}
		table_1.setModel(mh);
	}

//	String hoadon
	void NapList(ArrayList<hoadon> ds, String mahd) {
		list.removeAll();// Xoa tat ca du lieu trong list
		int n = ds.size();
		for (int i = 0; i < n; i++) {// Duyet tu hoadon dau den hoadon cuoi trong danh sach
			hoadon hd = (hoadon) ds.get(i);// Lay ra hoadon thu i
			if (hd.getMahd().equals(mahd)) {// So sanh voi hoadon truyen vao
				// Nap du lieu vao list
				list.add("-----------------HOADONBANSUA-----------------");
				list.add("MaHD: "+hd.getMahd());
				list.add("MaSua: "+hd.getMasua());
				list.add("MaKH: "+hd.getMakh());
				list.add("TenSua: "+hd.getTensua());
				list.add("Gia: "+String.valueOf(hd.getGia()));
				list.add("SoLuong: "+String.valueOf(hd.getSoluong()));
				list.add("ThanhTien: "+String.valueOf(hd.getThanhtien()));
	
				try {
					String nm = String.valueOf(hd.getNgay());
					DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
					Date date = (Date)formatter.parse(nm);
					System.out.println(date);        
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
					System.out.println("formatedDate : " + formatedDate);
					list.add("NgayMua: "+formatedDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				list.add("----------------------------------");
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmhoadon frame = new frmhoadon();
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
	public frmhoadon() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				new coso().KetNoi();// goi ham KetNoi() cua class CoSo trong dao
				try {
					setTitle("Quan Ly Hoa Don: " + frmdangnhap.dangnhap);
					ds = hdbo.getHD();
					ds1 = sbo.getSua();
					NapBang1(ds1);
					ds2 = khbo.getKH();
					NapBang2(ds2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		list.setBounds(304, 10, 264, 220);
		contentPane.add(list);

		JButton btnNewButton = new JButton("Hien Thi Hoa Don");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String mahd = txtmahd.getText();
					String masua = txtmasua.getText();
					String makh = txtmakh.getText();
					String tensua = txttensua.getText();
					Double gia = Double.parseDouble(txtgia.getText());
					Integer soluong = Integer.parseInt(txtsl.getText());
					Double thanhtien = Double.parseDouble(txtthanhtien.getText());
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
					Date ngay = (Date) formatter.parse(txtngaymua.getText());
					int kt = hdbo.HienThiHoaDon(mahd, masua, makh, tensua, gia, soluong, thanhtien, ngay);
					NapList(ds, mahd);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(372, 236, 149, 38);
		contentPane.add(btnNewButton);

		Label label = new Label("MaHD");
		label.setBounds(10, 10, 59, 21);
		contentPane.add(label);

		Label label_1 = new Label("MaSua");
		label_1.setBounds(10, 46, 59, 21);
		contentPane.add(label_1);

		Label label_2 = new Label("MaKH");
		label_2.setBounds(10, 84, 59, 21);
		contentPane.add(label_2);

		Label label_3 = new Label("TenSua");
		label_3.setBounds(10, 119, 59, 21);
		contentPane.add(label_3);

		Label label_4 = new Label("Gia");
		label_4.setBounds(10, 159, 59, 21);
		contentPane.add(label_4);

		Label label_5 = new Label("SoLuong");
		label_5.setBounds(10, 198, 59, 21);
		contentPane.add(label_5);

		Label label_6 = new Label("ThanhTien");
		label_6.setBounds(10, 237, 59, 21);
		contentPane.add(label_6);

		txtmahd.setBounds(75, 10, 161, 21);
		contentPane.add(txtmahd);

		txtmasua.setBounds(75, 46, 161, 21);
		contentPane.add(txtmasua);

		txtmakh.setBounds(75, 84, 161, 21);
		contentPane.add(txtmakh);

		txttensua.setBounds(75, 119, 161, 21);
		contentPane.add(txttensua);

		txtgia.setBounds(75, 159, 161, 21);
		contentPane.add(txtgia);
		txtsl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					Long sl = Long.parseLong(txtsl.getText());
					Double gia = Double.parseDouble(txtgia.getText());
					Double thanhtien = gia * sl;
					txtthanhtien.setText(thanhtien.toString());
				}
			}
		});

		txtsl.setBounds(75, 198, 161, 21);
		contentPane.add(txtsl);

		txtthanhtien.setBounds(75, 237, 157, 21);
		contentPane.add(txtthanhtien);

		Label label_7 = new Label("Ngaymua");
		label_7.setBounds(10, 275, 59, 21);
		contentPane.add(label_7);

		txtngaymua.setBounds(75, 275, 161, 21);
		contentPane.add(txtngaymua);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 0, 0));
		tabbedPane.setBounds(10, 321, 255, 104);
		contentPane.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Thong tin Sua", null, scrollPane, null);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();// lay gia tri o hang trong table
				txtmasua.setText(table.getValueAt(d, 0).toString());// lay ma sua
				txttensua.setText(table.getValueAt(d, 1).toString());// lay ten sua
				txtgia.setText(table.getValueAt(d, 2).toString());// lay gia cua sua
			}
		});
		scrollPane.setViewportView(table);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setForeground(new Color(255, 0, 0));
		tabbedPane_1.setBounds(304, 321, 264, 104);
		contentPane.add(tabbedPane_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab("Thong tin khach hang", null, scrollPane_1, null);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table_1.getSelectedRow();// lay gia tri o hang trong table
				txtmakh.setText(table_1.getValueAt(d, 0).toString());// lay ma khach hang
			}
		});
		scrollPane_1.setViewportView(table_1);
	}
}
