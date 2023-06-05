import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<HocVien> danhSachHocVien = new ArrayList<>();

        danhSachHocVien.add(new HocVien("Trần Văn A", LocalDate.of(1995,12,20), List.of(8.5,7.0,9.0,6.5,8.0)));
        danhSachHocVien.add(new HocVien("Tran Thi B", LocalDate.of(2001,5,1), List.of(6.5, 7.0, 5.5, 8.0, 9.0)));
        danhSachHocVien.add(new HocVien("Le Van C", LocalDate.of(1997,11,30), List.of(7.0, 7.0, 8.5, 6.0, 6.0)));
        danhSachHocVien.add(new HocVien("Pham Thi D", LocalDate.of(1998,9,25), List.of(9.0, 9.0, 9.0, 9.0, 9.0)));
        danhSachHocVien.add(new HocVien("Hoang Van E", LocalDate.of(2000,4,15), List.of(6.0, 6.0, 6.0, 1.0, 1.0)));


        int soLuongLuanVan = 0;
        int soLuongThiTotNghiep = 0;
        int soLuongThiLai = 0;
        List<String> monThiLai = new ArrayList<>();

        for (HocVien hocVien : danhSachHocVien) {
            if (hocVien.coLamLuanVan()) {
                soLuongLuanVan++;
            } else if (hocVien.coThiTotNghiep()) {
                soLuongThiTotNghiep++;
            } else if (hocVien.coThiLai()) {
                soLuongThiLai++;
                monThiLai.addAll(hocVien.monThiLai());
            }
        }

        System.out.println("Số lượng học viên làm luận văn tốt nghiệp: " + soLuongLuanVan);
        System.out.println("Số lượng học viên thi tốt nghiệp: " + soLuongThiTotNghiep);
        System.out.println("Số lượng học viên phải thi lại: " + soLuongThiLai);
        System.out.println("Các môn học viên phải thi lại: " + monThiLai);
    }
}