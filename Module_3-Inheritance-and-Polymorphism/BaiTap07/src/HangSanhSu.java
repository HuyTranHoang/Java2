import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang) throws Exception {
        super(maHang);
        this.ngayNhapKho = LocalDate.now();
    }

    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat, LocalDate ngayNhapKho) throws Exception {
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaSanXuat = nhaSanXuat;

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
