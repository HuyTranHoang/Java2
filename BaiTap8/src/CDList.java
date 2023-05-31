import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CDList {

    private List<CD> list;
    private int listSize;

    public void khoiTao(int n) {
        list = new ArrayList<>(n);
        this.listSize = n;
    }

    public void themMot(CD cd) {
        boolean datSoLuongToiDa = list.size() >= listSize;
        boolean trungLapMaCD = list.stream()
                .filter(c -> c.getMaCD() == cd.getMaCD())
                .anyMatch(c -> c != cd);

        if (datSoLuongToiDa || trungLapMaCD) {
            return;
        }

        list.add(cd);
    }

    public int soLuongCDTrongList() {
        return list.size();
    }

    public double tongGiaThanhCD() {
        return list.stream().mapToDouble(CD::getGiaThanh).sum();
    }

    public void thongTinToanBoCD() {
        list.forEach(System.out::println);
    }

    public void sapXepGiamDanTheoGiaThanh() {
        this.list = list.stream()
                .sorted(Comparator.comparingDouble(CD::getGiaThanh).reversed())
                .collect(Collectors.toList());
    }

    public void sapXepTangDanTheoTuaCD() {
        this.list = list.stream()
                .sorted(Comparator.comparing(CD::getTuaCD))
                .collect(Collectors.toList());
    }
}
