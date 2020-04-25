package lesson0105;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee (String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void PrintInfo() {
        System.out.printf("ФИО\t%s\n", name);
        System.out.printf("Должность\t%s\n", position);
        System.out.printf("e-mail\t%s\n", email);
        System.out.printf("Телефон\t%s\n", phone);
        System.out.printf("Оклад\t%d\n", salary);
        System.out.printf("Возраст\t%d\n", age);
    }

}
