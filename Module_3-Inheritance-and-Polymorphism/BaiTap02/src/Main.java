import java.time.LocalDate;
import java.util.ArrayList;
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
                10000,2,"Lê Văn C",TinhTrang.CU);

        sachList.add(sachGiaoKhoa1);
        sachList.add(sachGiaoKhoa2);
        sachList.add(sachGiaoKhoa3);

        SachThamKhao sachThamKhao1 = new SachThamKhao(1,LocalDate.of(2022,8,8),
                4000,4,"Tuyết Sơn", 500);
        SachThamKhao sachThamKhao2 = new SachThamKhao(1,LocalDate.of(2022,4,7),
                8000,6,"Lý My", 500);
        SachThamKhao sachThamKhao3 = new SachThamKhao(1,LocalDate.of(2022,5,6),
                6000,8,"Sơn Đặng", 500);

        sachList.add(sachThamKhao1);
        sachList.add(sachThamKhao2);
        sachList.add(sachGiaoKhoa3);

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

    }
}