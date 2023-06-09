import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public abstract class HangHoa {
    protected int maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuongTon;


    public HangHoa() throws Exception {
        UUID uuid = UUID.randomUUID();
        this.maHang = uuid.hashCode();
        this.tenHang = "xxx";
        this.donGia = 0;
        this.soLuongTon = 0;
    }

    public HangHoa(String tenHang, double donGia, int soLuongTon) throws Exception {
        UUID uuid = UUID.randomUUID();
        this.maHang = uuid.hashCode();
        setTenHang(tenHang);
        setDonGia(donGia);
        setSoLuongTon(soLuongTon);
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

    public int getMaHang() {
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
