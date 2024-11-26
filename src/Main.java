import java.util.*;

// using .equals() method
class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(Employee.getNextId(), new Worker("Тамара", "Ивановна", "Березкина"), 2, 2);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Дмитрий", "Семенович", "Печкин"), 3, 7);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Федор", "Александрович", "Никонов"), 4, 15);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Татьяна", "Васильевна", "Левина"), 5, 1);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Алёна", "Петровна", "Ростовцева"), 2, 2);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Инна", "Семёновна", "Гручкина"), 4, 4);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Тимур", "Сергеевич", "Трошин"), 3, 2);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Степан", "Алексеевич", "Шорин"), 5, 3);
        employeeBook.addEmployee(Employee.getNextId(), new Worker("Таисия", "Тимофеевна", "Гончарова"), 4, 1);

        System.out.println("Информация о работниках: ");
        employeeBook.listEmployees();                                             // вывод сотрудников
        System.out.println(employeeBook.getWageAmount());                        // вывод общей суммы зарплат
        System.out.println(employeeBook.getAverageWage());                       // вывод средней суммы зарплат
        System.out.println(employeeBook.getMinWage(employeeBook.employees));     // вывод сотрудника с минимальной зарплатой
        System.out.println(employeeBook.getMaxWage(employeeBook.employees));    // вывод сотрудника с максимальной зарплатой
        System.out.println(" ");
        System.out.println(employeeBook.getDepartmentWage(4));                  // вывод общей суммы зарплат по отделу
        System.out.println(" ");
        System.out.println(employeeBook.getAverageDepartmentWage(4));           // вывод средней суммы зарплат по отделу
        System.out.println(" ");
        System.out.println("Список сотрудников с измененной зарплатой : ");
        employeeBook.indexedWage(1.2);                                          // вывод списка сотрудников с проиндексированной зарплатой
        System.out.println(" ");
        System.out.println("Список сотрудников без отдела: ");
        employeeBook.printWorkers();                                            // вывод списка сотрудников без отдела
        System.out.println("Сотрудники с зарплатой меньше 5");
        employeeBook.printWorkersMinFixedWage(5);                                // вывод списка сотрудников с зарплатой меньше заданной
        System.out.println("Сотрудники с зарплатой больше  5");
        employeeBook.printWorkersMaxFixedWage(5);                               // вывод списка сотрудников с зарплатой больше заданной
        System.out.println(" ");
        employeeBook.checkFreePlace();                                          // проверяем наличие свободной ячейки
        employeeBook.removeEmployee(5);                                 // удаляем сотрудника по ID
        System.out.println("\n Ноывый список сотрудников: ");
        employeeBook.listEmployees();                                           // выводим новый список сотрудников
        System.out.println(" ");
        employeeBook.printEmployeeAtNumberId(8);                                // выводим данные сотрудника по ID

    }
}

class Employee {
    private Worker worker;
    private int department;
    private double wage;
    private static int id = 1;

    // private static int nextId= 1;
    public Employee(String[] employee) {
    }

    public Employee(int id, Worker worker, int department, double wage) {
        this.id = id;
        this.worker = worker;
        this.department = department;
        this.wage = wage;
    }

    public static int getNextId() {
        return id++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public synchronized double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Employee e2 = (Employee) obj;
        return this.id == e2.id && this.department == e2.department && this.worker.equals(e2.worker) && this.wage == e2.wage;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(worker, department, wage, id, Employee.getNextId());
    }

    @Override
    public String toString() {
        return "ID: " + id + ". ФИО: " + worker.toString() + " Отдел " + department + ". Зарплата: " + wage;
    }
}

class Worker {
    private String firstName;
    private String middleName;
    private String lastName;

    public Worker(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + ".";
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Worker w2 = (Worker) obj;
        return firstName.equals(w2.firstName) && lastName.equals(w2.lastName);
    }
}












