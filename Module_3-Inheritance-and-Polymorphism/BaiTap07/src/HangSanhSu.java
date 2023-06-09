import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu() throws Exception {
        super();
        this.ngayNhapKho = LocalDate.now();
    }

    public HangSanhSu(String tenHang, double donGia, int soLuongTon, String nhaSanXuat, LocalDate ngayNhapKho) throws Exception {
        super(tenHang, donGia, soLuongTon);
        setNhaSanXuat(nhaSanXuat);
        setNgayNhapKho(ngayNhapKho);
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(LocalDate ngayNhapKho) {
        if (ngayNhapKho.isAfter(LocalDate.now()))
            this.ngayNhapKho = LocalDate.now();
        else
            this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public MucDoBanBuon mucDoBanBuon() {
        long soNgayChenhLech = ChronoUnit.DAYS.between(this.ngayNhapKho, LocalDate.now());
        if (this.soLuongTon > 50 & soNgayChenhLech > 10)
            return MucDoBanBuon.BAN_CHAM;
        return MucDoBanBuon.KHONG_DANH_GIA;
    }

    @Override
    public String toString() {
        return "HangSanhSu{" +
                "nhaSanXuat='" + nhaSanXuat + '\'' +
                ", ngayNhapKho=" + ngayNhapKho +
                ", maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", donGia=" + donGia +
                ", soLuongTon=" + soLuongTon +
                ", soLuongTon=" + mucDoBanBuon() +
                '}';
    }
}
