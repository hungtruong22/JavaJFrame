package hocjframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jframe3 extends JFrame {
	TextField txttenhang = new TextField();
	TextField txtgia = new TextField();
	
	ArrayList<String> ds = new ArrayList<String>(); // goi la truong(khai bao ben ngoai lop)
	// bien (khai bao ben tromg lop)
	private JPanel contentPane;
	private JTable table;

	void NapBang(ArrayList<String> ds) {
		//buoc 1: tao mo hinh bang
		DefaultTableModel mohinh = new DefaultTableModel();
		// buoc 2: Tao cot
		mohinh.addColumn("Ten hang");
		mohinh.addColumn("Gia");
		// buoc 3 : them vao 1 dong
		for(String h : ds) {
		String[] tt=h.split("[;]");
		Object[] t = new Object[2]; // tao 1 mang object gom 2 doi tuong 
		t[0]=tt[0];
		t[1]=tt[1];
		//t[0] = "Ma tuy";
		//t[1] = "5000";
		mohinh.addRow(t); // them hang
		}
		// buoc 4 : Dua mo hinh vao bang
		table.setModel(mohinh);
		
		}

	void LuuFile() {
		try {
			FileWriter f= new FileWriter("hang.txt");
			PrintWriter ghi= new PrintWriter(f);
			for(String h : ds) {
			//Ghi hang vao file
			ghi.println(h);
			//Them vao ds
			}
			ghi.close();	
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe3 frame = new jframe3();
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
	public jframe3() {
		addWindowListener(new WindowAdapter() {
			@Override
			// khi mo windowopped -> doc du lieu file hang va them vao danh sach "ds"
			public void windowOpened(WindowEvent e) {
				try {
					//Mo file hang.txt ra de doc
					FileReader f= new FileReader("hang.txt");
					//Doc toan bo noi dung file vao bo dem
					BufferedReader r = new BufferedReader(f);
			        //Duyet bo dem de lay du lieu ra
					while(true) {
					 String st= r.readLine();
					 if(st==null||st=="") break;
					 String[] tt= st.split("[;]");
					 ds.add(st);
					}
					// dong file
					r.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				NapBang(ds);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 133, 416, 120);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = table.getSelectedRow();
				String tenhang = table.getValueAt(d, 0).toString();
				txttenhang.setText(tenhang);
				//String tenhang = table.getValueAt(d, 1).toString();// lay gia
				txtgia.setText(table.getValueAt(d, 1).toString());//lay gia cua san pham
			}
		});
		scrollPane.setViewportView(table);
		txttenhang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					txtgia.requestFocus();
				}
			}
		});
		
		
		txttenhang.setBounds(62, 10, 249, 21);
		contentPane.add(txttenhang);
		
		txtgia.setBounds(62, 49, 249, 21);
		contentPane.add(txtgia);
		
		Button buttonthem = new Button("Them");
		buttonthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Mo file o che do bo sung
				try {
					FileWriter f= new FileWriter("hang.txt",true);
					PrintWriter ghi= new PrintWriter(f);
					String h=txttenhang.getText()+";"+txtgia.getText();
					//Ghi hang vao file
					ghi.println(h);
					//Them vao ds
					ds.add(h);
					NapBang(ds);
					ghi.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		buttonthem.setBounds(360, 10, 66, 21);
		contentPane.add(buttonthem);
		
		Button buttonxoa = new Button("Xoa");
		buttonxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = JOptionPane.showConfirmDialog(null,"Xoa ko thi bao ?");
				System.out.println(t);//in ra gia tri : 0 = yes , 1 = no , 2 = cancel
			    if(t==0) {
				String th = txttenhang.getText();
				int n = ds.size(); // lay ra do dai cua mang
				for(int i = 0 ; i < n ; i++) { // duyet tu phan tu dau tien den phan tu cuoi cung
					String h = ds.get(i);// lay mat hang thu i
					String[] tt = h.split("[;]");
					if(tt[0].equalsIgnoreCase(th)) {
						ds.remove(i); // xoa mat hang thu i tring ds
						LuuFile();
					}
				}
				NapBang(ds);
			}
			}
		});
		buttonxoa.setBounds(360, 49, 66, 21);
		contentPane.add(buttonxoa);
		
		Button buttonSua = new Button("Sua");
		buttonSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = txttenhang.getText();
				int n = ds.size(); // lay ra do dai cua mang
				for(int i = 0 ; i < n ; i++) { // duyet tu phan tu dau tien den phan tu cuoi cung
					String h = ds.get(i);// lay mat hang thu i
					String[] tt = h.split("[;]");
					if(tt[0].equalsIgnoreCase(th)) { // tim theo ten hang
						String hm = th + ";"+txtgia.getText(); 
						ds.set(i, hm); // sua hang thu i trong mang
						LuuFile();
						break;
					}
				}
				NapBang(ds);
			}
			
		});
		buttonSua.setBounds(360, 89, 66, 21);
		contentPane.add(buttonSua);
		
		Button buttontimkiem = new Button("Tim kiem");
		buttontimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = JOptionPane.showInputDialog("Nhap ten hang can tim :");
				// Tao mang tam dr luu cac hang tim duoc 
				ArrayList<String> danhsach = new ArrayList<String>();
					// duyet qua mang ds de tim hang co chu key
					 for(String ht: ds) {
				    // neu tim duoc -> luu hang vao mang tam
					  if(ht.toLowerCase().trim().contains(key.toLowerCase().trim()))
							 danhsach.add(ht);
			}	
				//NapBang(Mang tam)
					 NapBang(danhsach);
			}
		});
		buttontimkiem.setBounds(239, 89, 66, 21);
		contentPane.add(buttontimkiem);
	}
}
