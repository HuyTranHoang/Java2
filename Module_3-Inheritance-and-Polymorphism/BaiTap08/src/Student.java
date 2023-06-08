public class Student extends Person {
    private double diemMon1;
    private double diemMon2;

    public Student() {
    }

    public Student(String hoTen, String diaChi, double diemMon1, double diemMon2) {
        super(hoTen, diaChi);
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
    }

    public double getDiemMon1() {
        return diemMon1;
    }

    public void setDiemMon1(double diemMon1) {
        this.diemMon1 = diemMon1;
    }

    public double getDiemMon2() {
        return diemMon2;
    }

    public void setDiemMon2(double diemMon2) {
        this.diemMon2 = diemMon2;
    }

    public double tinhDiemTrungBinh() {
        return (diemMon1 + diemMon2) / 2;
    }

    public void danhGia() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "diemMon1=" + diemMon1 +
                ", diemMon2=" + diemMon2 +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", diemTrungBinh='" + tinhDiemTrungBinh() + '\'' +
                '}';
    }
}
