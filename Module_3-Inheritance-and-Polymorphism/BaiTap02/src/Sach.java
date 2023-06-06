import java.time.LocalDate;

public abstract class Sach {
    protected int maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach() {
    }

    public Sach(int maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        if (maSach <= 0)
            this.maSach = 999999;
        else
            this.maSach = maSach;

        if (ngayNhap.isAfter(LocalDate.now()))
            this.ngayNhap = LocalDate.now();
        else
            this.ngayNhap = ngayNhap;


        if (donGia <= 0)
            this.donGia = 999999;
        else
            this.donGia = donGia;

        if (soLuong < 0)
            this.soLuong = 0;
        else
            this.soLuong = soLuong;

        this.nhaXuatBan = nhaXuatBan;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        if (maSach <= 0)
            this.maSach = 999999;
        else
            this.maSach = maSach;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        if (ngayNhap.isAfter(LocalDate.now()))
            this.ngayNhap = LocalDate.now();
        else
            this.ngayNhap = ngayNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia <= 0)
            this.donGia = 999999;
        else
            this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong < 0)
            this.soLuong = 0;
        else
            this.soLuong = soLuong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public abstract double thanhTien();
}
