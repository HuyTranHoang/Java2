public enum VAT {
    HANG_DIEN_MAY(0.1),
    HANG_SANH_SU(0.1),
    HANG_THUC_PHAM(0.05);

    private final double value;

    VAT(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
