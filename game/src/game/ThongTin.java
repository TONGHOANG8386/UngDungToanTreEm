package game;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ThongTin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3930673062502200170L;
	JTextArea text;
	String ss = "";
	Scanner sc;
	public ThongTin() throws FileNotFoundException {
		setBounds(500, 200, 350, 350);
		setLayout(null);
		setResizable(false);
		setTitle("Thông tin trò chơi");
		
		JPanel panel = new JPanel();
		panel.setSize(350,350);
		panel.setLayout(new FlowLayout());
		text = new JTextArea(19,28);	
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		JScrollPane scoll = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scoll);
		
		File file = new File("doc.txt");
		try {
			sc = new Scanner(file);
			
			while (sc.hasNextLine()) {			
					ss  += sc.nextLine() ;
			}
			text.setText(ss);
		} catch (Exception e) {	
		}
		this.add(panel);
	}
}

