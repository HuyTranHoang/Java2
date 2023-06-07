import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice;
        DanhSachHangHoa danhSachHangHoa = null;

        do {
            System.out.println("Menu");
            System.out.println("1. Khởi tạo danh sách n phần tử");
            System.out.println("2. Thêm một hàng hoá vào danh sách");
            System.out.println("3. In toàn bộ danh sách hàng hoá");
            System.out.println("4. In từng loại hàng hoá");
            System.out.println("5. Tìm kiếm hàng hoá khi biết mã hàng");
            System.out.println("6. Sắp xếp hàng hoá theo tên tăng dần");
            System.out.println("7. Sắp xếp hàng hoá theo số lượng tồn giảm dần");
            System.out.println("8. Xuất các hàng thực phầm khó bán");
            System.out.println("9. Xuất các hàng thực phầm khó bán");
            System.out.println("10. Xoá hàng hoá khi biết mã hàng");
            System.out.println("11. Sửa thông tin đơn giá khi biết mã hàng");
            System.out.println("----");
            System.out.println("0. Thoát chương trình");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Nhập số lượng phần tử trong danh sách: ");
                    danhSachHangHoa = new DanhSachHangHoa(scanner.nextInt());
                }
                case 2 -> {
                    int loaiHangHoa;
                    System.out.println("1. Hàng điện máy");
                    System.out.println("2. Hàng sành sứ");
                    System.out.println("3. Hàng thực phẩm");
                    System.out.println("Nhập loại hàng hoá bạn muốn nhập: ");
                    loaiHangHoa = scanner.nextInt();

                    String maHang, tenHang;
                    double donGia;
                    int soLuongTon;

                    switch (loaiHangHoa) {
                        case 1 -> {
                            int thoiGianBaoHanh;
                            double congSuat;
                            System.out.println("Nhập mã hàng: ");
                            maHang = scanner.nextLine();
                            System.out.println("Nhập tên hàng: ");
                            tenHang = scanner.nextLine();
                            System.out.println("Nhập đơn giá: ");
                            donGia = scanner.nextDouble();
                            System.out.println("Nhập số luợng tồn: ");
                            soLuongTon = scanner.nextInt();
                            System.out.println("Nhập thời gian bảo hành: ");
                            thoiGianBaoHanh = scanner.nextInt();
                            System.out.println("Nhập công suất: ");
                            congSuat = scanner.nextDouble();
                            danhSachHangHoa.them(new HangDienMay(maHang,tenHang,donGia,soLuongTon,thoiGianBaoHanh,congSuat));
                        }

                        case 2 -> {
                            String nhaSanXuat;
                            LocalDate ngayNhapKho;
                            int nam;
                            int thang;
                            int ngay;
                            System.out.println("Nhập mã hàng: ");
                            maHang = scanner.nextLine();
                            System.out.println("Nhập tên hàng: ");
                            tenHang = scanner.nextLine();
                            System.out.println("Nhập đơn giá: ");
                            donGia = scanner.nextDouble();
                            System.out.println("Nhập số luợng tồn: ");
                            soLuongTon = scanner.nextInt();
                            System.out.println("Nhập nhà sản xuất: ");
                            nhaSanXuat = scanner.nextLine();
                            System.out.println("Nhập ngày nhập kho: ");
                            ngay = scanner.nextInt();
                            System.out.println("Nhập tháng nhập kho: ");
                            thang = scanner.nextInt();
                            System.out.println("Nhập năm nhập kho: ");
                            nam = scanner.nextInt();
                            ngayNhapKho = LocalDate.of(nam,thang,ngay);
                            danhSachHangHoa.them(new HangSanhSu(maHang,tenHang,donGia,soLuongTon,nhaSanXuat,ngayNhapKho));
                        }
                    }

                }
                case 3 -> System.out.println("Goodbye!");
                default -> System.out.println("Không có lựa chọn này.");
            }
        } while (choice != 0);
    }
}