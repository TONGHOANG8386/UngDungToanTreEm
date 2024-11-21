package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CotTruyen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8393946846482744419L;
	Timer time1, time2;
	ImageIcon icon1, icon2, icon3;
	JLabel lct;

	public CotTruyen() {
		setBounds(250, 0, 900, 720);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Bé Học Toán");

		JPanel panel = new JPanel();
		panel.setSize(900, 720);
		panel.setLayout(null);
		panel.setVisible(true);

		icon1 = new ImageIcon("./images/trieudinha.jpg");
		icon2 = new ImageIcon("./images/haihoa.jpg");
		icon3 = new ImageIcon("./images/bibat.jpg");

		lct = new JLabel("");
		lct.setBounds(0, 0, 900, 700);
		lct.setIcon(icon1);
		panel.add(lct);

		time1 = new Timer(7000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lct.setIcon(icon2);
				time1.stop();
				time2 = new Timer(7000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						lct.setIcon(icon3);
						time2.stop();

					}
				});
				time2.start();
			}
		});
		time1.start();

		this.add(panel);
	}
}
