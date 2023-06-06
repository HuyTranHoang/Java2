import java.time.LocalDate;

public class KhachHang {
    protected int maKhachHang;
    protected String hoTen;
    protected LocalDate ngayLapHoaDon;
    protected double soKwTieuThu;
    protected double donGia;

    public KhachHang() {
    }
    public KhachHang(int maKhachHang, String hoTen, LocalDate ngayLapHoaDon, double soKwTieuThu, double donGia) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.soKwTieuThu = soKwTieuThu;
        this.donGia = donGia;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public double getSoKwTieuThu() {
        return soKwTieuThu;
    }

    public void setSoKwTieuThu(double soKwTieuThu) {
        this.soKwTieuThu = soKwTieuThu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double thanhTien() {
        return this.soKwTieuThu * this.donGia;
    }
}
