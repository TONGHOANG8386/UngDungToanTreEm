package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Timer;

import game.CotTruyen;
import game.DangNhap;
import javazoom.jl.player.Player;

public class MainGame {
	static Timer timecottruyen1,timecottruyen2;
	static Player player;
	public static void main(String[] args) throws IOException {
		CotTruyen ct = new CotTruyen();

		timecottruyen1 = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ct.setVisible(true);
				timecottruyen1.stop();
				timecottruyen2 = new Timer(21000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						ct.setVisible(false);
						try {
							new DangNhap().setVisible(true);
						} catch (FileNotFoundException e) {

							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						timecottruyen2.stop();

					}
				});
				timecottruyen2.start();
			}
		});
		timecottruyen1.start();

		try {
			FileInputStream file = new FileInputStream("./sound/Nentrong.mp3");
			player = new Player(file);
			player.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
