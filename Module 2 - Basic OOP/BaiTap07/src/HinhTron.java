public class HinhTron {
    private ToaDo tam;
    private double banKinh;

    public HinhTron() {
    }

    public HinhTron(ToaDo tam, double banKinh) {
        this.tam = tam;
        this.banKinh = banKinh;
    }

    public ToaDo getTam() {
        return tam;
    }

    public void setTam(ToaDo tam) {
        this.tam = tam;
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    public double tinhChuVi() {
        return this.banKinh * 2 * Math.PI;
    }

    public double tinhDienTich() {
        return this.banKinh * this.banKinh * Math.PI;
    }

    @Override
    public String toString() {
        ToaDo tam = this.getTam();
        return String.format("Hình tròn có tâm %s(%.2f, %.2f) với bán kính %.2f có diện tích và chu vi lần lượt là %.3f và %.3f",
                tam.getTen(), tam.getX(), tam.getY(), this.getBanKinh(), this.tinhDienTich(), this.tinhChuVi());
    }
}
