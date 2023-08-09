public class SalaryEmployee extends Employee {
    private double baseSalary;

    public SalaryEmployee(int id, String name) {
        super(id, name);
        this.baseSalary = 0.0;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
