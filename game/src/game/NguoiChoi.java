package game;

public class NguoiChoi {
	private String ten;
	private String tuoi;
	private String diem;
	
	public NguoiChoi() {
		super();
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	public NguoiChoi(String ten, String tuoi, String diem) {
		super();
		this.ten = ten;
		this.tuoi = tuoi;
		this.diem = diem;
	}

	@Override
	public String toString() {
		return ten + ";" + tuoi + ";" + diem;
	}

}
