

public class Truongphong extends Nhanvien {
	final int LUONG_GIO = 300;
	final int PHU_CAP_MOI_NHAN_VIEN = 200;
	private int soLuongNVDuoiQuyen = 0;
	public int getSoLuongNVDuoiQuyen() {
		return soLuongNVDuoiQuyen;
	}

	public void setSoLuongNVDuoiQuyen(int soLuongNVDuoiQuyen) {
		this.soLuongNVDuoiQuyen = soLuongNVDuoiQuyen;
	}
	@Override
	public void tinhLuong() {
		this.luong = LUONG_GIO * this.getGioLam() + PHU_CAP_MOI_NHAN_VIEN * this.soLuongNVDuoiQuyen;
	}

	@Override
	public void Xuat() {
		// TODO Auto-generated method stub
		super.Xuat();
	}

	protected String poSiTion;

	public Truongphong(String maNV, String tenNV, int namSinh, String email, String soDT, String maPB, String string, float gioLam) {
		super(maNV, tenNV, namSinh, email, soDT, maPB);
		poSiTion = string;
		this.setGioLam(gioLam);
		// TODO Auto-generated constructor stub
	}

	public String getPoSiTion() {
		return poSiTion;
	}

	public void setPoSiTion(String poSiTion) {
		this.poSiTion = poSiTion;
	}

}