public class Main {
    public static void main(String[] args) {

        CD cd1 = new CD(1,"Em của ngày hôm qua", 5,50000);
        CD cd2 = new CD(2,"Making my ways", 10,30000);
        CD cd3 = new CD(3,"Gawr Gura Desu", 3,60000);
        CD cd4 = new CD(1,"Em của ngày hôm nay", 7,45000);
        CDList cdList = new CDList();

        cdList.khoiTao(4);
        cdList.themMot(cd1);
        cdList.themMot(cd2);
        cdList.themMot(cd3);
        cdList.themMot(cd4);

        cdList.thongTinToanBoCD();

        System.out.println("Số lượng CD có trong danh sách: " + cdList.soLuongCDTrongList());
        System.out.println("Tổng giá thành của CD: " + cdList.tongGiaThanhCD());

        System.out.println("Sắp xếp giảm dần theo giá thành: ");
        cdList.sapXepGiamDanTheoGiaThanh();
        cdList.thongTinToanBoCD();

        System.out.println("Sắp xếp tăng dần theo tên: ");
        cdList.sapXepTangDanTheoTuaCD();
        cdList.thongTinToanBoCD();
    }
}