package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Form extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8961811043514396950L;

	public Form() {
		setBounds(1000, 270, 350, 350);
		setLayout(null);
		setResizable(false);
		setVisible(false);
		setTitle("Trợ Giúp");

		JLabel so1 = new JLabel("Số thứ nhất:");
		so1.setForeground(Color.red);
		so1.setBounds(10, 70, 150, 30);
		this.add(so1);

		JTextField jso1 = new JTextField();
		jso1.setBounds(100, 70, 200, 25);
		this.add(jso1);

		JLabel so2 = new JLabel("Số thứ hai:");
		so2.setForeground(Color.red);
		so2.setBounds(10, 120, 150, 30);
		this.add(so2);

		JTextField jso2 = new JTextField();
		jso2.setBounds(100, 120, 200, 25);
		this.add(jso2);

		JLabel ketqua = new JLabel("Kết quả:");
		ketqua.setForeground(Color.red);
		ketqua.setBounds(10, 170, 150, 30);
		this.add(ketqua);

		JLabel jketqua = new JLabel("0");
		jketqua.setForeground(Color.white);
		Font font = new Font("arial", Font.BOLD, 25);
		jketqua.setFont(font);
		jketqua.setBounds(100, 175, 200, 25);
		this.add(jketqua);

		JButton cong = new JButton("Cộng");
		cong.setForeground(Color.red);
		cong.setBackground(Color.yellow);
		cong.setBounds(15, 230, 70, 30);
		this.add(cong);

		JButton tru = new JButton("Trừ");
		tru.setForeground(Color.red);
		tru.setBackground(Color.yellow);
		tru.setBounds(95, 230, 70, 30);
		this.add(tru);

		JButton nhan = new JButton("Nhân");
		nhan.setForeground(Color.red);
		nhan.setBackground(Color.yellow);
		nhan.setBounds(175, 230, 70, 30);
		this.add(nhan);

		JButton chia = new JButton("Chia");
		chia.setForeground(Color.red);
		chia.setBackground(Color.yellow);
		chia.setBounds(255, 230, 70, 30);
		this.add(chia);

		ImageIcon icon3 = new ImageIcon("./images/calcu.jpg");
		JLabel lbicon3 = new JLabel();
		lbicon3.setBounds(0, 0, 350, 350);
		lbicon3.setIcon(icon3);
		this.add(lbicon3);

		cong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(cong)) {
					if (!jso1.getText().matches("\\d*") || !jso2.getText().matches("\\d*")) {
						JOptionPane.showMessageDialog(null, "Nhập số mới tính được Bé ơi");
					} else {
						int kq;
						String so1 = jso1.getText();
						String so2 = jso2.getText();
						kq = Integer.parseInt(so1) + Integer.parseInt(so2);
						jketqua.setText("" + kq);
					}
				}

			}
		});

		tru.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(tru)) {
					if (!jso1.getText().matches("\\d*") || !jso2.getText().matches("\\d*")) {
						JOptionPane.showMessageDialog(null, "Nhập số mới tính được bé ơi");
					} else {
						int kq;
						String so1 = jso1.getText();
						String so2 = jso2.getText();
						kq = Integer.parseInt(so1) - Integer.parseInt(so2);
						jketqua.setText("" + kq);
					}
				}

			}
		});

		nhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(nhan)) {
					if (!jso1.getText().matches("\\d*") || !jso2.getText().matches("\\d*")) {
						JOptionPane.showMessageDialog(null, "Nhập số mới tính được bé ơi");
					} else {
						int kq;
						String so1 = jso1.getText();
						String so2 = jso2.getText();
						kq = Integer.parseInt(so1) * Integer.parseInt(so2);
						jketqua.setText("" + kq);
					}
				}

			}
		});

		chia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(chia)) {
					if (!jso1.getText().matches("\\d*") || !jso2.getText().matches("\\d*")) {
						JOptionPane.showMessageDialog(null, "Nhập số mới tính được bé ơi");
					} else {
						int kq;
						String so1 = jso1.getText();
						String so2 = jso2.getText();
						kq = Integer.parseInt(so1) / Integer.parseInt(so2);
						jketqua.setText("" + kq);
					}
				}

			}
		});
	}
}
