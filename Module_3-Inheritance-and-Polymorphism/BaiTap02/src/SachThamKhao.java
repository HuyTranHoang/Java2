import java.time.LocalDate;

public class SachThamKhao extends Sach {
    private double tienThue;

    public SachThamKhao() {
    }

    public SachThamKhao(int maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double tienThue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tienThue = tienThue;
    }

    public double getThue() {
        return tienThue;
    }

    public void setThue(double tienThue) {
        this.tienThue = tienThue;
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia + tienThue;
    }
}
