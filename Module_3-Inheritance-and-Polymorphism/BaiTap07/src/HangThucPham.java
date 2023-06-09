import java.time.LocalDate;

public class HangThucPham extends HangHoa {
    private String nhaCungCap;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public HangThucPham() throws Exception {
        super();
        this.ngaySanXuat = LocalDate.now();
        this.ngayHetHan = this.ngaySanXuat;
    }

    public HangThucPham(String tenHang, double donGia, int soLuongTon, String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {
        super(tenHang, donGia, soLuongTon);
        setNhaCungCap(nhaCungCap);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
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
        if (ngaySanXuat.isAfter(LocalDate.now()))
            this.ngaySanXuat = LocalDate.now();
        else
            this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan.isBefore(this.ngaySanXuat))
            this.ngayHetHan = this.ngaySanXuat;
        else
            this.ngayHetHan = ngayHetHan;
    }

    @Override
    public MucDoBanBuon mucDoBanBuon() {
        if (this.soLuongTon > 0 && this.ngayHetHan.isBefore(LocalDate.now()))
            return MucDoBanBuon.KHO_BAN;
        return MucDoBanBuon.KHONG_DANH_GIA;
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
