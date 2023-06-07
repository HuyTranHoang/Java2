import java.util.*;
import java.util.stream.Collectors;

public class DanhSachHangHoa {
    private HangHoa[] hangHoaList;
    private int size;
    private int count;

    public DanhSachHangHoa(int size) {
        this.hangHoaList = new HangHoa[size];
        this.size = size;
        this.count = 0;
    }

    public void them(HangHoa hangHoa) {
        for (int i = 0; i < count; i++) {
            if (hangHoaList[i].getMaHang().equals(hangHoa.getMaHang())) {
                System.out.println("Lỗi: Mã hàng hoá này đã có tồn tại trong danh sách");
                return;
            }
        }
        this.hangHoaList[count] = hangHoa;
        count++;
    }

    public void inToanBo() {
        System.out.println("Thông tin toàn bộ hàng hoá: ");
        if (count != 0)
            for (int i = 0; i < count; i++) {
                System.out.println(this.hangHoaList[i]);
            }
        else System.out.println("Danh sách hàng hoá trống");
    }

    public void inTungLoai() {
        System.out.println("Thông tin theo từng loại hàng hoá: ");
        Map<Class<? extends HangHoa>, List<HangHoa>> loaiHangHoaMap = Arrays.stream(hangHoaList)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(HangHoa::getClass));

        loaiHangHoaMap.forEach((hangHoaClass, hangHoaList) -> {
            System.out.println("Danh sách hàng " + hangHoaClass.getSimpleName() + ": ");
            System.out.println(hangHoaList);
        });
    }

    public HangHoa timKiem(String maHang) {
        for (int i = 0; i < count; i++) {
            if (maHang.equals(this.hangHoaList[i].getMaHang()))
                return this.hangHoaList[i];
        }
        return null;
    }

    public void sapXepTheoTenTangDan() {
        hangHoaList = Arrays.stream(hangHoaList)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(HangHoa::getTenHang))
                .toArray(HangHoa[]::new);
    }

    public void sapXepHangHoaTheoSoLuongGiamDan() {
        hangHoaList = Arrays.stream(hangHoaList)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(HangHoa::getSoLuongTon).reversed())
                .toArray(HangHoa[]::new);
        // Loại bỏ các phần tử null khỏi mảng hangHoaList
//        HangHoa[] nonNullHangHoaList = Arrays.stream(hangHoaList)
//                .filter(Objects::nonNull)
//                .toArray(HangHoa[]::new);
        // Sắp xếp mảng nonNullHangHoaList theo số lượng tồn giảm dần
//        Arrays.sort(nonNullHangHoaList, Comparator.comparing(HangHoa::getSoLuongTon).reversed());

        // Gán kết quả vào mảng hangHoaList ban đầu
//        System.arraycopy(nonNullHangHoaList, 0, hangHoaList, 0, nonNullHangHoaList.length);
    }

    public void xuatHangThucPhamKhoBan() {
        System.out.println("Những thực phẩm có mức độ bán buôn là khó bán: ");
        for (int i = 0; i < count; i++) {
            if(this.hangHoaList[i].mucDoBanBuon() == MucDoBanBuon.KHO_BAN)
                System.out.println(this.hangHoaList[i]);
        }
    }

    public void xoaHangHoa(String maHang) {
        List<HangHoa> tempHangHoaList = new ArrayList<>(Arrays.asList(this.hangHoaList));
        for (int i = 0; i < tempHangHoaList.size(); i++) {
            if (maHang.equals(tempHangHoaList.get(i).getMaHang())) {
                tempHangHoaList.remove(i);
                System.out.println("Xoá thành công");
                this.count = this.count - 1;
                this.hangHoaList = tempHangHoaList.toArray(new HangHoa[0]);
                return;
            }
        }
        System.out.println("Không tìm thấy mã hàng " + maHang);
    }

    public void suaThongTinDonGia(String maHang) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            if (maHang.equals(this.hangHoaList[i].getMaHang())) {
                System.out.println("Nhập đơn giá mới của mã hàng " + maHang + ": ");
                this.hangHoaList[i].setDonGia(scanner.nextDouble());
                System.out.println("Sửa đơn giá thành công");
                return;
            }
        }

        System.out.println("Không tìm thấy mã hàng " + maHang);
    }

}
