import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(1,"Trần Hoàng Huy",8,8);
        SinhVien sv2 = new SinhVien(2,"Quang Hạo Nhiên",7,7);
        SinhVien sv3 = new SinhVien();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên sv3: ");
        sv3.setMaSV(scanner.nextInt());
        System.out.println("Nhập họ tên sv3: ");
        sv3.setHoTen(scanner.nextLine());
        System.out.println("Nhập điểm lý thuyết sv3: ");
        sv3.setDiemLT(scanner.nextFloat());
        System.out.println("Nhập điểm thực hành sv3: ");
        sv3.setDiemTH(scanner.nextFloat());
    }
}