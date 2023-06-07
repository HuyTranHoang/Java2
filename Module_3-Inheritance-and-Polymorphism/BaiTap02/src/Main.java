import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        List<Sach> sachList = new ArrayList<>();

        SachGiaoKhoa sachGiaoKhoa1 = new SachGiaoKhoa(1, LocalDate.of(2023,6,6),
                5000,5,"Nguyễn Nhật Ánh",TinhTrang.MOI);
        SachGiaoKhoa sachGiaoKhoa2 = new SachGiaoKhoa(2, LocalDate.of(2023,3,3),
                15000,5,"Nguyễn Văn A",TinhTrang.MOI);
        SachGiaoKhoa sachGiaoKhoa3 = new SachGiaoKhoa(3, LocalDate.of(2022,12,12),
                10000,2,"K",TinhTrang.CU);



        SachThamKhao sachThamKhao1 = new SachThamKhao(4,LocalDate.of(2022,8,8),
                4000,4,"Tuyết Sơn", 500);
        SachThamKhao sachThamKhao2 = new SachThamKhao(5,LocalDate.of(2022,4,7),
                8000,6,"Lý My", 500);
        SachThamKhao sachThamKhao3 = new SachThamKhao(6,LocalDate.of(2022,5,6),
                6000,8,"Sơn Đặng", 500);

        sachList.addAll(Arrays.asList(sachGiaoKhoa1,sachGiaoKhoa2,sachGiaoKhoa3,
                sachThamKhao1,sachThamKhao2,sachThamKhao3));

        double tongTienSachGiaoKhoa = 0;
        double tongTienSachThamKhao = 0;
        int soLuongSachThamKhao = 0;

        for (Sach sach: sachList) {
            if (sach instanceof SachGiaoKhoa)
                tongTienSachGiaoKhoa += sach.thanhTien();
            else
                tongTienSachThamKhao += sach.thanhTien();
            soLuongSachThamKhao++;
        }

        System.out.println("Tổng tiền sách giáo khoa: " + tongTienSachGiaoKhoa);
        System.out.println("Tổng tền sách tham khảo: " + tongTienSachThamKhao);
        System.out.println("Trung bình cộng đơn giá của các sách tham khảo: " + String.format("%.2f", tongTienSachThamKhao/soLuongSachThamKhao));
        System.out.println("Sách giáo khoa của nhà xuất bản K: ");
        List<Sach> sachTimKiem =  sachList.stream()
                .filter(sach -> sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equals("K"))
                .toList();
        sachTimKiem.forEach(System.out::println);


    }
}