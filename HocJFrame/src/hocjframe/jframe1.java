package hocjframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jframe1 extends JFrame {
	Choice Chang = new Choice();
	TextField txtgia = new TextField();
	TextField txtnhapsoluong = new TextField();
	TextField txtthanhtien = new TextField();
	TextField txtbangchu = new TextField();
	
	ArrayList<String> ds = new ArrayList<String>();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe1 frame = new jframe1();
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
	public jframe1() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// cach 1: them tung mat hang
				//Chang.add("Xang");
				//Chang.add("Dau");
				//Chang.add("Nhot");
				//Chang.add("Thep");
				
				//------------------------
				
				// cach 2:
				// luu du lieu vao file hang.txt
				try {
					//Mo file hang.txt ra de doc
					FileReader f = new FileReader("hang.txt");
					//Doc toan bo noi dung file vao bo dem
					BufferedReader r = new BufferedReader(f);
			        //Duyet bo dem de lay du lieu ra
					while(true) {
					 String st= r.readLine();
					 if(st==null||st=="")
						 break;
					 String[] tach= st.split("[;]");// tach du lieu 
					 Chang.add(tach[0]); 
					 Chang.select(Chang.getItemCount()-1);// chon mat hang cuoi cung
					 txtgia.setText(tach[1]); 
					 ds.add(st);
					}
					// dong file
					r.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Chon hang");
		label.setBounds(0, 10, 59, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Gia");
		label_1.setBounds(0, 50, 59, 21);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Nhap SL");
		label_2.setBounds(0, 99, 59, 21);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Thanh Tien");
		label_3.setBounds(0, 145, 59, 21);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Bang Chu");
		label_4.setBounds(0, 194, 59, 21);
		contentPane.add(label_4);
		
		txtgia.setBounds(133, 50, 197, 21);
		contentPane.add(txtgia);
		//nhap so luong va in ra thanh tien
		txtnhapsoluong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					Long sl = Long.parseLong(txtnhapsoluong.getText());
					Long gia = Long.parseLong(txtgia.getText());
					Long thanhtien = gia*sl;
					txtthanhtien.setText(thanhtien.toString());
				}
			}
		});
		
		txtnhapsoluong.setBounds(133, 99, 197, 21);
		contentPane.add(txtnhapsoluong);
		
		txtthanhtien.setBounds(133, 145, 197, 21);
		contentPane.add(txtthanhtien);
		
		txtbangchu.setBounds(133, 194, 197, 21);
		contentPane.add(txtbangchu);
		
		Button buttonban = new Button("Ban");
		//bam nut "Ban" se luu du lieu mat hang vua ban vao file "thongke.txt"
		buttonban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Mo file "thongke.txt" de ghi
					FileWriter f = new FileWriter("thongke.txt",true);
					PrintWriter ghi = new PrintWriter(f);
					ghi.println(Chang.getSelectedItem() + ";" + txtnhapsoluong.getText() +
							";" + txtgia.getText() + ";" + txtthanhtien.getText() +
							";" + java.time.LocalDateTime.now());
					// dong va luu file
					ghi.close();
					System.out.println("Da luu thing tin ban hang !!!\n");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		buttonban.setBounds(49, 268, 66, 21);
		contentPane.add(buttonban);
		
		Button buttonthongke = new Button("Thong Ke");
		//khi bam nut "Thongke" se hien ra tong so tien da ban trong file"Thongke.txt"
		buttonthongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Mo file thongke.txt ra de doc
					FileReader f= new FileReader("thongke.txt");
					//Doc toan bo noi dung file vao bo dem
					BufferedReader r = new BufferedReader(f);
			       //Duyet bo dem de lay du lieu ra
					long sum = 0;
					long tong;
					while(true) {
					 String st= r.readLine();
					 if(st==null||st=="") break;
					 String[] ds = st.split("[;]");
					 long tien = Long.parseLong(ds[3]);
					 sum = sum + tien;
					}
					tong = sum;
					System.out.println("\nTong Tien  = " + tong);
					//dongfile
					r.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		buttonthongke.setBounds(297, 268, 66, 21);
		contentPane.add(buttonthongke);
		// gia cho moi san pham
		Chang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String th = Chang.getSelectedItem();
				// cach 1:
				 /*		if(th.equals("Xang")) {
							txtgia.setText("27000");
						}	
						else if(th.equals("Dau")) {
							txtgia.setText("20000");
						}
						else if(th.equals("Nhot")){
							txtgia.setText("150000");
						}
						else {
							txtgia.setText("200000");
						} */
						
						//-----------------
						
						// cach 2:
				// duyet tu dau het cuoi danh sach
				for(String h : ds) {
					String[] tach = h.split("[;]");
					if(tach[0].equalsIgnoreCase(th))
						txtgia.setText(tach[1]);
				}
			}
		});
		
		
		Chang.setBounds(138, 13, 192, 18);
		contentPane.add(Chang);
	}
}
