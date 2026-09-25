package task2;

public class SalesManager extends Employee {
    private double salesAmount;
    private static final double COMMISSION_RATE = 0.05; // 5%

    public SalesManager(String name, double baseSalary, double salesAmount) {
        super(name, baseSalary);
        this.salesAmount = salesAmount;
    }

    @Override
    public double calculatePay() {
        return baseSalary + (salesAmount * COMMISSION_RATE);
    }
}
