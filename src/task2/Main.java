package task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Developer("Bilal Ahmed", 80000, 15000));
        employees.add(new SalesManager("Sara Malik", 60000, 200000));
        employees.add(new Developer("Usman Tariq", 90000, 12000));
        employees.add(new SalesManager("Hina Riaz", 55000, 350000));

        for (Employee e : employees) {
            System.out.printf("%s -> Final Pay: %.2f%n", e.getName(), e.calculatePay());
        }
    }
}
