import java.time.LocalDate;
import java.util.Arrays;

public class Order {
    private int orderID;
    private LocalDate orderDate;
    private OrderDetail[] lineItems;
    private int count;
    private static final int INITIAL_SIZE = 10;

    public Order(int orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.lineItems = new OrderDetail[INITIAL_SIZE];
        this.count = 0;
    }

    public int getOrderID() {
        return orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderDetail[] getLineItems() {
        return lineItems;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    private void checkArraySize() {
        if (count == lineItems.length) {
            int newSize = lineItems.length * 2;
            lineItems = Arrays.copyOf(lineItems, newSize);
        }
    }

    public void addLineItem(Product product, int quantity) {
        checkArraySize();
        OrderDetail orderDetail = new OrderDetail(quantity,product);
        lineItems[count] = orderDetail;
        count++;
    }

    public double calcTotalCharge() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += lineItems[i].calcTotalPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", lineItems=" + Arrays.toString(lineItems) +
                ", count=" + count +
                '}';
    }
}
