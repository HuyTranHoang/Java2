import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {

            LocalDate ngaySanXuat = LocalDate.of(2023,5,31);
            LocalDate ngayHetHan = LocalDate.of(2023,6,30);
            HangThucPham hangThucPham = new HangThucPham("001","Trái cây",50000,ngaySanXuat,ngayHetHan);
            System.out.println(hangThucPham);

            LocalDate ngaySanXuat2 = LocalDate.of(2023,5,31);
            LocalDate ngayHetHan2 = LocalDate.of(2023,4,30);
            HangThucPham hangThucPham2 = new HangThucPham("002","Trái cây",50000,ngaySanXuat2,ngayHetHan2);
            System.out.println(hangThucPham2);

            LocalDate ngaySanXuat3 = LocalDate.of(2023,3,31);
            LocalDate ngayHetHan3 = LocalDate.of(2023,4,30);
            HangThucPham hangThucPham3 = new HangThucPham("003","Trái cây",45000,ngaySanXuat3,ngayHetHan3);
            System.out.println(hangThucPham3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}