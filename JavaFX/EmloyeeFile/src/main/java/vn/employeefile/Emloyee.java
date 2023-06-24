package vn.employeefile;

public class Emloyee {
    private int code;
    private String name;
    private double salary;

    public Emloyee() {
    }

    public Emloyee(int code, String name, double salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
