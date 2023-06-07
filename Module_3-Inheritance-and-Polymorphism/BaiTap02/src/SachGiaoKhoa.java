import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
    private TinhTrang tinhTrang;

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(int maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, TinhTrang tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    public TinhTrang getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double thanhTien() {
        if (tinhTrang == TinhTrang.MOI)
            return soLuong * donGia;
        return soLuong * donGia * 0.5;
    }

    @Override
    public String toString() {
        return "SachGiaoKhoa{" +
                "tinhTrang=" + tinhTrang +
                ", maSach=" + maSach +
                ", ngayNhap=" + ngayNhap +
                ", donGia=" + donGia +
                ", soLuong=" + soLuong +
                ", nhaXuatBan='" + nhaXuatBan + '\'' +
                '}';
    }
}
