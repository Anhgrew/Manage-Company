import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Congty implements Nhapxuat {

	private LinkedList<Phongban> dsPB;

	public LinkedList<Phongban> getDsPB() {
		return dsPB;
	}

	public void setDsPB(LinkedList<Phongban> dsPB) {
		this.dsPB = dsPB;
	}

	public Congty() {
		super();
	}

	public Congty(LinkedList<Phongban> dsPB) {
		super();
		this.dsPB = dsPB;
	}

// Ham tra ve so nhiem vu nhieu nhat
	public int nhiemVNN() {
		int nhiemVuNN = -100;
		for (Phongban phongban : dsPB) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien.getSoNV() > nhiemVuNN) {
					nhiemVuNN = nhanVien.getSoNV();
				}
			}
		}
		return nhiemVuNN;
	}

// Ham tim nhan vien co nhieu nhiem vu nhat
	public void nhanVienNhieuNVNhat() {
		int nhiemVuNN = nhiemVNN();
		System.out.println("Danh sach nhan vien lam nhieu nhiem vu nhat cong ty: ");
		for (Phongban phongban : dsPB) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien.getSoNV() == nhiemVuNN) {
					System.out.println("Ten nhan vien: " + nhanVien.getTenNV());
					System.out.println("Ma nhan vien:" + nhanVien.getMaNV());
					System.out.println();
				}
			}
		}
	}

// Ham tim phong ban co nhan vien tre nhat
	public void phongBanCoNVTreNhat() {
		int namSinhTreNhat = treTuoiNhat();
		System.out.println("Phong ban co nhan vien tre nhat: ");
		for (Phongban phongban : dsPB) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien.getNamSinh() == namSinhTreNhat) {
					System.out.println(phongban.getTenPB());
					System.out.println();
					System.out.println(
							"Nhan vien tre nhat: " + nhanVien.getTenNV() + " Sinh nam: " + nhanVien.getNamSinh());
					break;
				}
			}
		}
	}

	// Ham tra ve nam sinh gan nhat trong cac nhan vien
	public int treTuoiNhat() {

		int namSinhTreNhat = -4000;
		for (Phongban phongban : dsPB) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien.getNamSinh() > namSinhTreNhat) {
					namSinhTreNhat = nhanVien.getNamSinh();
				}
			}

		}

		return namSinhTreNhat;
	}

	// Ham tra ve ten va ma nhan vien tre nhat, neu nhan vien co nhieu nhiem vu nhat
	// thi tra ve con ko thi tra ve not found
	public void nhanVienTreNhatDangNhieuNVNhat() {
		int namSinh = treTuoiNhat();
		int nhiemVuNN = nhiemVNN();
		boolean flag = false;
		System.out.println("Danh sach nhan vien tre tuoi dang lam nhieu nhiem vu nhat cong ty: ");
		for (Phongban phongban : dsPB) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien.getNamSinh() == namSinh && nhanVien.getSoNV() == nhiemVuNN) {
					System.out.println("Phong ban: " + phongban.getTenPB());
					System.out.println("Ten nhan vien: " + nhanVien.getTenNV());
					System.out.println("Ma nhan vien: " + nhanVien.getMaNV());
					System.out.println();
					flag = true;
				}
			}
		}
		if (!flag) {
			System.out.println("NOT FOUND");
		}
	}

// Ham xoa 1 nhan vien
	void xoaMotNhanVien(String ma) {
		boolean flag = false;
		for (Phongban phongban : this.getDsPB()) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien.getMaNV().equals(ma)) {
					LinkedList<Nhanvien> tmp = phongban.getDsNV();
					tmp.remove(nhanVien);
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			System.out.println("NOT FOUND");
		}

	}

// Ham doc file nhan vien phan biet truong phong va nhan vien thuong cho vao linkedlist roi tra ra
	public LinkedList<Nhanvien> readFileNhanVien() {
		LinkedList<Nhanvien> danhSachNhanVien = new LinkedList<Nhanvien>();
		try {

			FileReader reader = new FileReader("src/DSNV.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				if (listInfo[6].equals("Truong Phong") || listInfo[6].equals("Truong Phong ")) {
					Nhanvien nhanVien = new Truongphong(listInfo[0], listInfo[1], Integer.parseInt(listInfo[2]),
							listInfo[3], listInfo[4], listInfo[5], listInfo[6], Float.parseFloat(listInfo[7]));
					danhSachNhanVien.add(nhanVien);
				} else if (listInfo[6].equals("Nhan Vien") || listInfo[6].equals("Nhan Vien ")) {
					Nhanvien nhanVien = new Nhanvienthuong(listInfo[0], listInfo[1], Integer.parseInt(listInfo[2]),
							listInfo[3], listInfo[4], listInfo[5], listInfo[6], Float.parseFloat(listInfo[7]));
					danhSachNhanVien.add(nhanVien);
				}

			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return danhSachNhanVien;
	}

// ham doc file nhiem vu
	public LinkedList<Nhiemvu> readFileNhiemVu() {

		LinkedList<Nhiemvu> danhSachNhiemVu = new LinkedList<Nhiemvu>();
		try {
			FileReader reader = new FileReader("src/Task.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				Nhiemvu nhiemVu = new Nhiemvu(listInfo[0], listInfo[1], Float.parseFloat(listInfo[2]), listInfo[3]);
				danhSachNhiemVu.add(nhiemVu);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return danhSachNhiemVu;
	}

// Ham chon ra danh sach nhiem vu cho tung nhan vien tu hai linkedlist tra ve o ham tren
	public LinkedList<Nhanvien> NhiemVu_NhanVien(LinkedList<Nhanvien> danhSachNhanVien,
			LinkedList<Nhiemvu> danhSachNhiemVu) {
		int count = 0;
		float soGioLamNV = 0f;
		for (Nhanvien nhanVien : danhSachNhanVien) {
			LinkedList<String> tmp = new LinkedList<String>();
			for (Nhiemvu nhiemvu : danhSachNhiemVu) {
				if (nhiemvu.getMaNV().equals(nhanVien.getMaNV())) {
					count++;
					soGioLamNV += nhiemvu.getThoiGianTH();
					tmp.add(nhiemvu.getMaNhiemVu());
				}
			}
			nhanVien.setDsNhiemVu(tmp);
			nhanVien.setSoGioTask(soGioLamNV);
			nhanVien.setSoNV(count);
			count = 0;
		}
		return danhSachNhanVien;
	}

	// Ham doc file phong ban va cho nhan vien vao tung phong ban tuong ung theo ma
	// pb trong linkedlist nhan vien
	public void readFilePhongBan(LinkedList<Nhanvien> danhSachNhanVien) {
		try {
			FileReader reader = new FileReader("src/PhongBan.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			LinkedList<Phongban> danhSachPhongBan = new LinkedList<Phongban>();
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				Phongban phongBan = new Phongban(listInfo[0], listInfo[1]);
				LinkedList<Nhanvien> danhSachNhanVienPB = new LinkedList<Nhanvien>();
				for (Nhanvien nhanVien : danhSachNhanVien) {
					if (nhanVien.getMaPB().equals(listInfo[0])) {
						danhSachNhanVienPB.add(nhanVien);

					}
				}
				phongBan.setDsNV(danhSachNhanVienPB);
				danhSachPhongBan.add(phongBan);

			}
			this.setDsPB(danhSachPhongBan);
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

// Ham tong hop ham 3 ham doc tren dua tat ca thong tin vao Congty
	public void nhapFile() {
		LinkedList<Nhanvien> danhSachNhanVien = readFileNhanVien();
		LinkedList<Nhiemvu> danhSachNhiemVu = readFileNhiemVu();
		LinkedList<Nhanvien> danhSachTongHop = NhiemVu_NhanVien(danhSachNhanVien, danhSachNhiemVu);
		readFilePhongBan(danhSachTongHop);
	}

	@Override
	public void Xuat() {
		System.out.println();
		System.out.println(
				">>>>>>>>>>>>>>>>>>>>>|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||<<<<<<<<<<<<<<<<<<<<");
		System.out.println();
		System.out.println();
		for (Phongban phongban : this.getDsPB()) {
			System.out.println("Phong Ban: " + phongban.getMaPB() + "-----" + phongban.getTenPB());
			System.out.println("-------------------------------------------");
			phongban.Xuat();
			System.out.println(
					"__________________________________________________________________________________________________________________________________");
		}

	}

	@Override
	public void Nhap() {
		// TODO Auto-generated method stub

	}

	public void sapXepNhanVienTheoNhiemVu() {
		System.out.println();
		System.out.println();
		System.out.println("Danh Sach Nhan Vien Da Duoc Sap Xep");
		System.out.println(
				"____________________________________________________________________________________________________________________________");
		ArrayList<Nhanvien> dsToanBo = new ArrayList<Nhanvien>();
		for (Phongban phongban : this.getDsPB()) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				dsToanBo.add(nhanVien);
			}
		}
		Collections.sort((List<Nhanvien>) dsToanBo);
		for (Nhanvien nhanvien : dsToanBo) {
			nhanvien.Xuat1();
		}
	}

	public void tinhSoNVDuoiQuyen() {
		int count = 0;
		for (Phongban phongban : dsPB) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien instanceof Nhanvienthuong) {
					count++;
				} else if (nhanVien instanceof Truongphong) {
					((Truongphong) nhanVien).setSoLuongNVDuoiQuyen(count);
				}
			}
			count = 0;
		}
	}

	public void tinhLuongNhanVien(String ma) {
		boolean flag = false;
		for (Phongban phongban : this.getDsPB()) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				if (nhanVien.getMaNV().contentEquals(ma)) {
					nhanVien.tinhLuong();
					System.out.println("Nhan vien: " + nhanVien.getTenNV() + " | Luong: " + nhanVien.getLuong() + "$");
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			System.out.println("NOT FOUND");
		}
	}

	public void tinhLuongCongTy() {
		double tongLuong = 0.0;
		for (Phongban phongban : this.getDsPB()) {
			for (Nhanvien nhanVien : phongban.getDsNV()) {
				nhanVien.tinhLuong();
				tongLuong += nhanVien.getLuong();
			}
		}
		System.out.println("Tong Luong Cong Ty Can Chi Tra: " + tongLuong + "$");
	}
}
