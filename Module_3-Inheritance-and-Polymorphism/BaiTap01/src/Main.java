import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ChuyenXe> dsChuyenXe = new ArrayList<>();

        ChuyenXeNgoaiThanh chuyenXeNgoaiThanh = new ChuyenXeNgoaiThanh(1,"Nguyễn Văn A",
                "1234-56",50000,"Long An", 30);
        ChuyenXeNgoaiThanh chuyenXeNgoaiThanh2 = new ChuyenXeNgoaiThanh(2,"Trần Hoàng B",
                "7891-55",150000,"Bình Dương", 60);

        ChuyenXeNoiThanh chuyenXeNoiThanh = new ChuyenXeNoiThanh(3,"Nguyễn Thị Lan Anh",
                "1111-25",40000,15,5000);
        ChuyenXeNoiThanh chuyenXeNoiThanh2 = new ChuyenXeNoiThanh(4,"Lê Vương",
                "2222-35",80000,25,4500);

        dsChuyenXe.add(chuyenXeNgoaiThanh);
        dsChuyenXe.add(chuyenXeNgoaiThanh2);

        dsChuyenXe.add(chuyenXeNoiThanh);
        dsChuyenXe.add(chuyenXeNoiThanh2);

        double doanhThuNgoaiThanh = dsChuyenXe.stream()
                .filter(chuyenXe -> chuyenXe instanceof ChuyenXeNgoaiThanh)
                .mapToDouble(ChuyenXe::getDoanhThu)
                .sum();
        double doanhThuNoiThanh = dsChuyenXe.stream()
                .filter(chuyenXe -> chuyenXe instanceof ChuyenXeNoiThanh)
                .mapToDouble(ChuyenXe::getDoanhThu)
                .sum();


        System.out.println("Tổng doanh thu: " + (doanhThuNgoaiThanh + doanhThuNoiThanh));
        System.out.println("Doanh thu ngoại thành: " + doanhThuNgoaiThanh);
        System.out.println("Doanh thu nội thành: " + doanhThuNoiThanh);


    }
}