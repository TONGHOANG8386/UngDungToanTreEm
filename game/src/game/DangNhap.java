package game;

import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javazoom.jl.player.Player;
import java.util.ArrayList;
import java.util.Random;

public class DangNhap extends JFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = -5129002028608982890L;
	static Player player;
	int i = 0, ch = 1, x = 155, y = 550, j = 1, x1, socau = 0;
	int ketqua, dem = 0;
	static boolean flag = false;
	int d = 0, count = 30;
	JLabel dau, phaohoa, phaohoa1, quaivat, quaivat1;
	JLabel sodapso, sodapso1, sosodu1, so1, so2, sosodu, so11, dau1, so21, ketthuc;
	Form form;
	ThongTin thongtin;
	JLabel sothoigian, sothoigian1, sodiem1, cauhoitt1, matbuon, matbuon1, lbxephang;
	static JLabel cottruyen;
	Timer time, timephaohoa, timephaohoa2, timehiepsi, timeketthuc, timeketthuc1;
	static Timer timecottruyen1;
	static Timer timecottruyen2;
	JLabel cauhoitt, sodiem, hiepsi, hiepsi1;
	JButton dapan1, dapan2, dapan3;
	JTextField jtendangnhap, jtuoidangnhap;
	ImageIcon iconphaohoa, iconhiepsi, iconquaivat, iconquaivat1, iconcongchua, iconmatbuon, icondaibang, iconxephang,
			iconbangdiem, iconketthuc;
	JTable table;
	DefaultTableModel model;
	static ImageIcon iconcottruyen2;
	static ImageIcon iconcottruyen3;
	static ImageIcon iconcottruyen1;
	static JPanel paneldangnhap;
	JPanel panelketthuc, panel1, panel;
	DanhSachNguoiChoi dao = new DanhSachNguoiChoi();

	public DangNhap() throws IOException {
		setBounds(250, 0, 900, 720);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Bé Học Toán");

		paneldangnhap = new JPanel();
		paneldangnhap.setSize(900, 720);
		paneldangnhap.setVisible(true);
		paneldangnhap.setLayout(null);

		panel = new JPanel();
		panel.setSize(900, 720);
		panel.setLayout(null);
		panel.setVisible(false);

		Font chu = new Font("arial", Font.CENTER_BASELINE, 10);

		jtendangnhap = new JTextField();
		jtendangnhap.setBounds(435, 320, 170, 30);
		paneldangnhap.add(jtendangnhap);

		jtuoidangnhap = new JTextField();
		jtuoidangnhap.setBounds(435, 375, 170, 30);
		paneldangnhap.add(jtuoidangnhap);

		JButton choi = new JButton("TỰ LUẬN");
		choi.setBounds(370, 440, 110, 40);
		choi.setFont(chu);
		choi.setBackground(Color.yellow);
		paneldangnhap.add(choi);

		JButton tracnghiem = new JButton("TRẮC NGHIỆM");
		tracnghiem.setBounds(490, 440, 110, 40);
		tracnghiem.setFont(chu);
		tracnghiem.setBackground(Color.yellow);
		paneldangnhap.add(tracnghiem);

		JButton thoat = new JButton("Thoát");
		thoat.setForeground(Color.white);
		thoat.setBounds(550, 540, 110, 40);
		thoat.setBackground(Color.gray);
		paneldangnhap.add(thoat);

		JButton tt = new JButton("Thông tin");
		tt.setBounds(430, 540, 110, 40);
		tt.setBackground(Color.gray);
		tt.setForeground(Color.white);
		paneldangnhap.add(tt);

		Font fontchung = new Font("arial", Font.BOLD, 20);
		Font so = new Font("arial", Font.BOLD, 50);
		Font button = new Font("arial", Font.CENTER_BASELINE, 16);

		JPanel xephang = new JPanel();
		xephang.setSize(900, 720);
		xephang.setVisible(false);
		xephang.setLayout(null);

		String[] col = { "", "", "" };
		model = new DefaultTableModel(col, 0);
		table = new JTable(model);
		table.getSelectionBackground().getRed();
		table.setBackground(Color.white);
		table.setRowHeight(50);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 170, 900, 520);
		xephang.add(sp);

		JButton btnxephang = new JButton("Bảng điểm");
		btnxephang.setForeground(Color.white);
		btnxephang.setBounds(310, 540, 110, 40);
		btnxephang.setBackground(Color.gray);
		paneldangnhap.add(btnxephang);

		JButton backxephang = new JButton("Quay lại");
		backxephang.setFont(button);
		backxephang.setBackground(Color.gray);
		backxephang.setBounds(750, 100, 110, 30);
		xephang.add(backxephang);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel cauhoi = new JLabel("Câu Hỏi:");
		cauhoi.setBounds(20, 150, 120, 30);
		cauhoi.setFont(fontchung);
		panel.add(cauhoi);

		cauhoitt = new JLabel("1");
		cauhoitt.setBounds(105, 150, 50, 30);
		cauhoitt.setFont(fontchung);
		panel.add(cauhoitt);

		so1 = new JLabel("?");
		so1.setFont(so);
		so1.setForeground(Color.black);
		so1.setBounds(310, 240, 70, 70);
		panel.add(so1);

		dau = new JLabel("?");
		dau.setFont(so);
		dau.setForeground(Color.black);
		dau.setBounds(380, 240, 70, 70);
		panel.add(dau);

		so2 = new JLabel("?");
		so2.setFont(so);
		so2.setForeground(Color.black);
		so2.setBounds(450, 240, 70, 70);
		panel.add(so2);

		JLabel dau2 = new JLabel("=");
		dau2.setFont(so);
		dau2.setForeground(Color.black);
		dau2.setBounds(520, 240, 70, 70);
		panel.add(dau2);

		JLabel dau3 = new JLabel("....");
		dau3.setFont(so);
		dau3.setForeground(Color.black);
		dau3.setBounds(550, 240, 70, 70);
		panel.add(dau3);

		JButton choi2 = new JButton("Trả Lời");
		choi2.setBounds(725, 440, 110, 30);
		choi2.setBackground(Color.red);
		choi2.setForeground(Color.yellow);
		choi2.setFont(button);
		panel.add(choi2);

		JTextField traloi = new JTextField();
		traloi.setBounds(350, 420, 120, 60);
		Font tl = new Font("arial", Font.BOLD, 40);
		traloi.setFont(tl);
		panel.add(traloi);

		Font thoigian = new Font("Arial", Font.BOLD, 100);
		sothoigian = new JLabel("30");
		sothoigian.setFont(thoigian);
		sothoigian.setBounds(770, 550, 180, 100);
		panel.add(sothoigian);

		JLabel dapso = new JLabel("Đáp Số:");
		dapso.setFont(fontchung);
		dapso.setBounds(20, 215, 120, 40);
		panel.add(dapso);

		sodapso = new JLabel("0");
		sodapso.setFont(fontchung);
		sodapso.setForeground(Color.red);
		sodapso.setBounds(105, 215, 120, 40);
		panel.add(sodapso);

		JButton back = new JButton("Quay lại");
		back.setFont(button);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.gray);
		back.setBounds(770, 120, 110, 30);
		panel.add(back);

		JLabel ten = new JLabel("Bé :");
		ten.setBounds(20, 250, 120, 40);
		ten.setFont(fontchung);
		panel.add(ten);

		JLabel tennv = new JLabel("");
		tennv.setBounds(75, 255, 200, 30);
		tennv.setForeground(Color.red);
		tennv.setFont(fontchung);
		panel.add(tennv);

		JLabel tuoi = new JLabel("Tuổi:");
		tuoi.setBounds(20, 290, 120, 30);
		tuoi.setFont(fontchung);
		panel.add(tuoi);

		JLabel sotuoi = new JLabel("0");
		sotuoi.setBounds(105, 290, 50, 30);
		sotuoi.setForeground(Color.red);
		sotuoi.setFont(fontchung);
		panel.add(sotuoi);

		JLabel diem = new JLabel("Điểm:");
		diem.setFont(fontchung);
		diem.setBounds(20, 180, 120, 40);
		panel.add(diem);

		sodiem = new JLabel("0");
		sodiem.setFont(fontchung);
		sodiem.setForeground(Color.red);
		sodiem.setBounds(105, 180, 60, 40);
		panel.add(sodiem);

		JButton giup = new JButton("Trợ Giúp");
		giup.setFont(button);
		giup.setBackground(Color.cyan);
		giup.setForeground(Color.WHITE);
		giup.setBounds(500, 490, 120, 30);
		panel.add(giup);

		JButton doi = new JButton("Đổi câu hỏi");
		doi.setFont(button);
		doi.setBounds(490, 440, 120, 30);
		doi.setBackground(Color.cyan);
		doi.setForeground(Color.WHITE);
		panel.add(doi);

		JButton batdau = new JButton("Bắt đầu");
		batdau.setFont(button);
		batdau.setBounds(725, 360, 120, 30);
		batdau.setBackground(Color.red);
		batdau.setForeground(Color.yellow);
		panel.add(batdau);

		JLabel sodu = new JLabel("Số Dư:");
		sodu.setFont(fontchung);
		sodu.setForeground(Color.BLACK);
		sodu.setBounds(350, 485, 120, 40);
		panel.add(sodu);

		form = new Form();
		thongtin = new ThongTin();

		sosodu = new JLabel("0");
		sosodu.setFont(fontchung);
		sosodu.setForeground(Color.BLACK);
		sosodu.setBounds(430, 485, 60, 40);
		panel.add(sosodu);

		iconphaohoa = new ImageIcon("./images/phaohoa.gif");
		iconhiepsi = new ImageIcon("./images/hiepsi.gif");
		iconcongchua = new ImageIcon("./images/congchua.gif");

		iconquaivat = new ImageIcon("./images/rong.gif");
		iconquaivat1 = new ImageIcon("./images/rong1.gif");
		icondaibang = new ImageIcon("./images/daibang.gif");

		phaohoa = new JLabel("");
		phaohoa.setBounds(20, 320, 200, 200);
		panel.add(phaohoa);

		hiepsi = new JLabel("");
		hiepsi.setBounds(175, 550, 100, 100);
		hiepsi.setIcon(iconhiepsi);
		panel.add(hiepsi);

		quaivat = new JLabel("");
		quaivat.setBounds(620, 470, 150, 300);
		quaivat.setIcon(iconquaivat);
		panel.add(quaivat);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		panel1 = new JPanel();
		panel1.setSize(900, 720);
		panel1.setLayout(null);
		panel1.setVisible(false);

		JLabel ten1 = new JLabel("Bé :");
		ten1.setBounds(20, 250, 120, 40);
		ten1.setFont(fontchung);
		panel1.add(ten1);

		JLabel tennv1 = new JLabel("1");
		tennv1.setBounds(75, 255, 200, 30);
		tennv1.setForeground(Color.red);
		tennv1.setFont(fontchung);
		panel1.add(tennv1);

		JLabel cauhoi1 = new JLabel("Câu Hỏi:");
		cauhoi1.setBounds(20, 150, 120, 30);
		cauhoi1.setFont(fontchung);
		panel1.add(cauhoi1);

		cauhoitt1 = new JLabel("1");
		cauhoitt1.setBounds(105, 150, 50, 30);
		cauhoitt1.setFont(fontchung);
		panel1.add(cauhoitt1);

		JLabel tuoi1 = new JLabel("Tuổi:");
		tuoi1.setBounds(20, 290, 120, 30);
		tuoi1.setFont(fontchung);
		panel1.add(tuoi1);

		JLabel sotuoi1 = new JLabel("0");
		sotuoi1.setBounds(105, 290, 50, 30);
		sotuoi1.setForeground(Color.red);
		sotuoi1.setFont(fontchung);
		panel1.add(sotuoi1);

		so11 = new JLabel("?");
		so11.setFont(so);
		so11.setForeground(Color.black);
		so11.setBounds(310, 240, 70, 70);
		panel1.add(so11);

		dau1 = new JLabel("?");
		dau1.setFont(so);
		dau1.setForeground(Color.black);
		dau1.setBounds(380, 240, 70, 70);
		panel1.add(dau1);

		so21 = new JLabel("?");
		so21.setFont(so);
		so21.setForeground(Color.black);
		so21.setBounds(450, 240, 70, 70);
		panel1.add(so21);

		JLabel dau21 = new JLabel("=");
		dau21.setFont(so);
		dau21.setForeground(Color.black);
		dau21.setBounds(520, 240, 70, 70);
		panel1.add(dau21);

		JLabel dau31 = new JLabel("....");
		dau31.setFont(so);
		dau31.setForeground(Color.black);
		dau31.setBounds(550, 240, 70, 70);
		panel1.add(dau31);

		sothoigian1 = new JLabel("30");
		sothoigian1.setFont(thoigian);
		sothoigian1.setBounds(770, 550, 180, 100);
		panel1.add(sothoigian1);

		JLabel dapso1 = new JLabel("Đáp Số:");
		dapso1.setFont(fontchung);
		dapso1.setBounds(20, 215, 120, 40);
		panel1.add(dapso1);

		sodapso1 = new JLabel("0");
		sodapso1.setFont(fontchung);
		sodapso1.setForeground(Color.red);
		sodapso1.setBounds(105, 215, 120, 40);
		panel1.add(sodapso1);

		JLabel diem1 = new JLabel("Điểm:");
		diem1.setFont(fontchung);
		diem1.setBounds(20, 180, 120, 40);
		panel1.add(diem1);

		sodiem1 = new JLabel("0");
		sodiem1.setFont(fontchung);
		sodiem1.setForeground(Color.red);
		sodiem1.setBounds(105, 180, 60, 40);
		panel1.add(sodiem1);

		JButton giup1 = new JButton("Trợ Giúp");
		giup1.setFont(button);
		giup1.setBounds(725, 360, 120, 30);
		giup1.setBackground(Color.cyan);
		giup1.setForeground(Color.WHITE);
		panel1.add(giup1);

		JButton doi1 = new JButton("Đổi câu hỏi");
		doi1.setFont(button);
		doi1.setBounds(725, 440, 120, 30);
		doi1.setBackground(Color.cyan);
		doi1.setForeground(Color.WHITE);
		panel1.add(doi1);

		JButton batdau1 = new JButton("Bắt đầu");
		batdau1.setFont(button);
		batdau1.setBounds(500, 490, 120, 30);
		batdau1.setBackground(Color.cyan);
		batdau1.setForeground(Color.WHITE);
		panel1.add(batdau1);

		dapan1 = new JButton("?");
		dapan1.setFont(fontchung);
		dapan1.setBounds(330, 430, 80, 30);
		dapan1.setBackground(Color.white);
		dapan1.setForeground(Color.blue);
		panel1.add(dapan1);

		dapan2 = new JButton("?");
		dapan2.setFont(fontchung);
		dapan2.setBounds(425, 430, 80, 30);
		dapan2.setBackground(Color.white);
		dapan2.setForeground(Color.blue);
		panel1.add(dapan2);

		dapan3 = new JButton("?");
		dapan3.setFont(fontchung);
		dapan3.setBounds(520, 430, 80, 30);
		dapan3.setBackground(Color.white);
		dapan3.setForeground(Color.blue);
		panel1.add(dapan3);

		JLabel sodu1 = new JLabel("Số Dư:");
		sodu1.setFont(fontchung);
		sodu1.setForeground(Color.black);
		sodu1.setBounds(350, 485, 120, 40);
		panel1.add(sodu1);

		sosodu1 = new JLabel("0");
		sosodu1.setFont(fontchung);
		sosodu1.setForeground(Color.black);
		sosodu1.setBounds(430, 485, 60, 40);
		panel1.add(sosodu1);

		JButton back1 = new JButton("Quay lại");
		back1.setFont(button);
		back1.setForeground(Color.WHITE);
		back1.setBackground(Color.gray);
		back1.setBounds(770, 120, 110, 30);
		panel1.add(back1);

		hiepsi1 = new JLabel("");
		hiepsi1.setBounds(175, 550, 100, 100);
		hiepsi1.setIcon(iconhiepsi);
		panel1.add(hiepsi1);

		quaivat1 = new JLabel("");
		quaivat1.setBounds(620, 470, 150, 300);
		quaivat1.setIcon(iconquaivat);
		panel1.add(quaivat1);

		phaohoa1 = new JLabel("");
		phaohoa1.setBounds(20, 320, 200, 200);
		panel1.add(phaohoa1);

		ImageIcon icon = new ImageIcon("./images/dangnhap.jpg");
		JLabel lbicon = new JLabel();
		lbicon.setBounds(0, 0, 900, 700);
		lbicon.setIcon(icon);
		paneldangnhap.add(lbicon);

		iconxephang = new ImageIcon("./images/xephang.gif");
		lbxephang = new JLabel("");
		lbxephang.setBounds(0, 0, 900, 700);
		lbxephang.setIcon(iconxephang);
		xephang.add(lbxephang);

		ImageIcon icon2 = new ImageIcon("./images/aaaa.jpg");
		JLabel lbicon2 = new JLabel();
		JLabel lbicon3 = new JLabel();
		lbicon2.setBounds(0, 0, 900, 700);
		lbicon2.setIcon(icon2);
		lbicon3.setIcon(icon2);
		lbicon3.setBounds(0, 0, 900, 700);
		panel.add(lbicon2);
		panel1.add(lbicon3);

		iconbangdiem = new ImageIcon("./images/diem.jpg");

		JLabel nendiem = new JLabel("");
		nendiem.setBounds(0, 0, 900, 700);
		nendiem.setIcon(iconbangdiem);
		xephang.add(nendiem);

		iconketthuc = new ImageIcon("./images/cuu.jpg");

		panelketthuc = new JPanel();
		panelketthuc.setSize(900, 720);
		panelketthuc.setLayout(null);

		ketthuc = new JLabel("");
		ketthuc.setBounds(0, 0, 900, 700);
		panelketthuc.add(ketthuc);

/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
		LoadDatabase();

		this.add(panel1);
		this.add(paneldangnhap);
		this.add(panel);
		this.add(xephang);
		this.add(panelketthuc);
		tt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thongtin.setVisible(true);

			}
		});
		choi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtendangnhap.getText().equals("") || jtuoidangnhap.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bé hãy nhập thông tin đầy đủ");
				} else if (!jtuoidangnhap.getText().matches("\\d*")) {
					JOptionPane.showMessageDialog(null, "Tuổi phải nhận số nha Bé");
				} else if (Integer.parseInt(jtuoidangnhap.getText()) < 5
						|| Integer.parseInt(jtuoidangnhap.getText()) > 15) {
					JOptionPane.showMessageDialog(null, "Trò chơi chỉ dành cho Bé từ 5 đến 15 tuổi");
				}

				else if (jtendangnhap.getText().matches("\\d*")) {
					JOptionPane.showMessageDialog(null, "Tên phải nhập chữ nha Bé");
				} else if (e.getSource().equals(choi)) {
					paneldangnhap.setVisible(false);
					panel.setVisible(true);
					hiepsi.setBounds(155, 550, 100, 100);
					quaivat.setBounds(620, 470, 150, 300);
					quaivat.setIcon(iconquaivat);
					sothoigian.setText("30");
					tennv.setText("");
					sotuoi.setText("");
					cauhoitt.setText("1");
					sodiem.setText("0");
					sodapso.setText("0");
					so1.setText("?");
					dau.setText("?");
					so2.setText("?");
					sosodu.setText("0");
					sothoigian.setForeground(Color.BLACK);

				}
			}
		});

		choi2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!traloi.getText().matches("\\d*")) {
					JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!");
				} else if (traloi.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đáp án");
				} else if (e.getSource().equals(choi2)) {
					if (j <= 1 && flag == true) {
						String text = traloi.getText();
						sodapso.setText("" + ketqua);
						if (text.equals("" + ketqua)) {
							phaohoa();
							socau++;
							quaivat();
							khen("./sound/ring.mp3");
							d += 10;
							ch++;
							hiepsichay();
							sosodu.setText("0");
							random();
							sodiem.setText("" + d);
							cauhoitt.setText("" + ch);
							traloi.setText("");
							time.stop();
							runtime();
						} else {
							flag = false;
							j++;
							i = 0;
							d = 0;
							ch = 1;
							x = 155;
							y = 550;
							khen("./sound/ohno.mp3");
							time.stop();
							JOptionPane.showMessageDialog(null,
									"Chúc mừng Bé " + jtendangnhap.getText() + " đã hoàn thành "
											+ (Integer.parseInt(cauhoitt.getText()) - 1) + " câu và đạt được "
											+ sodiem.getText() + " điểm cố gắng nữa lên nha bé!");
							themuser();
							ghifile(dao.getList());

						}
					} else if (j > 1 || flag == false) {
						JOptionPane.showMessageDialog(null, "Hãy bắt đầu trò chơi");
					}
				}
			}
		});
		doi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(doi))
					if (j <= 1 && flag == true) {
						dem++;
						if (dem < 4) {
							sosodu.setText("0");
							sodapso.setText("0");
							random();
							time.stop();
							runtime();
						} else {
							JOptionPane.showMessageDialog(null, "Chỉ được đổi 3 lần thôi bé ơi");
						}
					} else if (j > 1 || flag == false) {
						JOptionPane.showMessageDialog(null, "Bé hãy bắt đầu trò chơi.");
					}
			}
		});
		giup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				form.setVisible(true);
			}
		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(back)) {

					panel.setVisible(false);
					paneldangnhap.setVisible(true);
					i = 0;
					timehiepsi.stop();
					quaivat.setIcon(iconquaivat);
					quaivat.setBounds(620, 470, 150, 300);
					x = 155;
					y = 550;
					time.stop();
					flag = false;
					sothoigian.setText("00");
					tennv.setText("");
					sotuoi.setText("");
					cauhoitt.setText("1");
					sodiem.setText("0");
					sodapso.setText("0");
					so1.setText("?");
					dau.setText("?");
					so2.setText("?");
					sosodu.setText("0");
				}
			}
		});
		batdau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource().equals(batdau)) {
					i++;
					if (i >= 2) {
						JOptionPane.showMessageDialog(null, "Trả lời câu nào.");
					} else {
						j = 1;
						quaivat.setBounds(620, 470, 150, 300);
						quaivat.setIcon(iconquaivat);
						dem = 0;
						d = 0;
						ch = 1;
						socau = 0;
						hiepsi.setBounds(155, 550, 100, 100);
						sothoigian.setText("30");
						String c = jtendangnhap.getText();
						tennv.setText(c);
						String t = jtuoidangnhap.getText();
						sotuoi.setText(t);
						traloi.setText("");
						cauhoitt.setText("1");
						sodiem.setText("0");
						sodapso.setText("0");
						sosodu.setText("0");
						random();
						runtime();
						count = 30;
						flag = true;

					}
				}
			}
		});

		btnxephang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnxephang)) {
					paneldangnhap.setVisible(false);
					xephang.setVisible(true);
				}
			}
		});

		backxephang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(backxephang)) {
					xephang.setVisible(false);
					paneldangnhap.setVisible(true);

				}
			}
		});
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		tracnghiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtendangnhap.getText().equals("") || jtuoidangnhap.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bé hãy nhập thông tin đầy đủ");
				} else if (!jtuoidangnhap.getText().matches("\\d*")) {
					JOptionPane.showMessageDialog(null, "Tuổi phải nhận số nha Bé");
				} else if (Integer.parseInt(jtuoidangnhap.getText()) < 5
						|| Integer.parseInt(jtuoidangnhap.getText()) > 15) {
					JOptionPane.showMessageDialog(null, "Trò chơi chỉ dành cho Bé từ 5 đến 15 tuổi");
				}

				else if (jtendangnhap.getText().matches("\\d*")) {
					JOptionPane.showMessageDialog(null, "Tên phải nhập chữ nha Bé");
				} else if (e.getSource().equals(tracnghiem)) {
					paneldangnhap.setVisible(false);
					panel1.setVisible(true);
					hiepsi1.setBounds(155, 550, 100, 100);
					quaivat1.setBounds(620, 470, 150, 300);
					quaivat1.setIcon(iconquaivat);
					sothoigian1.setText("30");
					tennv1.setText("");
					sotuoi1.setText("");
					cauhoitt1.setText("1");
					sodiem1.setText("0");
					sodapso1.setText("0");
					so11.setText("?");
					dau1.setText("?");
					so21.setText("?");
					sosodu1.setText("0");
					sothoigian1.setForeground(Color.BLACK);

					j = 1;
				}
			}
		});
		dapan1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(dapan1)) {
					if (j <= 1 && flag == true) {
						if (dapan1.getText().equals("" + ketqua)) {
							sodapso1.setText("" + ketqua);
							socau++;
							d += 10;
							quaivat();
							ch++;
							hiepsichay();
							phaohoa();
							khen("./sound/ring.mp3");
							sosodu1.setText("0");
							random();
							randomtracnghiem();
							sodiem1.setText("" + d);
							cauhoitt1.setText("" + ch);
							time.stop();
							runtime();
						} else {
							khen("./sound/ohno.mp3");
							flag = false;
							j++;
							i = 0;
							d = 0;
							ch = 1;
							x = 155;
							y = 550;
							time.stop();
							JOptionPane.showMessageDialog(null,
									"Chúc mừng Bé " + jtendangnhap.getText() + " đã hoàn thành "
											+ (Integer.parseInt(cauhoitt1.getText()) - 1) + " câu và đạt được "
											+ sodiem1.getText() + " điểm cố gắng nữa lên nha bé!");
							themuser1();
							ghifile(dao.getList());
						}
					} else if (j > 1 || flag == false) {
						JOptionPane.showMessageDialog(null, "Hãy bắt đầu trò chơi");
					}
				}
			}
		});

		dapan2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(dapan2)) {
					if (j <= 1 && flag == true) {
						if (dapan2.getText().equals("" + ketqua)) {
							sodapso1.setText("" + ketqua);
							socau++;
							d += 10;
							quaivat();
							ch++;
							hiepsichay();
							phaohoa();
							khen("./sound/ring.mp3");
							sosodu1.setText("0");
							random();
							randomtracnghiem();
							sodiem1.setText("" + d);
							cauhoitt1.setText("" + ch);
							time.stop();
							runtime();
						} else {
							khen("./sound/ohno.mp3");
							flag = false;
							j++;
							i = 0;
							d = 0;
							ch = 1;
							x = 155;
							y = 550;
							time.stop();
							JOptionPane.showMessageDialog(null,
									"Chúc mừng Bé " + jtendangnhap.getText() + " đã hoàn thành "
											+ (Integer.parseInt(cauhoitt1.getText()) - 1) + " câu và đạt được "
											+ sodiem1.getText() + " điểm cố gắng nữa lên nha bé!");
							themuser1();
							ghifile(dao.getList());
						}
					} else if (j > 1 || flag == false) {
						JOptionPane.showMessageDialog(null, "Hãy bắt đầu trò chơi");
					}
				}

			}
		});
		dapan3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(dapan3)) {
					if (j <= 1 && flag == true) {
						if (dapan3.getText().equals("" + ketqua)) {
							sodapso1.setText("" + ketqua);
							d += 10;
							quaivat();
							ch++;
							socau++;
							hiepsichay();
							phaohoa();
							khen("./sound/ring.mp3");
							sosodu1.setText("0");
							random();
							randomtracnghiem();
							sodiem1.setText("" + d);
							cauhoitt1.setText("" + ch);
							time.stop();
							runtime();
						} else {
							khen("./sound/ohno.mp3");
							flag = false;
							j++;
							i = 0;
							d = 0;
							ch = 1;
							x = 155;
							y = 550;
							time.stop();
							JOptionPane.showMessageDialog(null,
									"Chúc mừng Bé " + jtendangnhap.getText() + " đã hoàn thành "
											+ (Integer.parseInt(cauhoitt1.getText()) - 1) + " câu và đạt được "
											+ sodiem1.getText() + " điểm cố gắng nữa lên nha bé!");
							themuser1();
							ghifile(dao.getList());
						}
					} else if (j > 1 || flag == false) {
						JOptionPane.showMessageDialog(null, "Hãy bắt đầu trò chơi");
					}
				}
			}
		});
		doi1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(doi1)) {
					if (j <= 1 && flag == true) {
						dem++;
						if (dem < 4) {
							sosodu1.setText("0");
							sodapso1.setText("0");
							random();
							time.stop();
							runtime();
							randomtracnghiem();
						} else {
							JOptionPane.showMessageDialog(null, "Chỉ được đổi 3 lần thôi bé ơi");
						}
					} else if (j > 1 || flag == false) {
						JOptionPane.showMessageDialog(null, "Hãy bắt đầu trò chơi");
					}
				}
			}
		});
		giup1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				form.setVisible(true);
			}
		});
		back1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(back1)) {
					panel1.setVisible(false);
					paneldangnhap.setVisible(true);
					i = 0;
					d = 0;
					ch = 1;
					flag = false;
					time.stop();
					sothoigian1.setText("00");
					tennv1.setText("");
					sotuoi1.setText("");
					cauhoitt1.setText("1");
					sodiem1.setText("0");
					sodapso1.setText("0");
					so11.setText("?");
					dau1.setText("?");
					so21.setText("?");
					sosodu1.setText("0");
				}
			}
		});
		thoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(thoat)) {
					System.exit(0);
				}

			}
		});
		batdau1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource().equals(batdau1)) {
					i++;
					if (i >= 2) {
						JOptionPane.showMessageDialog(null, "Trả lời câu hỏi nào.");
					} else {
						flag = true;
						j = 1;
						quaivat1.setBounds(620, 470, 150, 300);
						quaivat1.setIcon(iconquaivat);
						dem = 0;
						d = 0;
						ch = 1;
						x = 155;
						y = 550;
						socau = 0;
						hiepsi1.setBounds(155, 550, 100, 100);
						sothoigian1.setText("30");
						String c = jtendangnhap.getText();
						tennv1.setText(c);
						String t = jtuoidangnhap.getText();
						sotuoi1.setText(t);
						cauhoitt1.setText("1");
						sodiem1.setText("0");
						sodapso1.setText("0");
						sosodu1.setText("0");
						random();
						randomtracnghiem();
						runtime();
						count = 30;
					}
				}

			}
		});
	}

	// xu ly khi ket thuc game
	public void ketthuc() {
		timeketthuc = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				time.stop();
				panel.setVisible(false);
				panel1.setVisible(false);
				panelketthuc.setVisible(true);
				ketthuc.setIcon(iconketthuc);
				timeketthuc.stop();
				timeketthuc1 = new Timer(6000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						panelketthuc.setVisible(false);
						paneldangnhap.setVisible(true);
						timeketthuc1.stop();
					}
				});
				timeketthuc1.start();
			}
		});
		timeketthuc.start();
	}

	// lay du lieu tu database
	public void LoadDatabase() {
		BufferedReader br = null;
		NguoiChoi nc = null;
		String[] a = null;
		dao = new DanhSachNguoiChoi();// khởi động danh sách
		try {
			if (new File("./file/ghifile.txt").exists()) {
				br = new BufferedReader(new FileReader("./file/ghifile.txt"));

				while (br.ready()) {
					String line = br.readLine();
					if (line != null && !line.trim().equals("")) {

						a = line.split(";");

						int A = Integer.parseInt(a[2]);
						nc = new NguoiChoi(a[0], a[1], a[2]);
						if (Integer.parseInt(nc.getDiem()) >= A) {
							dao.adduser(nc);
							model.addRow(a);
						}
						// đưa vào danh mục
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	// Ghi nguoi choi vao file
	public void ghifile(ArrayList<NguoiChoi> dsnv) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("./file/ghifile.txt"));
			// ghi lần lượt từng cuốn sách cho đến khi hêt
			for (NguoiChoi nc : dsnv) {
				bw.write(nc.toString() + "\n");
			}
			bw.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Them nguoi choi vao bang va danh sach nguoi choi
	public void themuser() {
		try {
			String ten = jtendangnhap.getText();
			String tuoi = jtuoidangnhap.getText();
			String diem = sodiem.getText();

			NguoiChoi nc = new NguoiChoi(ten, tuoi, diem);
			if (dao.adduser(nc)) {
				String[] row = { ten, tuoi, diem };
				model.addRow(row);
			} else {
				JOptionPane.showMessageDialog(null, "Trùng người chơi. ");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu.");
			return;
		}
	}

	public void themuser1() {
		try {
			String ten = jtendangnhap.getText();
			String tuoi = jtuoidangnhap.getText();
			String diem = sodiem1.getText();

			NguoiChoi nc = new NguoiChoi(ten, tuoi, diem);
			if (dao.adduser(nc)) {
				String[] row = { ten, tuoi, diem };
				model.addRow(row);
			} else {
				JOptionPane.showMessageDialog(null, "Trùng người chơi. ");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu.");
			return;
		}
	}

	public void quaivat() {
		if (ch == 10) {
			quaivat.setBounds(620, 470, 150, 300);
			quaivat1.setBounds(620, 470, 150, 300);
			quaivat.setIcon(icondaibang);
			quaivat1.setIcon(icondaibang);

		} else if (ch == 20) {
			quaivat.setBounds(600, 550, 100, 100);
			quaivat1.setBounds(600, 550, 100, 100);
			quaivat.setIcon(iconcongchua);
			quaivat1.setIcon(iconcongchua);
		} else if (ch == 29) {
			themuser();
			ghifile(dao.getList());
			ketthuc();
		}

	}

	public void hiepsichay() {
		x1 = 0;
		if (socau >= 10) {
			hiepsi.setBounds(155, 550, 100, 100);
			hiepsi1.setBounds(155, 550, 100, 100);
			x = 155;
			socau = 0;
		} else {
			timehiepsi = new Timer(10, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (x1 <= 44) {
						x++;
						x1++;
						hiepsi.setBounds(x, y, 100, 100);
						hiepsi1.setBounds(x, y, 100, 100);
					} else {
						timehiepsi.stop();
					}
				}
			});
			timehiepsi.start();
		}
	}

	public void phaohoa() {
		timephaohoa = new Timer(1500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				phaohoa.setSize(150, 200);
				phaohoa1.setSize(200, 200);
				phaohoa.setIcon(iconphaohoa);
				phaohoa1.setIcon(iconphaohoa);
				timephaohoa.stop();
				timephaohoa2 = new Timer(1500, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						phaohoa.setSize(0, 0);
						phaohoa1.setSize(0, 0);
						timephaohoa2.stop();
					}
				});
				timephaohoa2.start();
			}
		});
		timephaohoa.start();
	}

	public void runtime() {
		if (flag == true && count <= 37) {
			count += 3;
		}
		sothoigian.setForeground(Color.BLACK);
		sothoigian1.setForeground(Color.BLACK);
		time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				if (count == 0) {
					khen("./sound/ohno.mp3");
					j++;
					flag = false;
					time.stop();
					i = 0;
					d = 0;
					ch = 1;
					x = 155;
					y = 550;
					time.stop();
					JOptionPane.showMessageDialog(null,
							"Chúc mừng Bé " + jtendangnhap.getText() + " đã hoàn thành "
									+ (Integer.parseInt(cauhoitt.getText()) - 1) + " câu và đạt được "
									+ sodiem.getText() + " điểm cố gắng nữa lên nha bé!");
					themuser();
					themuser1();
					ghifile(dao.getList());
				} else if (count < 10) {
					sothoigian.setText("0" + count);
					sothoigian1.setText("0" + count);
					sothoigian.setForeground(Color.RED);
					sothoigian1.setForeground(Color.RED);
				} else {
					sothoigian.setText("" + count);
					sothoigian1.setText("" + count);
				}
			}
		});

		time.start();
	}

	public void random() {
		Random ra = new Random();
		int sord1, sord2, sord3, sord4, sord5;
		sord1 = ra.nextInt(20);
		sord2 = ra.nextInt(20);
		sord3 = ra.nextInt(4);
		sord4 = ra.nextInt(10);
		sord5 = ra.nextInt(10);

		if (sord1 == 0 || sord2 == 0) {
			random();
		} else if (sord4 == 0 || sord5 == 0) {
			random();
		} else {
			if (sord3 == 0) {
				so1.setText("" + sord1);
				so2.setText("" + sord2);
				so11.setText("" + sord1);
				so21.setText("" + sord2);
				dau.setText("+");
				dau1.setText("+");
				ketqua = sord1 + sord2;
			} else if (sord3 == 1) {
				so1.setText("" + sord4);
				so2.setText("" + sord5);
				so11.setText("" + sord4);
				so21.setText("" + sord5);
				dau.setText("x");
				dau1.setText("x");
				ketqua = sord4 * sord5;
			} else if (sord3 == 2) {
				if (sord1 < sord2) {
					random();
				} else {
					so1.setText("" + sord1);
					so2.setText("" + sord2);
					so11.setText("" + sord1);
					so21.setText("" + sord2);
					dau.setText("-");
					dau1.setText("-");
					ketqua = sord1 - sord2;
				}
			} else if (sord3 == 3) {

				if (sord4 < sord5) {
					random();
				} else {
					so1.setText("" + sord4);
					so2.setText("" + sord5);
					so11.setText("" + sord4);
					so21.setText("" + sord5);
					ketqua = sord4 / sord5;
					dau.setText(":");
					dau1.setText(":");
					int tam = 0;
					tam = sord4 % sord5;
					sosodu.setText("" + tam);
					sosodu1.setText("" + tam);
				}
			}
		}

	}

	public void randomtracnghiem() {
		Random ran = new Random();
		int sord1, sord2, sord3;
		sord1 = ran.nextInt(50);
		sord2 = ran.nextInt(50);
		sord3 = ran.nextInt(3);

		if (sord3 == 0) {
			if (sord1 == ketqua || sord2 == ketqua || sord1 == sord2) {
				randomtracnghiem();
			} else {
				dapan1.setText("" + ketqua);
				dapan2.setText("" + sord1);
				dapan3.setText("" + sord2);
			}

		} else if (sord3 == 1) {
			if (sord1 == ketqua || sord2 == ketqua || sord1 == sord2) {
				randomtracnghiem();
			} else {
				dapan2.setText("" + ketqua);
				dapan1.setText("" + sord1);
				dapan3.setText("" + sord2);
			}
		} else if (sord3 == 2) {
			if (sord1 == ketqua || sord2 == ketqua || sord1 == sord2) {
				randomtracnghiem();
			} else {
				dapan3.setText("" + ketqua);
				dapan2.setText("" + sord1);
				dapan1.setText("" + sord2);
			}
		}
	}

	public void khen(String files) {
		try {
			FileInputStream file = new FileInputStream(files);
			Player player = new Player(file);
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
