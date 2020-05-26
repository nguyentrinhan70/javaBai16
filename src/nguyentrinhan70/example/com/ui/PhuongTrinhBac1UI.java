package nguyentrinhan70.example.com.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhuongTrinhBac1UI extends JFrame {
	
	JTextField txtHeSoA;
	JTextField txtHeSoB, txtKetQua;
	JButton btnGiai, btnThoat, btnHelp;
	
	ActionListener eventGiai = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			xuLyGiaiPhuongTrinh();
		}
	};
	 public PhuongTrinhBac1UI(String tieude) {
		// TODO Auto-generated constructor stub
		 super(tieude);
		 addControls();
		 addEvents();
	} 
	 protected void xuLyGiaiPhuongTrinh() {
		// TODO Auto-generated method stub
		 String hsa = txtHeSoA.getText();
		 String hsb = txtHeSoB.getText();
		 double a = Double.parseDouble(hsa);
		 double b = Double.parseDouble(hsb);
		 
		 if(a==0 && b==0){
			 txtKetQua.setText("Phương trình có vô số nghiệm");
		 }
		 else if(a==0 && b!=0){
			txtKetQua.setText("Phương trình vô nghiệm");
		}
		 else{
			 double x = -b/a;
			 txtKetQua.setText("X =" + x);
		 }
	}
	public void addEvents() {
		 btnThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		 
		 btnGiai.addActionListener(eventGiai);
		 btnHelp.addActionListener(new HelpEvent());
	}
	 
	 public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		con.add(pnMain);
		
		JPanel pnTitle = new JPanel();
		pnMain.setLayout(new FlowLayout());
		JLabel lblTieuDe = new JLabel("Giải phương trình bậc 1");
		pnTitle.add(lblTieuDe);
		pnMain.add(pnTitle);
		lblTieuDe.setForeground(Color.blue);
		Font fontTieuDe = new Font("arial", Font.BOLD, 20);
		lblTieuDe.setFont(fontTieuDe);
		
		JPanel pnHeSoA = new JPanel();
		pnHeSoA.setLayout(new FlowLayout());
		JLabel lblHeSoA = new JLabel("Hệ số a:");
		txtHeSoA = new JTextField(15);
		pnHeSoA.add(lblHeSoA);
		pnHeSoA.add(txtHeSoA);
		pnMain.add(pnHeSoA);
		
		
		JPanel pnHeSoB = new JPanel();
		pnHeSoB.setLayout(new FlowLayout());
		JLabel lblHeSoB = new JLabel("Hệ số b:");
		txtHeSoB = new JTextField(15);
		pnHeSoB.add(lblHeSoB);
		pnHeSoB.add(txtHeSoB);
		pnMain.add(pnHeSoB);


		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnGiai = new JButton("Giải");
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("hinh/exit.png"));
		btnHelp = new JButton("Help");
		pnButton.add(btnGiai);
		pnButton.add(btnThoat);
		pnButton.add(btnHelp);
		pnMain.add(pnButton);
		
		JPanel pnKetQua = new JPanel();
		pnKetQua.setLayout(new FlowLayout());
		JLabel lblKetQua = new JLabel("Kết quả:");
		txtKetQua = new JTextField(15);
		pnKetQua.add(lblKetQua);
		pnKetQua.add(txtKetQua);
		pnMain.add(pnKetQua);
		
				
	}
	 class HelpEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, 
					"Chi tiết xin liên hệ thầy Nhân:"
					+ " nguyentrinhan70@gmail.com");
		}
	 }
	 public void showWindow() {
		 this.setSize(300, 250);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
	}
}
