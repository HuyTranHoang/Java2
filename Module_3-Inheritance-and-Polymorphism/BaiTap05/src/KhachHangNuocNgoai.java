import java.time.LocalDate;

public class KhachHangNuocNgoai extends KhachHang {
    private String quocTich;

    public KhachHangNuocNgoai() {
    }

    public KhachHangNuocNgoai(int maKhachHang, String hoTen, LocalDate ngayLapHoaDon, double soKwTieuThu, double donGia, String quocTich) {
        super(maKhachHang, hoTen, ngayLapHoaDon, soKwTieuThu, donGia);
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return "KhachHangNuocNgoai{" +
                "quocTich='" + quocTich + '\'' +
                ", maKhachHang=" + maKhachHang +
                ", hoTen='" + hoTen + '\'' +
                ", ngayLapHoaDon=" + ngayLapHoaDon +
                ", soKwTieuThu=" + soKwTieuThu +
                ", donGia=" + donGia +
                '}';
    }
}
