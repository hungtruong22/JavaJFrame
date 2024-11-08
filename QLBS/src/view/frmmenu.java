package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.coso;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class frmmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmmenu frame = new frmmenu();
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
	public frmmenu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				new coso().KetNoi();// goi ham KetNoi() cua class CoSo trong dao
				try {
				setTitle("MENU: ");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 444);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 240, 245));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Quanli");
		mnNewMenu.setBackground(new Color(255, 255, 255));
		mnNewMenu.setForeground(new Color(255, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quanlisua");
		mntmNewMenuItem.setForeground(new Color(255, 0, 0));
		mntmNewMenuItem.setBackground(new Color(0, 255, 255));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmhienthi f = new frmhienthi();
				f.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thoat");
		mntmNewMenuItem_1.setForeground(new Color(255, 0, 0));
		mntmNewMenuItem_1.setBackground(new Color(0, 255, 255));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Quanlihoadon");
		mntmNewMenuItem_4.setForeground(new Color(255, 0, 0));
		mntmNewMenuItem_4.setBackground(new Color(0, 255, 255));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmhoadon t = new frmhoadon();
				t.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Khachhang");
		mnNewMenu_1.setBackground(new Color(255, 255, 255));
		mnNewMenu_1.setForeground(new Color(255, 0, 0));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Thong tin khach hang");
		mntmNewMenuItem_2.setForeground(new Color(255, 0, 0));
		mntmNewMenuItem_2.setBackground(new Color(0, 255, 255));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmthongtinkhachhang h = new frmthongtinkhachhang();
				h.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Thong Ke");
		mnNewMenu_2.setBackground(new Color(255, 255, 255));
		mnNewMenu_2.setForeground(new Color(255, 0, 0));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Thongke");
		mntmNewMenuItem_3.setForeground(new Color(255, 0, 0));
		mntmNewMenuItem_3.setBackground(new Color(0, 255, 255));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmthongke tk = new frmthongke();
				tk.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hinhnen = new JLabel("");
		hinhnen.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QLBS\\qlbs.png"));
		hinhnen.setBounds(10, 10, 534, 348);
		contentPane.add(hinhnen);
	}
}
