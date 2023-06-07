import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class KhoaHoc {
    private String tenKhoaHoc;
    private LocalDate ngayMoKhoaHoc;
    private String thoiGianHoc;
    private List<HocVien> danhSachHocVien;

    public KhoaHoc(String tenKhoaHoc, LocalDate ngayMoKhoaHoc, String thoiGianHoc, List<HocVien> danhSachHocVien) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.ngayMoKhoaHoc = ngayMoKhoaHoc;
        this.thoiGianHoc = thoiGianHoc;
        this.danhSachHocVien = danhSachHocVien;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public LocalDate getNgayMoKhoaHoc() {
        return ngayMoKhoaHoc;
    }

    public void setNgayMoKhoaHoc(LocalDate ngayMoKhoaHoc) {
        this.ngayMoKhoaHoc = ngayMoKhoaHoc;
    }

    public String getThoiGianHoc() {
        return thoiGianHoc;
    }

    public void setThoiGianHoc(String thoiGianHoc) {
        this.thoiGianHoc = thoiGianHoc;
    }

    public List<HocVien> getDanhSachHocVien() {
        return danhSachHocVien;
    }

    public void setDanhSachHocVien(List<HocVien> danhSachHocVien) {
        this.danhSachHocVien = danhSachHocVien;
    }

    public void themHocVien(HocVien hocVien) {
        if (danhSachHocVien.size() < 20) {
            danhSachHocVien.add(hocVien);
        } else {
            System.out.println("Không thể thêm học viên. Số lượng học viên đã đạt tối đa.");
        }
    }

    @Override
    public String toString() {
        return "KhoaHoc{" +
                "tenKhoaHoc='" + tenKhoaHoc + '\'' +
                ", ngayMoKhoaHoc=" + ngayMoKhoaHoc +
                ", thoiGianHoc='" + thoiGianHoc + '\'' +
                ", \ndanhSachHocVien=" + danhSachHocVien +
                '}';
    }
}
