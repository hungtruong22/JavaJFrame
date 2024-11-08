package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.sua;
import bo.khachhangbo;
import bo.suabo;
import bean.khachhang;
import dao.coso;
import dao.khachhangdao;
import dao.suadao;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmhienthi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Choice choice = new Choice();
	TextField txttensua = new TextField();
	TextField txtgia = new TextField();
	TextField txtncc = new TextField();
	TextField txtmasua = new TextField();
	
	khachhangbo khbo = new khachhangbo();
	suabo sbo = new suabo();
	ArrayList<sua> ds;

	/**
	 * Launch the application.
	 */
	void NapBang(ArrayList<sua> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		String[] td = {"MaSua" , "TenSua" , "Gia" , "NCC"};
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmhienthi frame = new frmhienthi();
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
	public frmhienthi() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				new coso().KetNoi();// goi ham KetNoi() cua class CoSo trong dao
				try {
					setTitle("Quan Ly Sua: "+ frmdangnhap.dangnhap);
					ds = sbo.getSua();
					NapBang(ds);
					for (sua s : sbo.getSua())
					choice.add(s.getTensua());
				} catch (Exception e2) {
	  				// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 0, 0));
		tabbedPane.setBounds(10, 262, 558, 153);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Thong Tin Sua", null, scrollPane, null);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();// lay gia tri o hang trong table 
				txtmasua.setText(table.getValueAt(d, 0).toString());//lay ma sua
				txttensua.setText(table.getValueAt(d, 1).toString());//lay ten sua
				txtgia.setText(table.getValueAt(d, 2).toString());//lay gia cua sua
				txtncc.setText(table.getValueAt(d, 3).toString());//lay ten ncc
			}
		});
		scrollPane.setViewportView(table);
		
		Label label = new Label("Chon Sua");
		label.setBounds(10, 10, 76, 21);
		contentPane.add(label);
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					for(sua h: sbo.getSua()){
						 if(h.getTensua().equals(choice.getSelectedItem()))
							 txtgia.setText(h.getGia().toString());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		choice.setBounds(93, 13, 160, 18);
		contentPane.add(choice);
		
		Label label_1 = new Label("Ten Sua");
		label_1.setBounds(10, 85, 59, 21);
		contentPane.add(label_1);
		txttensua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==10) {
						txtgia.requestFocus();
					}
			}
		});
		
		txttensua.setBounds(93, 85, 160, 21);
		contentPane.add(txttensua);
		
		Label label_2 = new Label("Gia");
		label_2.setBounds(10, 127, 59, 21);
		contentPane.add(label_2);
		
		txtgia.setBounds(93, 127, 160, 21);
		contentPane.add(txtgia);
		
		JButton btnNewButton = new JButton("Them");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String masua = txtmasua.getText();
					String tensua = txttensua.getText();
					Double gia = Double.parseDouble(txtgia.getText());
					String ncc = txtncc.getText();
					sbo.Them(masua, tensua, gia, ncc);
					NapBang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(323, 10, 95, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sua");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String masua = txtmasua.getText();
					String tensua = txttensua.getText();
					Double gia = Double.parseDouble(txtgia.getText());
					String ncc = txtncc.getText();
					int kt = sbo.Sua(masua,tensua,gia,ncc);
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
		btnNewButton_1.setBounds(323, 48, 95, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xoa");
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int kt=
				sbo.Xoa(txtmasua.getText());
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
		btnNewButton_2.setBounds(323, 85, 95, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tim Kiem");
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = JOptionPane.showInputDialog("Nhap masua hoac tensua");
				try {
					NapBang(sbo.TimKiem(key));
				} catch (Exception e2) {
					// TODO: handle exception
					//e2.printStackTrace();
					JOptionPane.showConfirmDialog(null, "khong tim thay" + key);
				}
			}
		});
		btnNewButton_3.setBounds(323, 127, 95, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Mua Hang");
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmthongtinkhachhang ttkh = new frmthongtinkhachhang();
				ttkh.setVisible(true);
				System.out.println("\nChuyen den thong tin khach hang de dien thong tin nguoi mua!");
			}
		});
		btnNewButton_4.setBounds(112, 219, 128, 21);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("NCC");
		lblNewLabel.setBounds(10, 177, 45, 13);
		contentPane.add(lblNewLabel);
		
		
		txtncc.setBounds(93, 173, 162, 21);
		contentPane.add(txtncc);
		
		Label label_5 = new Label("Ma Sua");
		label_5.setBounds(10, 48, 59, 21);
		contentPane.add(label_5);
		
		txtmasua.setBounds(93, 48, 160, 21);
		contentPane.add(txtmasua);
	}
}
