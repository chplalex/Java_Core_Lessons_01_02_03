package lesson0105;

public class MainApp0105 {
    public static void main(String[] args) {
        Employee[] personArr = new Employee[5];
        personArr[0] = new Employee("Иванов", "Директор", "ivonov@gmail.com", "8 (903) 561-56-71", 100000, 55);
        personArr[1] = new Employee("Петров", "Заместитель директора", "petrov@gmail.com", "8 (903) 561-56-72", 90000, 50);
        personArr[2] = new Employee("Сидоров", "Начальник отдела", "sidorov@gmail.com", "8 (903) 561-56-73", 80000, 45);
        personArr[3] = new Employee("Никитин", "Заместитель начальника отдела", "nikitin@gmail.com", "8 (903) 561-56-74", 70000, 40);
        personArr[4] = new Employee("Романов", "Специалист", "romanov@gmail.com", "8 (903) 561-56-75", 60000, 35);
        System.out.println("Список сотрудников предприятия:");
        System.out.println();
        for (int i = 0; i < personArr.length; i++) {
            personArr[i].PrintInfo();
            System.out.println("***");
        }
    }
}
