import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HocVien {
    private String hoTen;
    private LocalDate namSinh;
    private List<Double> diemMonHoc;
    private List<String> monThiLaiList;

    public HocVien(String hoTen, LocalDate namSinh, List<Double> diemMonHoc) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diemMonHoc = diemMonHoc;
        this.monThiLaiList = new ArrayList<>();
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(LocalDate namSinh) {
        this.namSinh = namSinh;
    }

    public List<Double> getDiemMonHoc() {
        return diemMonHoc;
    }

    public void setDiemMonHoc(List<Double> diemMonHoc) {
        this.diemMonHoc = diemMonHoc;
    }

    public List<String> getMonThiLaiList() {
        return monThiLaiList;
    }

    public double diemTrungBinhMon() {
        double sum = 0;
        for (double diem : diemMonHoc) {
            sum += diem;
        }
        return sum / diemMonHoc.size();
    }

    public boolean coDiemTatCaMonTrenNam() {
        for (double diem : diemMonHoc) {
            if (diem < 5) {
                return false;
            }
        }
        return true;
    }

    public List<String> tenMonThiLai() {
        List<String> monThiLai = new ArrayList<>();
        for (int i = 0; i < diemMonHoc.size(); i++) {
            if (diemMonHoc.get(i) < 5) {
                monThiLai.add(tenMonHoc(i));
            }
        }
        return monThiLai;
    }

    private String tenMonHoc(int index) {
        String[] tenMonHoc = {"Toán", "Lý", "Hóa", "Tiếng Anh", "Lịch sử"};
        return tenMonHoc[index];
    }

    public boolean coLamLuanVan() {
        return diemTrungBinhMon() > 7 && coDiemTatCaMonTrenNam();
    }

    public boolean coThiTotNghiep() {
        return diemTrungBinhMon() <= 7 && coDiemTatCaMonTrenNam();
    }

    public boolean coThiLai() {
        return !coDiemTatCaMonTrenNam();
    }

}
