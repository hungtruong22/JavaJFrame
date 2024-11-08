package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.khachhang;
import bean.sua;
import bo.khachhangbo;
import bo.suabo;
import dao.coso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frmthongtinkhachhang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	TextField txtmakh = new TextField();
	TextField txthoten = new TextField();
	TextField txtdiachi = new TextField();
	TextField txtsdt = new TextField();
	TextField txttendn = new TextField();
	TextField txtmatkhau = new TextField();
	
	khachhangbo khbo = new khachhangbo();
	suabo sbo = new suabo();
	ArrayList<khachhang> ds;
	/**
	 * Launch the application.
	 */
	
	void NapBang(ArrayList<khachhang> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		String[] td = {"MaKH" , "HoTen" , "DiaChi" , "SDT" , "TenDN" , "MatKhau"};
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
		table.setModel(mh);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmthongtinkhachhang frame = new frmthongtinkhachhang();
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
	public frmthongtinkhachhang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				new coso().KetNoi();// goi ham KetNoi() cua class CoSo trong dao
				try {
				setTitle("Quan Ly Thong Tin Khach Hang: "+ frmdangnhap.dangnhap);
					ds = khbo.getKH();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				NapBang(ds);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Ma Khach Hang");
		label.setBounds(0, 10, 113, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Ho Ten");
		label_1.setBounds(0, 50, 59, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Dia Chi");
		label_2.setBounds(0, 89, 59, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("SDT");
		label_3.setBounds(0, 131, 59, 21);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Ten DN");
		label_4.setBounds(0, 175, 59, 21);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Mat Khau");
		label_5.setBounds(0, 220, 59, 21);
		contentPane.add(label_5);
		
		
		txtmakh.setBounds(148, 10, 156, 21);
		contentPane.add(txtmakh);
		
		txthoten.setBounds(148, 50, 156, 21);
		contentPane.add(txthoten);
		
		txtdiachi.setBounds(148, 89, 156, 21);
		contentPane.add(txtdiachi);
		
		txtsdt.setBounds(148, 131, 156, 21);
		contentPane.add(txtsdt);
		
		txttendn.setBounds(148, 175, 156, 21);
		contentPane.add(txttendn);
		
		txtmatkhau.setBounds(146, 220, 158, 21);
		contentPane.add(txtmatkhau);
		
		JButton btnNewButton = new JButton("Them");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String makh = txtmakh.getText();
					String hoten = txthoten.getText();
					String diachi = txtdiachi.getText();
					String sdt = txtsdt.getText();
					String tendn = txttendn.getText();
					String matkhau = txtmatkhau.getText();
					khbo.Them(makh, hoten, diachi, sdt, tendn, matkhau);
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(353, 10, 113, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sua");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String makh = txtmakh.getText();
					String hoten = txthoten.getText();
					String diachi = txtdiachi.getText();
					String sdt = txtsdt.getText();
					String tendn = txttendn.getText();
					String matkhau = txtmatkhau.getText();
					int kt = khbo.Sua(makh, hoten, diachi, sdt, tendn, matkhau);
				if(kt==0)
					JOptionPane.showMessageDialog(null, "Ko sua duoc");
				else
					JOptionPane.showMessageDialog(null, "Da sua");
				NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(353, 50, 113, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xoa");
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt=
				khbo.Xoa(txtmakh.getText());
				if(kt==0)
					JOptionPane.showMessageDialog(null, "Ko xoa duoc");
				else
					JOptionPane.showMessageDialog(null, "Da xoa");
				NapBang(ds);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(353, 89, 113, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tim Kiem");
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = JOptionPane.showInputDialog("Nhap ma lop hoac ho ten");
				try {
					NapBang(khbo.TimKiem(key));
				} catch (Exception e2) {
					// TODO: handle exception
					//e2.printStackTrace();
					JOptionPane.showConfirmDialog(null, "khong tim thay" + key);
				}
			}
		});
		btnNewButton_3.setBounds(353, 131, 113, 21);
		contentPane.add(btnNewButton_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setForeground(new Color(255, 0, 0));
		tabbedPane.setBounds(0, 280, 561, 130);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Thong tin khach hang", null, scrollPane, null);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();// lay gia tri o hang trong table 
				txtmakh.setText(table.getValueAt(d, 0).toString());//lay ma khach hang
				txthoten.setText(table.getValueAt(d, 1).toString());//lay hoten khach hang
				txtdiachi.setText(table.getValueAt(d, 2).toString());//lay diachi khach hang
				txtsdt.setText(table.getValueAt(d, 3).toString());//lay sdt
				txttendn.setText(table.getValueAt(d, 4).toString());//lay tendn
				txtmatkhau.setText(table.getValueAt(d, 5).toString());//lay matkhau
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("OK");
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmhoadon hd = new frmhoadon();
				hd.setVisible(true);
				System.out.println("\nChuyen den hoa don de in ra hoa don mua hang cua nguoi dung!");
			}
		});
		btnNewButton_4.setBounds(170, 249, 85, 21);
		contentPane.add(btnNewButton_4);
	}
}
