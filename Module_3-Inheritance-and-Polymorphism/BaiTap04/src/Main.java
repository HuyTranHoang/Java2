import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        GiaoDichDat giaoDichDat1 = new GiaoDichDat(1, LocalDate.of(2023,6,6),
                500000,500,LoaiDat.A);
        GiaoDichDat giaoDichDat2 = new GiaoDichDat(2, LocalDate.of(2023,4,3),
                100000,100,LoaiDat.B);
        GiaoDichDat giaoDichDat3 = new GiaoDichDat(3, LocalDate.of(2023,5,2),
                200000,200,LoaiDat.C);

        GiaoDichNha giaoDichNha1 = new GiaoDichNha(4,LocalDate.of(2023,1,2),
                200000,100,LoaiNha.THUONG,"Bình Thạnh HCM");
        GiaoDichNha giaoDichNha2 = new GiaoDichNha(5,LocalDate.of(2023,1,2),
                500000,200,LoaiNha.CAO_CAP,"Bình Thạnh HCM");
        GiaoDichNha giaoDichNha3 = new GiaoDichNha(6,LocalDate.of(2013,9,2),
                400000,200,LoaiNha.THUONG,"Bình Thạnh HCM");

        List<GiaoDich> giaoDichList = new ArrayList<>();
        giaoDichList.addAll(Arrays.asList(giaoDichDat1,giaoDichDat2,giaoDichDat3,giaoDichNha1,giaoDichNha2,giaoDichNha3));

        long soLuongGiaolDichDat = giaoDichList.stream()
                .filter(giaoDich -> giaoDich instanceof GiaoDichDat)
                .count();

        long soLuongGiaoDichNha = giaoDichList.stream()
                .filter(giaoDich -> giaoDich instanceof GiaoDichNha)
                .count();

        double trungBinhThanhTienGDD = giaoDichList.stream()
                .filter(giaoDich -> giaoDich instanceof GiaoDichDat)
                .mapToDouble(GiaoDich::thanhTien)
                .average()
                .orElse(Double.NaN);

        System.out.println("Số lượng giao dịch đất: " + soLuongGiaolDichDat);
        System.out.println("Số lượng giao dịch nhà: " + soLuongGiaoDichNha);
        System.out.println("Trung bình thành tiền giao dịch đất: " + trungBinhThanhTienGDD);

        System.out.println("Các giao dịch của tháng 9 năm 2013");
        List<GiaoDich> giaoDichTimKiem = giaoDichList.stream()
                .filter(giaoDich -> giaoDich.getNgayGiaoDich().getMonthValue() == 9 && giaoDich.getNgayGiaoDich().getYear() == 2013)
                .toList();
        System.out.println(giaoDichTimKiem);

    }
}