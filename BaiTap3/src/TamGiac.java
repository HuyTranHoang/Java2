public class TamGiac {
    private float ma, mb, mc;

    public TamGiac() {
    }

    public TamGiac(float ma, float mb, float mc) {
        if (this.kiemTraTamGiac(ma,mb,mc)) {
            this.ma = ma;
            this.mb = mb;
            this.mc = mc;
        } else {
            this.ma = 0;
            this.mb = 0;
            this.mc = 0;
        }
    }

    public float getMa() {
        return ma;
    }

    public void setMa(float ma) {
        if (ma > 0)
            this.ma = ma;
    }

    public float getMb() {
        return mb;
    }

    public void setMb(float mb) {
        if (mb > 0)
            this.mb = mb;
    }

    public float getMc() {
        return mc;
    }

    public void setMc(float mc) {
        if (mc > 0)
            this.mc = mc;
    }

    public boolean kiemTraTamGiac(float ma, float mb, float mc) {
        return ma + mb >= mc && ma + mc >= mb && mb + mc >= ma && ma > 0 && mb > 0 && mc > 0;
    }

    public float tinhChuVi() {
        return (this.ma + this.mb + this.mc) / 2;
    }

    public float tinhDienTich() {
        float chuVi = this.tinhChuVi();
        return (float) Math.sqrt(chuVi * (chuVi - this.ma) * (chuVi - this.mb) * (chuVi - this.mc));
    }

    public String thongTinTamGiac() {
        if (kiemTraTamGiac(this.ma,this.mb,this.mc)) {
            if (this.ma == this.mb && this.mb == this.mc) {
                return "Đây là tam giác đều";
            } else if (this.ma == this.mb || this.ma == this.mc || this.mb == this.mc) {
                return "Đây là tam giác cân";
            } else {
                return "Đây là tam giác thường";
            }
        }
        return "Không phải là tam giác";
    }

    @Override
    public String toString() {
        return "TamGiac{" +
                "ma=" + ma +
                ", mb=" + mb +
                ", mc=" + mc +
                ", " + thongTinTamGiac() +
                ", chuVi=" + tinhChuVi() +
                ", dienTich=" +tinhDienTich() +
                '}';
    }
}
