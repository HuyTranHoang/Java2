import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Management {
    private List<Person> personList;

    public Management(int size) {
        this.personList = new ArrayList<>(size);
    }

    public Management(List<Person> personList) {
        this.personList = personList;
    }

    public void them(Person person) {
        personList.add(person);
    }

    public void xoa(String tenNguoiCanXoa) {
        personList.stream()
                .filter(person -> person.getHoTen().equals(tenNguoiCanXoa))
                .findFirst()
                .ifPresent(person -> {
                    personList.remove(person);
                    System.out.println("Đã xoá người: " + person.getHoTen());
                });

        System.out.println("Danh sách người sau khi xoá:");
        personList.forEach(person -> System.out.println(person.getHoTen()));
    }

    public void sapXepTheoHoTen() {
        personList.sort(Comparator.comparing(Person::getHoTen));
        System.out.println("Danh sách người sau khi sắp xếp:");
        personList.forEach(person -> System.out.println(person.getHoTen()));
    }

    public void xuatDanhSach() {
        if (personList.size() > 0 )
            personList.forEach(System.out::println);
        else
            System.out.println("Danh sách rỗng!");
    }
}
