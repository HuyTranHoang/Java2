import java.time.LocalDate;

public class KhachHangVietNam extends KhachHang {
    private DoiTuongKhachHang doiTuongKhachHang;
    private double dinhMuc;

    public KhachHangVietNam() {

    }

    public KhachHangVietNam(int maKhachHang, String hoTen, LocalDate ngayLapHoaDon, double soKwTieuThu, double donGia, DoiTuongKhachHang doiTuongKhachHang, double dinhMuc) {
        super(maKhachHang, hoTen, ngayLapHoaDon, soKwTieuThu, donGia);
        this.doiTuongKhachHang = doiTuongKhachHang;
        this.dinhMuc = dinhMuc;
    }

    public DoiTuongKhachHang getDoiTuongKhachHang() {
        return doiTuongKhachHang;
    }

    public void setDoiTuongKhachHang(DoiTuongKhachHang doiTuongKhachHang) {
        this.doiTuongKhachHang = doiTuongKhachHang;
    }

    public double getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    @Override
    public double thanhTien() {
        if (this.soKwTieuThu <= this.dinhMuc)
            return super.thanhTien();

        double soKwVuotDinhMuc = this.soKwTieuThu - this.dinhMuc;
        return super.thanhTien() * this.dinhMuc + soKwVuotDinhMuc * this.donGia * 2.5;
    }

    @Override
    public String toString() {
        return "KhanhHangVietNam{" +
                "doiTuongKhachHang=" + doiTuongKhachHang +
                ", dinhMuc=" + dinhMuc +
                ", maKhachHang=" + maKhachHang +
                ", hoTen='" + hoTen + '\'' +
                ", ngayLapHoaDon=" + ngayLapHoaDon +
                ", soKwTieuThu=" + soKwTieuThu +
                ", donGia=" + donGia +
                '}';
    }
}
