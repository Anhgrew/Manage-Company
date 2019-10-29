
import java.util.LinkedList;

public class Phongban implements Nhapxuat {
	private String maPB;
	private String tenPB;
	private LinkedList<Nhanvien> dsNV;

	public String getTenPB() {
		return tenPB;
	}

	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public LinkedList<Nhanvien> getDsNV() {
		return dsNV;
	}

	public void setDsNV(LinkedList<Nhanvien> dsNV) {
		this.dsNV = dsNV;
	}

	public Phongban(String maPB, String tenPB) {
		super();
		this.maPB = maPB;
		this.tenPB = tenPB;
	}

	public Phongban() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Nhap() {
		// TODO Auto-generated method stub

	}
	@Override
	public void Xuat() {
		for (Nhanvien nhanVien : this.getDsNV()) {
			nhanVien.Xuat();
			System.out.println("__________________________________________________________________________________________________________________________________");
		}
	}

}