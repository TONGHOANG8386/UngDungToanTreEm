package game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DanhSachNguoiChoi {
	ArrayList<NguoiChoi> list;
	
	
	public DanhSachNguoiChoi() {
		this.list = new ArrayList<NguoiChoi>();
	}
	public boolean adduser(NguoiChoi user)
	{
		if(list.contains(user)) {
			JOptionPane.showInternalMessageDialog(null, this, "đã có user này", 0);
			return false;
		}
			
		else {
			list.add(user);			
			return true;
		}
	}
	public ArrayList<NguoiChoi> getList(){
		return list;
	}
}
