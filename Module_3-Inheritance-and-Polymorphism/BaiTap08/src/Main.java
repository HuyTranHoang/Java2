import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Management management = null;
        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Khởi tạo danh sách n phần tử");
            System.out.println("2. Thêm một người vào danh sách");
            System.out.println("3. Xoá một người ra khỏi danh sách");
            System.out.println("4. Sắp xếp danh sách theo thứ tự họ tên");
            System.out.println("5. Xuất danh sách");
            System.out.println("----");
            System.out.println("0. Thoát chương trình");

            System.out.println("Lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Nhập số lượng phần tử: ");
                    management = new Management(scanner.nextInt());
                }
                case 2 -> {
                    if (management == null) {
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử");
                    } else {

                        System.out.println("1. Student");
                        System.out.println("2. Employee");
                        System.out.println("3. Customer");
                        System.out.println("Lựa chọn: ");
                        int luaChon = scanner.nextInt();
                        scanner.nextLine();

                        String hoTen = null, diaChi = null;

                        if (luaChon > 0 && luaChon < 4) {
                            System.out.println("Nhập họ tên: ");
                            hoTen = scanner.nextLine();
                            System.out.println("Nhập địa chỉ: ");
                            diaChi = scanner.nextLine();
                        }

                        switch (luaChon) {
                            case 1 -> {
                                System.out.println("Nhập điểm môn học 1: ");
                                double diemMon1 = scanner.nextDouble();
                                System.out.println("Nhập điểm môn học 2: ");
                                double diemMon2 = scanner.nextDouble();

                                Student student = new Student(hoTen,diaChi,diemMon1,diemMon2);
                                management.them(student);
                            }
                            case 2 -> {
                                System.out.println("Nhập hệ số lương: ");
                                double heSoLuong = scanner.nextDouble();

                                Employee employee = new Employee(hoTen,diaChi,heSoLuong);
                                management.them(employee);
                            }
                            case 3 -> {
                                System.out.println("Nhập tên công ty: ");
                                String tenCongTy = scanner.nextLine();
                                System.out.println("Nhập trị giá hoá đơn: ");
                                double triGiaHoaDon = scanner.nextDouble();

                                Customer customer = new Customer(hoTen,diaChi,tenCongTy,triGiaHoaDon);
                                management.them(customer);
                            }
                            default -> System.out.println("Lỗi: Không có lựa chọn này!");
                        }
                    }
                }
                case 3 -> {
                    if (management == null) {
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử");
                    } else {
                        System.out.println("Nhập họ tên người cần xoá: ");
                        scanner.nextLine();
                        String hoTenCanXoa = scanner.nextLine();
                        management.xoa(hoTenCanXoa);
                    }
                }
                case 4 -> {
                    if (management == null) {
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử");
                    } else {
                        management.sapXepTheoHoTen();
                    }
                }
                case 5 -> {
                    if (management == null) {
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử");
                    } else {
                        management.xuatDanhSach();
                    }
                }
                case 0 -> System.out.println("Good bye!!!");
                default -> System.out.println("Lỗi: Không có lựa chọn này!");
            }
        } while (choice != 0);
    }
}