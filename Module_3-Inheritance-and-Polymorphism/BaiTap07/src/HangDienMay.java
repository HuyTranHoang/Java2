public class HangDienMay extends HangHoa {
    private int thoiGianBaoHang;
    private double congSuat;

    public HangDienMay(String maHang) throws Exception {
        super(maHang);
    }

    public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHang, double congSuat) throws Exception {
        super(maHang, tenHang, donGia, soLuongTon);
        this.thoiGianBaoHang = Math.max(thoiGianBaoHang, 0);
        this.congSuat = Math.max(congSuat, 0);
    }

    public int getThoiGianBaoHang() {
        return thoiGianBaoHang;
    }

    public void setThoiGianBaoHang(int thoiGianBaoHang) {
        this.thoiGianBaoHang = Math.max(thoiGianBaoHang, 0);
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = Math.max(congSuat, 0);
    }

    @Override
    public String mucDoBanBuon() {
        if (this.soLuongTon < 3)
            return "Bán được";
        return "Không đánh giá";
    }

    @Override
    public String toString() {
        return "HangDienMay{" +
                "thoiGianBaoHang=" + thoiGianBaoHang +
                ", congSuat=" + congSuat +
                ", maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", donGia=" + donGia +
                ", soLuongTon=" + soLuongTon +
                ", soLuongTon=" + mucDoBanBuon() +
                '}';
    }
}
