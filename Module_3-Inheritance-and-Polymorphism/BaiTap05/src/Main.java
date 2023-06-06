import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        KhachHangVietNam khachHangVietNam1 = new KhachHangVietNam(1,"Trần Huy",
                LocalDate.of(2023,6,6),
                100,5000,DoiTuongKhachHang.KINH_DOANH,200);
        KhachHangVietNam khachHangVietNam2 = new KhachHangVietNam(2,"Trần Dat",
                LocalDate.of(2023,4,4),
                200,6000,DoiTuongKhachHang.SAN_XUAT,200);
        KhachHangVietNam khachHangVietNam3 = new KhachHangVietNam(1,"Huỳnh Bảo",
                LocalDate.of(2018,9,5),
                150,4000,DoiTuongKhachHang.KINH_DOANH,100);

        KhachHangNuocNgoai khachHangNuocNgoai1 = new KhachHangNuocNgoai(4,"John",
                LocalDate.of(2023,2,2),
                100,5000,"Mỹ");
        KhachHangNuocNgoai khachHangNuocNgoai2 = new KhachHangNuocNgoai(5,"Cena",
                LocalDate.of(2023,2,2),
                200,6000,"Anh");
        KhachHangNuocNgoai khachHangNuocNgoai3 = new KhachHangNuocNgoai(6,"Ricardo",
                LocalDate.of(2018,9,2),
                50,4000,"Hàn Quốc");

        List<KhachHang> khachHangList = new ArrayList<>(
                Arrays.asList(khachHangVietNam1, khachHangVietNam2, khachHangVietNam3,
                        khachHangNuocNgoai1, khachHangNuocNgoai2, khachHangNuocNgoai3));
        long soLuongKhachHangVietNam = khachHangList.stream()
                .filter(khachHang -> khachHang instanceof KhachHangVietNam)
                .count();
        long soLuongKhachHangNuocNgoai = khachHangList.stream()
                .filter(khachHang -> khachHang instanceof KhachHangNuocNgoai)
                .count();

        double trungBinhThanhTienKHNN = khachHangList.stream()
                .filter(khachHang -> khachHang instanceof KhachHangNuocNgoai)
                .mapToDouble(KhachHang::thanhTien)
                .average()
                .orElse(Double.NaN);

        List<KhachHang> khachHangTimKiemList = khachHangList.stream()
                .filter(khachHang -> khachHang.getNgayLapHoaDon().getMonthValue() == 9 && khachHang.getNgayLapHoaDon().getYear() == 2018)
                .toList();

        System.out.println("Số lượng khách hàng Việt Nam: " + soLuongKhachHangVietNam);
        System.out.println("Số lượng khách hàng nước ngoài: " + soLuongKhachHangNuocNgoai);
        System.out.println("Trung bình thành tiền khách hàng nước ngoài: " + trungBinhThanhTienKHNN);
        System.out.println("Danh sách khách hàng lập hoá đơn vào tháng 09, năm 2018");
        khachHangTimKiemList.forEach(System.out::println);
    }
}