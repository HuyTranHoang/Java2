import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrungTamDaoTao {
    private List<KhoaHoc> danhSachKhoaHoc;

    public TrungTamDaoTao() {
        danhSachKhoaHoc = new ArrayList<>();
    }

    public void themKhoaHoc(KhoaHoc khoaHoc) {
        danhSachKhoaHoc.add(khoaHoc);
    }

    public KhoaHoc timKhoaHoc(String tenKhoaHoc) {
        for (KhoaHoc khoaHoc : danhSachKhoaHoc) {
            if (khoaHoc.getTenKhoaHoc().contains(tenKhoaHoc)) {
                return khoaHoc;
            }
        }
        return null;
    }

    public List<KhoaHoc> timKhoaHocChuaKetThuc() {
        List<KhoaHoc> khoaHocChuaKetThuc = new ArrayList<>();
        for (KhoaHoc khoaHoc : danhSachKhoaHoc) {
//            Giả sử khoá học kết thúc sau 30 ngày
            LocalDate ngayKetThuc = khoaHoc.getNgayMoKhoaHoc().plusDays(30);
            if (khoaHoc.getNgayMoKhoaHoc().isAfter(ngayKetThuc)) {
                khoaHocChuaKetThuc.add(khoaHoc);
            }
        }
        return khoaHocChuaKetThuc;
    }

    public List<KhoaHoc> timKhoaHocChuaBatDau() {
        List<KhoaHoc> khoaHocChuaBatDau = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (KhoaHoc khoaHoc : danhSachKhoaHoc) {
            if (khoaHoc.getNgayMoKhoaHoc().isAfter(currentDate)) {
                khoaHocChuaBatDau.add(khoaHoc);
            }
        }
        return khoaHocChuaBatDau;
    }

    public List<KhoaHoc> timKhoaHocCuaHocVien(HocVien hocVien) {
        List<KhoaHoc> khoaHocCuaHocVien = new ArrayList<>();
        for (KhoaHoc khoaHoc : danhSachKhoaHoc) {
            List<HocVien> danhSachHocVien = khoaHoc.getDanhSachHocVien();
            if (danhSachHocVien.contains(hocVien)) {
                khoaHocCuaHocVien.add(khoaHoc);
            }
        }
        return khoaHocCuaHocVien;
    }

}
