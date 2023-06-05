import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ChuyenXeNgoaiThanh> dsXeNgoaiThanh = new ArrayList<>();
        List<ChuyenXeNoiThanh> dsXeNoiThanh = new ArrayList<>();

        ChuyenXeNgoaiThanh chuyenXeNgoaiThanh = new ChuyenXeNgoaiThanh(1,"Nguyễn Văn A",
                "1234-56",50000,"Long An", 30);
        ChuyenXeNgoaiThanh chuyenXeNgoaiThanh2 = new ChuyenXeNgoaiThanh(2,"Trần Hoàng B",
                "7891-55",150000,"Bình Dương", 60);

        ChuyenXeNoiThanh chuyenXeNoiThanh = new ChuyenXeNoiThanh(3,"Nguyễn Thị Lan Anh",
                "1111-25",40000,15,5000);
        ChuyenXeNoiThanh chuyenXeNoiThanh2 = new ChuyenXeNoiThanh(4,"Lê Vương",
                "2222-35",80000,25,4500);

        dsXeNgoaiThanh.add(chuyenXeNgoaiThanh);
        dsXeNgoaiThanh.add(chuyenXeNgoaiThanh2);

        dsXeNoiThanh.add(chuyenXeNoiThanh);
        dsXeNoiThanh.add(chuyenXeNoiThanh2);

//        Foreach tính tổng doanh thu
//        for (ChuyenXe chuyenXe: dsXeNgoaiThanh) {
//            doanhThuNgoaiThanh += chuyenXe.getDoanhThu();
//        }
//
//        for (ChuyenXe chuyenXe: dsXeNoiThanh) {
//            doanhThuNoiThanh += chuyenXe.getDoanhThu();
//        }

//        Stream api để tính tổng doanh thu
        double doanhThuNgoaiThanh = dsXeNgoaiThanh.stream().mapToDouble(ChuyenXe::getDoanhThu).sum();
        double doanhThuNoiThanh = dsXeNoiThanh.stream().mapToDouble(ChuyenXe::getDoanhThu).sum();


        System.out.println("Tổng doanh thu: " + (doanhThuNgoaiThanh + doanhThuNoiThanh));
        System.out.println("Doanh thu ngoại thành: " + doanhThuNgoaiThanh);
        System.out.println("Doanh thu nội thành: " + doanhThuNoiThanh);


    }
}