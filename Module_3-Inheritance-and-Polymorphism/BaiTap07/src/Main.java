import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("8. Xuất các hàng thực phầm khó bán");;
            System.out.println("9. Xoá hàng hoá khi biết mã hàng");
            System.out.println("10. Sửa thông tin đơn giá khi biết mã hàng");
            System.out.println("----");
            System.out.println("0. Thoát chương trình");

            System.out.println("Lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Nhập số lượng phần tử trong danh sách: ");
                    danhSachHangHoa = new DanhSachHangHoa(scanner.nextInt());
                }
                case 2 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else {
                        System.out.println("1. Hàng điện máy");
                        System.out.println("2. Hàng sành sứ");
                        System.out.println("3. Hàng thực phẩm");
                        System.out.println("Nhập loại hàng hoá bạn muốn nhập: ");
                        int loaiHangHoa = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Nhập mã hàng: ");
                        String maHang = scanner.nextLine();
                        System.out.println("Nhập tên hàng: ");
                        String tenHang = scanner.nextLine();
                        System.out.println("Nhập đơn giá: ");
                        double donGia = scanner.nextDouble();
                        System.out.println("Nhập số luợng tồn: ");
                        int soLuongTon = scanner.nextInt();

                        switch (loaiHangHoa) {
                            case 1 -> {
                                int thoiGianBaoHanh;
                                double congSuat;
                                System.out.println("Nhập thời gian bảo hành: ");
                                thoiGianBaoHanh = scanner.nextInt();
                                System.out.println("Nhập công suất: ");
                                congSuat = scanner.nextDouble();
                                danhSachHangHoa.them(new HangDienMay(maHang, tenHang, donGia, soLuongTon, thoiGianBaoHanh, congSuat));
                            }
                            case 2 -> {
                                scanner.nextLine();
                                System.out.println("Nhập nhà sản xuất: ");
                                String nhaSanXuat = scanner.nextLine();
                                System.out.println("Nhập ngày nhập kho (dd/MM/yyyy): ");
                                String ngayNhapKhoString = scanner.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate ngayNhapKho = LocalDate.parse(ngayNhapKhoString, formatter);
                                danhSachHangHoa.them(new HangSanhSu(maHang, tenHang, donGia, soLuongTon, nhaSanXuat, ngayNhapKho));
                            }
                            case 3 -> {
                                scanner.nextLine();
                                System.out.println("Nhập nhà cung cấp: ");
                                String nhaCungCap = scanner.nextLine();
                                System.out.println("Nhập ngày sản xuất (dd/MM/yyyy): ");
                                String ngaySanXuatString = scanner.nextLine();
                                System.out.println("Nhập ngày hết hạn (dd/MM/yyyy): ");
                                String ngayHetHanString = scanner.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate ngaySanXuat = LocalDate.parse(ngaySanXuatString, formatter);
                                LocalDate ngayHetHan = LocalDate.parse(ngayHetHanString, formatter);
                                danhSachHangHoa.them(new HangThucPham(maHang, tenHang, donGia, soLuongTon, nhaCungCap, ngaySanXuat, ngayHetHan));
                            }
                        }
                    }
                }
                case 3 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else
                        danhSachHangHoa.inToanBo();
                }
                case 4 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else
                        danhSachHangHoa.inTungLoai();
                }
                case 5 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else {
                        System.out.println("Nhập mã hàng hoá cần tìm kiếm: ");
                        scanner.nextLine();
                        String maHangHoa = scanner.nextLine();
                        HangHoa hangHoaTimDuoc = danhSachHangHoa.timKiem(maHangHoa);
                        System.out.println("Thông tin hàng hoá có mã " + maHangHoa + ": ");
                        System.out.println(hangHoaTimDuoc);
                    }
                }
                case 6 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else {
                        danhSachHangHoa.sapXepTheoTenTangDan();
                        System.out.printf("Danh sách sau khi sắp xếp: ");
                        danhSachHangHoa.inToanBo();
                    }
                }
                case 7 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else {
                        danhSachHangHoa.sapXepHangHoaTheoSoLuongGiamDan();
                        System.out.printf("Danh sách sau khi sắp xếp: ");
                        danhSachHangHoa.inToanBo();
                    }
                }
                case 8 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else
                        danhSachHangHoa.xuatHangThucPhamKhoBan();

                }
                case 9 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else {
                        System.out.println("Nhập mã hàng hoá cần xoá: ");
                        scanner.nextLine();
                        String maHangHoa = scanner.nextLine();
                        danhSachHangHoa.xoaHangHoa(maHangHoa);
                    }
                }
                case 10 -> {
                    if (danhSachHangHoa == null)
                        System.out.println("Lỗi: Bạn chưa nhập số lượng phần tử cho danh sách");
                    else {
                        System.out.println("Nhập mã hàng hoá cần sửa: ");
                        scanner.nextLine();
                        String maHangHoa = scanner.nextLine();
                        danhSachHangHoa.suaThongTinDonGia(maHangHoa);
                    }
                }
                case 0 -> System.out.println("Good bye!!!");
                default -> System.out.println("Không có lựa chọn này.");
            }
        } while (choice != 0);
    }
}