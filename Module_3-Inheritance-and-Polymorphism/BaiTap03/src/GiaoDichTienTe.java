import java.time.LocalDate;

public class GiaoDichTienTe extends GiaoDich {
    private double tiGia;
    private LoaiTien loaiTien;

    public GiaoDichTienTe() {

    }

    public GiaoDichTienTe(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, double tiGia, LoaiTien loaiTien) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.tiGia = tiGia;
        this.loaiTien = loaiTien;
    }

    public double getTiGia() {
        return tiGia;
    }

    public void setTiGia(double tiGia) {
        this.tiGia = tiGia;
    }

    public LoaiTien getLoaiTien() {
        return loaiTien;
    }

    public void setLoaiTien(LoaiTien loaiTien) {
        this.loaiTien = loaiTien;
    }

    @Override
    public double thanhTien() {
        if (this.loaiTien == LoaiTien.VIET_NAM)
            return super.thanhTien();
        else
            return super.thanhTien() * this.tiGia;
    }

    @Override
    public String toString() {
        return "GiaoDichTienTe{" +
                "tiGia=" + tiGia +
                ", loaiTien=" + loaiTien +
                ", maGiaoDich=" + maGiaoDich +
                ", ngayGiaoDich=" + ngayGiaoDich +
                ", donGia=" + donGia +
                ", soLuong=" + soLuong +
                '}';
    }
}
