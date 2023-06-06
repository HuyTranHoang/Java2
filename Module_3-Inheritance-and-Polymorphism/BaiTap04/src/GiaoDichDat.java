import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
    protected LoaiDat loaiDat;

    public GiaoDichDat() {
    }

    public GiaoDichDat(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, LoaiDat loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    public LoaiDat getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(LoaiDat loaiDat) {
        this.loaiDat = loaiDat;
    }

    @Override
    public double thanhTien() {
        if (this.loaiDat == LoaiDat.A)
            return super.thanhTien() * 1.5;
        return super.thanhTien();
    }

    @Override
    public String toString() {
        return "GiaoDichDat{" +
                "loaiDat=" + loaiDat +
                ", maGiaoDich=" + maGiaoDich +
                ", ngayGiaoDich=" + ngayGiaoDich +
                ", donGia=" + donGia +
                ", dienTich=" + dienTich +
                '}';
    }
}
