import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GiaoDichTienTe giaoDichTienTe1 = new GiaoDichTienTe(1, LocalDate.of(2023,6,6),
                100000, 2, 2, LoaiTien.VIET_NAM);
        GiaoDichTienTe giaoDichTienTe2 = new GiaoDichTienTe(2, LocalDate.of(2023,4,4),
                200000, 4, 1.25, LoaiTien.EURO);
        GiaoDichTienTe giaoDichTienTe3 = new GiaoDichTienTe(3, LocalDate.of(2023,5,5),
                300000, 6, 1.50, LoaiTien.USD);


        GiaoDichVang giaoDichVang1 = new GiaoDichVang(4,LocalDate.of(2023,1,1),
                100000,3,"9999");
        GiaoDichVang giaoDichVang2 = new GiaoDichVang(5,LocalDate.of(2023,2,2),
                100000,6,"9999");
        GiaoDichVang giaoDichVang3 = new GiaoDichVang(6,LocalDate.of(2023,3,3),
                2000000000,9,"9999");

        List<GiaoDich> giaoDichList = new ArrayList<>();
        giaoDichList.addAll(Arrays.asList(giaoDichTienTe1,giaoDichTienTe2,giaoDichTienTe3,giaoDichVang1,giaoDichVang2,giaoDichVang3));

        int soLuongGiaoDichTienTe = giaoDichList.stream()
                .filter(giaoDich -> giaoDich instanceof GiaoDichTienTe)
                .mapToInt(GiaoDich::getSoLuong)
                .sum();

        int soLuongGiaoDichVang = giaoDichList.stream()
                .filter(giaoDich -> giaoDich instanceof GiaoDichVang)
                .mapToInt(GiaoDich::getSoLuong)
                .sum();

        double trungBinhThanhTienGDTT = giaoDichList.stream()
                .filter(giaoDich -> giaoDich instanceof GiaoDichTienTe)
                .mapToDouble(GiaoDich::thanhTien)
                .average()
                .orElse(Double.NaN);

        System.out.println("Số lượng giao dịch tiền tệ: " + soLuongGiaoDichTienTe);
        System.out.println("Số lượng giao dịch vàng: " + soLuongGiaoDichVang);
        System.out.println("Trung bình thành tiền của giao dịch tiền tệ: " + trungBinhThanhTienGDTT);
        System.out.println("Các giao dịch có đơn giá > 1 tỷ");
        giaoDichList.forEach(giaoDich -> {
            if (giaoDich.getDonGia() > 1000000000)
                System.out.println(giaoDich);
        });

    }
}