import java.util.Scanner;

public class Vehicle {
    String chuXe;
    String loaiXe;
    double triGiaXe;
    double xylanh;

    public Vehicle() {
    }

    public Vehicle(String chuXe, String loaiXe, double triGiaXe, double xylanh) {
        this.chuXe = chuXe;
        this.loaiXe = loaiXe;
        this.triGiaXe = triGiaXe;
        this.xylanh = xylanh;

        if (triGiaXe > 0) {
            this.triGiaXe = 5000000;
        }
        if (xylanh > 0) {
            this.xylanh = 100;
        }
    }

    public String getChuXe() {
        return chuXe;
    }

    public void setChuXe(String chuXe) {
        this.chuXe = chuXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public double getTriGiaXe() {
        return triGiaXe;
    }

    public void setTriGiaXe(double triGiaXe) {
        if (triGiaXe > 0) {
            this.triGiaXe = triGiaXe;
        }
    }

    public double getXylanh() {
        return xylanh;
    }

    public void setXylanh(double xylanh) {
        if (xylanh > 0) {
            this.xylanh = xylanh;
        }
    }

    private double thue() {
        if (this.xylanh < 100) {
            return 0.01 * this.triGiaXe;
        } else if (this.xylanh < 200) {
            return 0.03 * this.triGiaXe;
        } else {
            return 0.05 * this.triGiaXe;
        }
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chủ xe: ");
        this.chuXe = scanner.nextLine();
        System.out.println("Nhập loại xe: ");
        this.loaiXe = scanner.nextLine();
        System.out.println("Nhập giá trị xe: ");
        this.triGiaXe = scanner.nextDouble();
        System.out.println("Nhập xylanh: ");
        this.xylanh = scanner.nextDouble();
    }
}
