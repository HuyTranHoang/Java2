public class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay() throws Exception {
        super();
    }

    public HangDienMay(String tenHang, double donGia, int soLuongTon, int thoiGianBaoHanh, double congSuat) throws Exception {
        super(tenHang, donGia, soLuongTon);
        setThoiGianBaoHanh(thoiGianBaoHanh);
        setCongSuat(congSuat);
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
                "thoiGianBaoHanh=" + thoiGianBaoHanh +
                ", congSuat=" + congSuat +
                ", maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", donGia=" + donGia +
                ", soLuongTon=" + soLuongTon +
                ", soLuongTon=" + mucDoBanBuon() +
                '}';
    }
}
