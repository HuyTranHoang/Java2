public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(String maHang) throws Exception {
        super(maHang);
    }

    public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHang, double congSuat) throws Exception {
        super(maHang, tenHang, donGia, soLuongTon);
        this.thoiGianBaoHanh = Math.max(thoiGianBaoHang, 0);
        this.congSuat = Math.max(congSuat, 0);
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = Math.max(thoiGianBaoHanh, 0);
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = Math.max(congSuat, 0);
    }

    @Override
    public MucDoBanBuon mucDoBanBuon() {
        if (this.soLuongTon < 3)
            return MucDoBanBuon.BAN_DUOC;
        return MucDoBanBuon.KHONG_DANH_GIA;
    }

    @Override
    public String toString() {
        return "HangDienMay{" +
                "thoiGianBaoHang=" + thoiGianBaoHanh +
                ", congSuat=" + congSuat +
                ", maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", donGia=" + donGia +
                ", soLuongTon=" + soLuongTon +
                ", soLuongTon=" + mucDoBanBuon() +
                '}';
    }
}
