import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TrungTamDaoTao trungTam = new TrungTamDaoTao();
        List<HocVien> danhSachHocVienJava = new ArrayList<>();
        List<HocVien> danhSachHocVienWeb = new ArrayList<>();

//        Tạo 2 khoá học
        KhoaHoc khoaHocJava = new KhoaHoc("Lập trình Java căn bản",
                        LocalDate.of(2023,6,6),
                        "18:00 - 20:00",
                danhSachHocVienJava);
        KhoaHoc khoaHocWeb = new KhoaHoc("Lập trình web",
                LocalDate.of(2023,7,7),
                "18:00 - 20:00",
                danhSachHocVienWeb);

        trungTam.themKhoaHoc(khoaHocJava);
        trungTam.themKhoaHoc(khoaHocWeb);

//        Tạo 3 học viên
        HocVien hocVien1 = new HocVien("Nguyễn Văn A",
                "123 Quận Bình Thành, TP HCM",
                "0123456789");

        HocVien hocVien2 = new HocVien("Trần Hoàng B",
                "456 Quận 1, TP HCM",
                "0123456789");

        HocVien hocVien3 = new HocVien("Nguyễn Thị C",
                "789 Quận 12, TP HCM",
                "0123456789");

        khoaHocJava.themHocVien(hocVien1);
        khoaHocJava.themHocVien(hocVien2);
        khoaHocWeb.themHocVien(hocVien2);
        khoaHocWeb.themHocVien(hocVien3);


        // Tìm kiếm khoá học
        List<KhoaHoc> khoaHocTimKiem = trungTam.timKhoaHoc("Java");
        if (khoaHocTimKiem != null) {
            System.out.println("Tìm thấy khoá học: ");
            khoaHocTimKiem.forEach(System.out::println);
        } else {
            System.out.println("Không tìm thấy khoá học");
        }

        // Tìm kiếm các khoá học chưa bắt đầu
        List<KhoaHoc> khoaHocChuaBatDau = trungTam.timKhoaHocChuaBatDau();
        System.out.println("Các khoá học chưa bắt đầu:");
        if (khoaHocChuaBatDau.size() == 0)
            System.out.println("Không có");
        else
            for (KhoaHoc khoaHoc : khoaHocChuaBatDau) {
                System.out.println(khoaHoc.getTenKhoaHoc());
            }

        // Tìm kiếm các khoá học chưa kết thúc ( Giả sử kết thúc sau 30 ngày bắt đầu )
        List<KhoaHoc> khoaHocChuaKetThuc = trungTam.timKhoaHocChuaKetThuc();
        System.out.println("Các khoá học chưa kết thúc:");
        if (khoaHocChuaKetThuc.size() == 0)
            System.out.println("Không có");
        else
            for (KhoaHoc khoaHoc : khoaHocChuaKetThuc) {
                System.out.println(khoaHoc.getTenKhoaHoc());
            }

        // Tìm kiếm các khoá học của một học viên 1
        List<KhoaHoc> khoaHocCuaHocVien = trungTam.timKhoaHocCuaHocVien(hocVien1);
        System.out.println("Các khoá học của học viên " + hocVien1.getHoTen() + ":");
        for (KhoaHoc khoaHoc : khoaHocCuaHocVien) {
            System.out.println(khoaHoc.getTenKhoaHoc());
        }

    }
}