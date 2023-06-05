public class ChuyenXeNoiThanh extends ChuyenXe {
    private int soTuyen;
    private int soKm;

    public ChuyenXeNoiThanh() {

    }

    public ChuyenXeNoiThanh(int maSo, String hoTenTaiXe, String soXe, double doanhThu, int soTuyen, int soKm) {
        super(maSo, hoTenTaiXe, soXe, doanhThu);
        this.soTuyen = soTuyen;
        this.soKm = soKm;
    }

    public int getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(int soTuyen) {
        this.soTuyen = soTuyen;
    }

    public int getSoKm() {
        return soKm;
    }

    public void setSoKm(int soKm) {
        this.soKm = soKm;
    }
}
