import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich {
    private String loaiVang;

    public GiaoDichVang() {
    }

    public GiaoDichVang(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiVang) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.loaiVang = loaiVang;
    }

    public String getLoaiVang() {
        return loaiVang;
    }

    public void setLoaiVang(String loaiVang) {
        this.loaiVang = loaiVang;
    }

    @Override
    public String toString() {
        return "GiaoDichVang{" +
                "loaiVang='" + loaiVang + '\'' +
                ", maGiaoDich=" + maGiaoDich +
                ", ngayGiaoDich=" + ngayGiaoDich +
                ", donGia=" + donGia +
                ", soLuong=" + soLuong +
                '}';
    }
}
