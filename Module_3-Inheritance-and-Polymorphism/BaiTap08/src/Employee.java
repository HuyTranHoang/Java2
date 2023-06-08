public class Employee extends Person {
    private double heSoLuong;

    public Employee() {
    }

    public Employee(String hoTen, String diaChi, double heSoLuong) {
        super(hoTen, diaChi);
        this.heSoLuong = heSoLuong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double tinhLuong() {
        double luongCoBan = 5000000;
        return heSoLuong * luongCoBan;
    }

    public void danhGia() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "heSoLuong=" + heSoLuong +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", tienLuong='" + tinhLuong() + '\'' +
                '}';
    }
}
