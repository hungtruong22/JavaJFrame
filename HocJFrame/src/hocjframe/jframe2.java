package hocjframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class jframe2 extends JFrame {
	Choice choice = new Choice();
	List list = new List();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframe2 frame = new jframe2();
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
	public jframe2() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					//Mo file danhsach.txt ra de doc
					FileReader f= new FileReader("danhsach.txt");
					//Doc toan bo noi dung file vao bo dem
					BufferedReader r = new BufferedReader(f);
			        //Duyet bo dem de lay du lieu ra
					while(true) {
					 String st= r.readLine();
					 if(st == null||st == "") break;
					 String[] ds = st.split("[;]");
					    list.add(ds[0]);
					    choice.add(ds[1]);
					}
					r.close();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		choice.setBounds(22, 10, 147, 18);
		contentPane.add(choice);
		
		list.setBounds(244, 10, 147, 187);
		contentPane.add(list);
		
		Button button = new Button("Load data");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Mo file danhsach.txt ra de doc
					FileReader f= new FileReader("danhsach.txt");
					//Doc toan bo noi dung file vao bo dem
					BufferedReader r = new BufferedReader(f);
			        //Duyet bo dem de lay du lieu ra
					while(true) {
					 String st= r.readLine();
					 if(st == null||st == "") break;
					 String[] ds = st.split("[;]");
					    list.add(ds[0]);
					    choice.add(ds[1]);
					}
					r.close();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		button.setBounds(64, 170, 66, 21);
		contentPane.add(button);
	}
}
