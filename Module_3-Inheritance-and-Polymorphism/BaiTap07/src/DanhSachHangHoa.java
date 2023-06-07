import java.util.*;

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
            if (hangHoaList[i].getMaHang().equals(hangHoa.getMaHang()))
                return;
        }
        this.hangHoaList[size] = hangHoa;
        count++;
    }

    public void inToanBo() {
        for (int i = 0; i < count; i++) {
            System.out.println(this.hangHoaList[i]);
        }
    }

    public void inTungLoai() {
        List<HangHoa> hangDienMay = new ArrayList<>();
        List<HangHoa> hangSanhSu = new ArrayList<>();
        List<HangHoa> hangThucPham = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            if (this.hangHoaList[i] instanceof HangDienMay)
                hangDienMay.add(this.hangHoaList[i]);
            else if (this.hangHoaList[i] instanceof HangSanhSu)
                hangSanhSu.add(this.hangHoaList[i]);
            else
                hangThucPham.add(this.hangHoaList[i]);
        }

        System.out.println("Danh sách hàng điện máy: ");
        System.out.println(hangDienMay);
        System.out.println("Danh sách hàng sành sứ: ");
        System.out.println(hangSanhSu);
        System.out.println("Danh sách hàng thực phẩm: ");
        System.out.println(hangThucPham);

    }

    public HangHoa timKiem(String maHang) {
        for (int i = 0; i < count; i++) {
            if (maHang.equals(this.hangHoaList[i].getMaHang()))
                return this.hangHoaList[i];
        }
        return null;
    }

    public void sapXepTheoTenTangDan() {
        Arrays.sort(this.hangHoaList, Comparator.comparing(HangHoa::getTenHang));
    }

    public void sapXepHangHoaTheoSoLuongGiamDan() {
        Arrays.sort(this.hangHoaList, Comparator.comparing(HangHoa::getSoLuongTon).reversed());
    }

    public void xuatHangThucPhamKhoBan() {
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
                return;
            }
        }

        this.size = tempHangHoaList.size();
        this.hangHoaList = (HangHoa[]) Arrays.stream(this.hangHoaList).toArray();
    }

    public void suaThongTinDonGia(String maHang) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            if (maHang.equals(this.hangHoaList[i].getMaHang())) {
                System.out.println("Nhập đơn giá mới của mã hàng " + maHang + ": ");
                this.hangHoaList[i].setDonGia(scanner.nextDouble());
                return;
            }
        }

        System.out.println("Không tìm thấy mã hàng " + maHang);
    }

}
