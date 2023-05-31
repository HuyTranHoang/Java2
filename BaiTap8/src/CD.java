public class CD {
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    public CD() {
        this.maCD = 999999;
        this.tuaCD = "chưa xác định";
        this.soBaiHat = 99;
        this.giaThanh = 999999;
    }

    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        if (maCD < 0)
            this.maCD = 999999;
        else
            this.maCD = maCD;

        if (tuaCD.isEmpty())
            this.tuaCD = "chưa xác định";
        else
            this.tuaCD = tuaCD;

        if (soBaiHat <= 0)
            this.soBaiHat = 99;
        else
            this.soBaiHat = soBaiHat;

        if (giaThanh <= 0)
            this.giaThanh = 999999;
        else
            this.giaThanh = giaThanh;
    }

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if (maCD < 0)
            this.maCD = 999999;
        else
            this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD.isEmpty())
            this.tuaCD = "chưa xác định";
        else
            this.tuaCD = tuaCD;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat <= 0)
            this.soBaiHat = 99;
        else
            this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh <= 0)
            this.giaThanh = 999999;
        else
            this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return "CD{" +
                "maCD=" + maCD +
                ", tuaCD='" + tuaCD + '\'' +
                ", soBaiHat=" + soBaiHat +
                ", giaThanh=" + giaThanh +
                '}';
    }
}
