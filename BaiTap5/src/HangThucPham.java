import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {

    private String maHang;
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;


    public HangThucPham() throws Exception {
        throw new Exception("Không được để trống mã hàng");
    }

    public HangThucPham(String maHang) throws Exception {
        if (maHang.isEmpty())
            throw new Exception("Không được để trống mã hàng");
    }

    public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        if (maHang.isEmpty())
            throw new RuntimeException();
        else
            this.maHang = maHang;

        if (tenHang.isEmpty())
            this.tenHang = "xxx";
        else
            this.tenHang = tenHang;

        if (donGia < 0)
            this.donGia = 0;
        else
            this.donGia = donGia;

        LocalDate now = LocalDate.now();

        if (ngaySanXuat.isBefore(now))
            this.ngaySanXuat = ngaySanXuat;
        else
            this.ngaySanXuat = now;

        if (ngayHetHan.isAfter(this.ngaySanXuat))
            this.ngayHetHan = ngayHetHan;
        else
            this.ngayHetHan = this.ngaySanXuat;
    }

    public String getMaHang() {
        return maHang;
    }

    private void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang.isEmpty())
            this.tenHang = "xxx";
        else
            this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        LocalDate now = LocalDate.now();

        if (ngaySanXuat.isBefore(now))
            this.ngaySanXuat = ngaySanXuat;
        else
            this.ngaySanXuat = now;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan.isAfter(this.ngaySanXuat))
            this.ngayHetHan = ngayHetHan;
        else
            this.ngayHetHan = this.ngaySanXuat;
    }

    public boolean sanPhamDaHetHan() {
        return LocalDate.now().isAfter(this.ngayHetHan);
    }

    @Override
    public String toString() {
        String donGiaFormat = NumberFormat.getInstance().format(donGia);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String ngaySanXuatFormat = ngaySanXuat.format(formatter);
        String ngayHetHanFormat = ngayHetHan.format(formatter);

        return "HangThucPham{" +
                "maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", donGia=" + donGiaFormat +
                ", ngaySanXuat=" + ngaySanXuatFormat +
                ", ngayHetHan=" + ngayHetHanFormat +
                ", hetHan=" + sanPhamDaHetHan() +
                '}';
    }
}
