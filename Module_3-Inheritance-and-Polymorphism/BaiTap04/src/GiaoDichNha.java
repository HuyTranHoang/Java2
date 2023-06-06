import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
    private LoaiNha loaiNha;
    private String diaChi;

    public GiaoDichNha() {

    }

    public GiaoDichNha(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, LoaiNha loaiNha, String diaChi) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    public LoaiNha getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(LoaiNha loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public double thanhTien() {
        if (loaiNha == LoaiNha.THUONG)
            return super.thanhTien() * 0.9;
        return super.thanhTien();
    }

    @Override
    public String toString() {
        return "GiaoDichNha{" +
                "loaiNha=" + loaiNha +
                ", diaChi='" + diaChi + '\'' +
                ", maGiaoDich=" + maGiaoDich +
                ", ngayGiaoDich=" + ngayGiaoDich +
                ", donGia=" + donGia +
                ", dienTich=" + dienTich +
                '}';
    }
}
