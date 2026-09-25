package task2;

/**
 * Task 2: The 'Evolving Workforce' - Inheritance & Polymorphism
 * Base class. calculatePay() is overridden by every subclass, which is
 * what makes polymorphism possible.
 */
public class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double calculatePay() {
        return baseSalary;
    }
}
