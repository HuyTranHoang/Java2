public class CongNhan {
    private String maCN;
    private String mHo;
    private String mTen;
    private int mSoSP;

    public CongNhan() {
    }

    public CongNhan(String maCN, String mHo, String mTen, int mSoSP) {
        this.maCN = maCN;
        this.mHo = mHo;
        this.mTen = mTen;
        if (mSoSP < 0)
            this.mSoSP = 1;
        else
            this.mSoSP = mSoSP;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getmHo() {
        return mHo;
    }

    public void setmHo(String mHo) {
        this.mHo = mHo;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public int getmSoSP() {
        return mSoSP;
    }

    public void setmSoSP(int mSoSP) {
        if (mSoSP < 0)
            this.mSoSP = 1;
        else
            this.mSoSP = mSoSP;
    }

    public double tinhLuong() {
        double donGia;
        if (this.mSoSP <= 199)
            donGia = 0.5;
        else if (this.mSoSP <= 399)
            donGia = 0.55;
        else if (this.mSoSP <= 599)
            donGia = 0.6;
        else
            donGia = 0.65;

        return mSoSP * donGia;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "maCN='" + maCN + '\'' +
                ", mHo='" + mHo + '\'' +
                ", mTen='" + mTen + '\'' +
                ", mSoSP=" + mSoSP +
                ", luongCN=" + tinhLuong() +
                '}';
    }
}
