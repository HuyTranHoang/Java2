import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {

            LocalDate ngaySanXuat = LocalDate.of(2023,5,31);
            LocalDate ngayHetHan = LocalDate.of(2023,6,30);
            HangThucPham hangThucPham = new HangThucPham("001","Trái cây",50000,ngaySanXuat,ngayHetHan);
            System.out.println(hangThucPham);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}