import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Tạo 3 Product
        Product sting = new Product("Sting", "001", 15000);
        Product coca = new Product("Coca cola", "002", 5000);
        Product pepsi = new Product("Pepsi", "003", 10000);
//        Tạo 1 Order
        Order order = new Order(1, LocalDate.now());
//        Order 2 Sting, 1 Coca, 1 Pepsi ( Tổng giá tiền 15000 * 2 + 5000 + 10000 = 45000 )
        order.addLineItem(sting, 2);
        order.addLineItem(coca,1);
        order.addLineItem(pepsi,1);

//        Kiểm chứng tổng giá tiền
        System.out.println("Tổng tiền: " + order.calcTotalCharge());
    }
}