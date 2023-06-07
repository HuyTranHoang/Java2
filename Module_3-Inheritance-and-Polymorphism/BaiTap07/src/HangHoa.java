public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuongTon;


    public HangHoa(String maHang) throws Exception {
        if (maHang.isEmpty())
            throw new Exception("Không được để trống mã hàng");
        else
            this.maHang = maHang;

        this.tenHang = "xxx";
        this.donGia = 0;
        this.soLuongTon = 0;
    }

    public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) throws Exception {
        if (maHang.isEmpty())
            throw new Exception("Không được để trống mã hàng");
        else
            this.maHang = maHang;

        if (tenHang.isEmpty())
            this.tenHang = "xxx";
        else
            this.tenHang = tenHang;

        this.donGia = Math.max(donGia,0);
        this.soLuongTon = Math.max(soLuongTon, 0);
    }

    public void setTenHang(String tenHang) {
        if (tenHang.isEmpty())
            this.tenHang = "xxx";
        else
            this.tenHang = tenHang;
    }

    public void setDonGia(double donGia) {
        this.donGia = Math.max(donGia,0);
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = Math.max(soLuongTon, 0);
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public abstract MucDoBanBuon mucDoBanBuon();

}
