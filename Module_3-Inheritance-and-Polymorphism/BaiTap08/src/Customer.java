public class Customer extends Person {
    private String tenCongTy;
    private double triGiaHoaDon;

    public Customer() {

    }

    public Customer(String hoTen, String diaChi, String tenCongTy, double triGiaHoaDon) {
        super(hoTen, diaChi);
        this.tenCongTy = tenCongTy;
        this.triGiaHoaDon = triGiaHoaDon;
    }

    public void danhGia() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "tenCongTy='" + tenCongTy + '\'' +
                ", triGiaHoaDon=" + triGiaHoaDon +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
