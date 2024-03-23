package ntu_63135948;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.border.BevelBorder;
public class ManHinhChiSoBMI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtChieuCao;
	private JTextField txtCanNang;


	public ManHinhChiSoBMI() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chỉ Số Cơ Thể");
		lblNewLabel.setBounds(126, 11, 137, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		contentPane.add(lblNewLabel);
		
		JLabel lblChiuCao = new JLabel("Chiều cao(cm)");
		lblChiuCao.setBounds(10, 99, 152, 25);
		lblChiuCao.setForeground(new Color(0, 128, 0));
		lblChiuCao.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblChiuCao);

		txtChieuCao = new JTextField();
		txtChieuCao.setBounds(164, 99, 207, 26);
		contentPane.add(txtChieuCao);
		txtChieuCao.setColumns(10);
		
		JLabel lblCnNngkg = new JLabel("Cân nặng(kg)");
		lblCnNngkg.setBounds(10, 155, 152, 25);
		lblCnNngkg.setForeground(new Color(0, 128, 0));
		lblCnNngkg.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblCnNngkg);
		
		txtCanNang = new JTextField();
		txtCanNang.setBounds(164, 154, 207, 26);
		txtCanNang.setColumns(10);
		contentPane.add(txtCanNang);



		
		
		
	}
	
}
