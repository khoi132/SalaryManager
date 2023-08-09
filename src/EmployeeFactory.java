public class EmployeeFactory {
    public static Employee createEmployee(String employeeType, int id, String name) {
        if (employeeType.equalsIgnoreCase("Commission")) {
            return new CommissionEmployee(id, name);
        } else if (employeeType.equalsIgnoreCase("Hourly")) {
            return new HourlyEmployee(id, name);
        } else if (employeeType.equalsIgnoreCase("Salary")) {
            return new SalaryEmployee(id, name);
        } else {
            throw new IllegalArgumentException("Invalid employee type!");
        }
    }
}
