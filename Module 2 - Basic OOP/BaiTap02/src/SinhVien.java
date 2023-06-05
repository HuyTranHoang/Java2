public class SinhVien {
    private int maSV;
    private String hoTen;
    private float diemLT, diemTH;

    public SinhVien() {
        this.maSV = 0;
        this.hoTen = "Sinh viên";
        this.diemLT = 5;
        this.diemTH = 5;
    }

    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        if (maSV > 0) {
            this.maSV = maSV;
        } else this.maSV = 0;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen.length() > 0) {
            this.hoTen = hoTen;
        } else this.hoTen = "Sinh viên";
    }

    public float getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        if (diemLT >= 0 && diemLT <= 10) {
            this.diemLT = diemLT;
        } else this.diemLT = 5;
    }

    public float getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        if (diemTH >= 0 && diemTH <= 10) {
            this.diemTH = diemTH;
        } else this.diemTH = 5;
    }

    public float tinhDiemTB() {
        return (this.diemLT + this.diemTH) / 2;
    }
}
