public class Main {
    public static void main(String[] args) {
//        Tạo 3 đối tượng CongNhan
        CongNhan cn1 = new CongNhan("001","Trần","Huy",300);
        CongNhan cn2 = new CongNhan("002","Huỳnh","Bảo",150);
        CongNhan cn3 = new CongNhan("003","Trần","Đạt",450);

//        Khởi tạo lớp danh sách công nhân chứa với 2 phần tử
        DanhSachCongNhan list = new DanhSachCongNhan(2);
//        Thêm CongNhan vào list
        list.them(cn1);
        list.them(cn2);
        list.them(cn3);
//        Xuất toàn bộ thông tin để kiểm tra
        list.xuatThongTin(); //        Chỉ có cn1 và cn2 được thêm vào, vì size là 2. ==> Đúng
//        Tạo một lớp danh sách mới có thể chứa 3 công nhân
        DanhSachCongNhan newList = new DanhSachCongNhan(3);
        newList.them(cn1);
        newList.them(cn2);
        newList.them(cn3);
//        Tính số lượng nhân viên có trong new list
        System.out.println(newList.soLuongCongNhan()); // In ra 3 ==> Đúng
//        In ra nhân viên có số lượng sản phẩm trên 200
        newList.congNhanLamTrenHaiTram(); // In ra cn1 và cn3 ==> Đúng
//        Sắp xếp giảm dần theo số lượng sản phẩm
        newList.sapXepTheoSoSanPhamGiamDan();
        newList.xuatThongTin(); // Xuất theo thứ tự cn2 cn1 cn3 ==> Đúng
    }
}