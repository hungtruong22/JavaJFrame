package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class frmdangnhap extends JFrame {

	private JPanel contentPane;
	TextField txtdangnhap = new TextField();
	TextField txtmatkhau = new TextField();
	public static String dangnhap="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmdangnhap frame = new frmdangnhap();
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
	public frmdangnhap() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setTitle("DANG NHAP TAI KHOAN");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ten Dang Nhap");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(20, 111, 97, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mat Khau");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(20, 149, 68, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Dang Nhap");
		btnNewButton.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangnhap = txtdangnhap.getText();
				if(txtdangnhap.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui long dien tendn!");
				}
				else if(txtmatkhau.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "vui long dien matkhau!");
				}
				else {
					try {
						String st = "jdbc:sqlserver://DESKTOP-RQV86U4:1433;databaseName=quanlybansua;user=sa; password=truongminhhung";
						Connection cn = DriverManager.getConnection(st);
						String sql = "select * from KHACHHANG where TENDN=? and MATKHAU=?";
						PreparedStatement ps = cn.prepareStatement(sql);
						ps.setString(1, txtdangnhap.getText());
						ps.setString(2, txtmatkhau.getText());
						ResultSet rs = ps.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "chuc mung dang nhap thanh cong");
							frmmenu f = new frmmenu();
							f.setVisible(true); 
						}
						else {
							JOptionPane.showMessageDialog(null, "dang nhap that bai");
						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println(e2);
					}
				}
				
			}
		});
		btnNewButton.setBounds(182, 199, 128, 21);
		contentPane.add(btnNewButton);
		
		
		txtdangnhap.setBounds(157, 111, 181, 21);
		contentPane.add(txtdangnhap);
		
		txtmatkhau.setEchoChar('*');
		txtmatkhau.setBounds(157, 149, 181, 21);
		contentPane.add(txtmatkhau);
		
		JLabel hinhnen = new JLabel("");
		hinhnen.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QLBS\\hinhnensua2.png"));
		hinhnen.setBounds(10, 10, 463, 361);
		contentPane.add(hinhnen);
	}
}
