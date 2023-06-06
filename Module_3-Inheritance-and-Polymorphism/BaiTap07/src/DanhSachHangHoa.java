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

}
