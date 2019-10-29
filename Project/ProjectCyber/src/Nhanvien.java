
import java.util.LinkedList;

public abstract class Nhanvien implements Nhapxuat, Comparable<Nhanvien> {

	protected String maNV;
	protected String tenNV;
	protected int namSinh;
	protected String email;
	protected String soDT;
	protected String maPB;
	protected LinkedList<String> dsNhiemVu;
	protected int soNV;
	protected float luong;
	protected float gioLam;
	protected float soGioTask;


	public float getSoGioTask() {
		return soGioTask;
	}

	public void setSoGioTask(float soGioTask) {
		this.soGioTask = soGioTask;
	}

	public int getSoNV() {
		return soNV;
	}

	public void setSoNV(int soNV) {
		this.soNV = soNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public float getGioLam() {
		return gioLam;
	}

	public void setGioLam(float gioLam) {
		this.gioLam = gioLam;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public LinkedList<String> getDsNhiemVu() {
		return dsNhiemVu;
	}

	@Override
	public void Nhap() {

	}

	public void setDsNhiemVu(LinkedList<String> dsNhiemVu) {
		this.dsNhiemVu = dsNhiemVu;
	}

	public Nhanvien(String maNV, String tenNV, int namSinh, String email, String soDT, String maPB) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDT = soDT;
		this.maPB = maPB;
	}

	public int compareTo(Nhanvien m) {
		return m.soNV - this.soNV;
	}

	@Override
	public void Xuat() {
		System.out.println(" |Ma nhan vien: " + this.getMaNV() + " | Ma Phong Ban: " + this.getMaPB()
				+ " | Ten nhan vien: " + this.getTenNV() + " | Nam sinh: " + this.getNamSinh() + " | Email: "
				+ this.getEmail() + " | So Dien Thoai: " + this.getSoDT());
		System.out.println();
		String tmp = "";
		tmp += " |Ma nhiem vu: ";
		for (String nhiemvu : this.getDsNhiemVu()) {

			tmp += nhiemvu;
			tmp += "-->|";
		}
		System.out.println(tmp);
	}
	public abstract void tinhLuong();

	public void Xuat1() {
		System.out.print(" |Ma nhan vien: " + this.getMaNV() + " | Ma Phong Ban: " + this.getMaPB()
				+ " | Ten nhan vien: " + this.getTenNV() + " | Nam sinh: " + this.getNamSinh());
		String tmp = "";
		tmp += " |Ma nhiem vu: ";
		for (String nhiemvu : this.getDsNhiemVu()) {

			tmp += nhiemvu;
			tmp += "-->|";
		}
		System.out.println(tmp);
		System.out.println();
	}
}