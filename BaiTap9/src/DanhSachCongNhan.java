import java.util.ArrayList;
import java.util.List;

public class DanhSachCongNhan {
    private List<CongNhan> list;
    private int listSize;

    public DanhSachCongNhan(int listSize) {
        this.list = new ArrayList<>(listSize);
        this.listSize = listSize;
    }

    public void them(CongNhan congNhan) {
        if (list.size() >= listSize) {
            return;
        }

        list.add(congNhan);
    }

    public void xuatThongTin() {
        for (CongNhan cn: list) {
            System.out.println(cn);
        }
    }

    public int soLuongCongNhan() {
        return list.size();
    }

    public void congNhanLamTrenHaiTram() {
        for (CongNhan cn: list) {
            if (cn.getmSoSP() > 200)
                System.out.println(cn);
        }
    }

    public void sapXepTheoSoSanPhamGiamDan() {
        list.sort((cn1, cn2) -> Integer.compare(cn1.getmSoSP(), cn2.getmSoSP()));
    }
}
