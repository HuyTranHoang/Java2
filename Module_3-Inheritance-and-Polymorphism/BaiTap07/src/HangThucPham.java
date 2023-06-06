import java.time.LocalDate;

public class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public HangThucPham(String maHang) throws Exception {
        super(maHang);
        this.ngaySanXuat = LocalDate.now();
        this.ngayHetHan = this.ngaySanXuat;
    }

    public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaCungCap = nhaCungCap;

        if (ngaySanXuat.isAfter(LocalDate.now()))
            this.ngaySanXuat = LocalDate.now();
        else
            this.ngaySanXuat = ngaySanXuat;

        if (ngayHetHan.isBefore(this.ngaySanXuat))
            this.ngayHetHan = this.ngaySanXuat;
        else
            this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String mucDoBanBuon() {
        if (this.soLuongTon > 0 && this.ngayHetHan.isBefore(LocalDate.now()))
            return "Khó bán";
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return "HangThucPham{" +
                "nhaCungCap='" + nhaCungCap + '\'' +
                ", ngaySanXuat=" + ngaySanXuat +
                ", ngayHetHan=" + ngayHetHan +
                ", maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", donGia=" + donGia +
                ", soLuongTon=" + soLuongTon +
                ", mucDoBanBuon=" + mucDoBanBuon() +
                '}';
    }
}
