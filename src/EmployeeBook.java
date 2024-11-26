public class EmployeeBook {
    private int size;
    boolean place = true;
    final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }


    public void listEmployees() {                   // распечатываем сотрудников
        int id = 0;
        for (int i = 0; i < size; i++) {
            id = i + 1;
            Employee employee = employees[i];
            System.out.println("ID: " + id + ". ФИО: " + employee.getWorker() + " Отдел : " + employee.getDepartment() + ". Зарплата: " + employee.getWage());

        }
    }

    public void addEmployee(int id, Worker worker, int department, double wage) {    // добавляем сотрудников
        if (size >= employees.length) {
            System.out.println("Нельзя добавить работника, свободных ячеек нет");
        }
        Employee newEmployee = new Employee(id, worker, department, wage);
        employees[size++] = newEmployee;
    }

    public String getWageAmount() { // метод для нахождения общей суммы зарплат
        int wageAmount = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            wageAmount += employee.getWage();
        }
        return "Общая сумма зарплат " + size + " сотрудников равна: " + wageAmount;
    }

    public String getAverageWage() { // метод для нахождения средней суммы зарплат
        double averageWageAmount = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            averageWageAmount += employee.getWage() / size;
        }
        return "Средняя сумма зарплат " + size + " сотрудников равна: " + averageWageAmount;
    }

    public String getMinWage(Employee[] employees) { // метод для нахождения минимальной зарплаты из 10
        int id = 0;
        Employee minEmployee = employees[0];
        for (int i = 0; i < size; i++) {
            if (employees[i].getWage() < minEmployee.getWage()) {
                minEmployee = employees[i];
                id = i + 1;
            }
        }
        System.out.println();
        return "Сотрудник с минимальной зарплатой : \n" + "ID : " + id + ". ФИО: " + minEmployee.getWorker() + " Отдел: " + minEmployee.getDepartment() + ". Зарплата: " + minEmployee.getWage();
    }

    public String getMaxWage(Employee[] employees) { // метод для нахождения максимальной зарплаты из 10
        double maxWage = employees[1].getWage();
        int id = 1;
        Employee maxEmployee = employees[0];
        for (int i = 0; i < size; i++) {
            if (employees[i].getWage() > maxWage) {
                maxEmployee = employees[i];
                id = i + 1;
            }
        }
        System.out.println();
        return "Сотрудник с максимальной зарплатой : \n" + "ID : " + id + ". ФИО: " + maxEmployee.getWorker() + " Отдел: " + maxEmployee.getDepartment() + ". Зарплата: " + maxEmployee.getWage();
    }

    public String getDepartmentWage(int dep) { // метод для нахождения общей суммы зарплат по отделу
        double departmentWage = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == (dep)) {
                departmentWage += employee.getWage();
            }
        }
        return "Сумма зарплат по отделу " + dep + " равна: " + departmentWage;
    }

    public String getAverageDepartmentWage(int dep) { // метод для нахождения средней суммы зарплат по отделу с параметром
        double averageDepartmentWage = 0;
        double h = 0;
        int j = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == (dep)) {
                j++;
                h += employee.getWage();
                averageDepartmentWage = h / j;
            }
        }
        return "Средняя сумма зарплат по отделу " + dep + " равна : " + averageDepartmentWage;
    }

    public String indexedWage(double indexedWage) {
        int id = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            id++;
            employee.setWage((double) (employee.getWage() * indexedWage));
            System.out.println("ID:  " + id + ". ФИО сотрудника:  " + employee.getWorker() + " Зарплата:  " + employee.getWage());
        }
        return "Список сотрудников с измененной зарплатой: ";
    }

    public void printWorkers() {    // метод для вывода списка сотрудников без номера отдела
        int id = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            id++;
            System.out.println("ID:  " + id + ". ФИО сотрудника:  " + employee.getWorker() + " Зарплата:  " + employee.getWage());
        }
    }

    public String printWorkersMinFixedWage(int fixedWage) {       // метод для вывода списка сотрудников с зарплатой меньше указанного параметра
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getWage() < fixedWage) {
                int id = i + 1;
                System.out.println(" ID: " + id + ". ФИО: " + employee.getWorker() + "Зарплата: " + employee.getWage());
            }
        }
        return "Cписок сотрудников с зарплатой меньше 5";
    }

    public String printWorkersMaxFixedWage(int fixedWage) {       // метод для вывода списка сотрудников с зарплатой больше указанного параметра
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getWage() > fixedWage) {
                int id = i + 1;
                System.out.println(" ID: " + id + ". ФИО: " + employee.getWorker() + ". Зарплата: " + employee.getWage());
            }
        }
        return "Cписок сотрудников с зарплатой меньше 5";
    }

    public void checkFreePlace() {                            // метод для проверки списка сотрудников на наличие свободной ячейки
        if (size <= employees.length) {
            System.out.println(place + "  Можно добавить работника");
        } else {
            place = false;
            System.out.println(place + "Нельзя добавить работника, свободных ячеек нет");
        }

    }

    public void removeEmployee(int numberId) {
        for (int i = 0; i < employees.length; i++) {
            int id = 0;
            Employee employee = employees[i];
            if (numberId == i + 1) {
                System.out.println(employee.getWorker() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
            }
        }
    }

    public void printEmployeeAtNumberId(int numberId) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (numberId == i + 1) {
                System.out.println("ФИО сотрудника c ID " + numberId + " : " + employee.getWorker() + " Отдел: " + employee.getDepartment() + ". Зарплата:" + employee.getWage());
            }
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        EmployeeBook e2 = (EmployeeBook) obj;
        return this.employees.equals(e2.employees) && this.size == e2.size && this.place==e2.place;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(employees, size, place);
    }

}
