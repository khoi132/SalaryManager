public class CommissionEmployee extends Employee {
    private double commissionRate;
    private double sales;

    public CommissionEmployee(int id, String name) {
        super(id, name);
        this.commissionRate = 0.0;
        this.sales = 0.0;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    @Override
    public double calculateSalary() {
        return commissionRate * sales;
    }
}
