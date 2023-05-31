public class Main {
    public static void main(String[] args) {
        Account acc1 = new Account(72354, "Ted Murphy", 102560);
        Account acc2 = new Account(69713,"Jane Smith", 40000);
        Account acc3 = new Account(93757,"Edward Demsey", 759320);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println("Tiên lãi acc3: ");
        acc3.addInterest();
        System.out.println("--Tài khoản trước khi chuyển tiền--");

        acc1.deposit(25850);
        acc2.deposit(500000);
        acc2.withdraw(430750,1500);


        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println("--Sau khi chuyển (100.000) từ acc 2 sang acc 1 --");
        acc2.transfer(acc1, 100000);
        System.out.println(acc1);
        System.out.println(acc2);
    }
}