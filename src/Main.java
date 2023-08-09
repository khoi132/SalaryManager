import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = EmployeeManager.getInstance();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String choice = menu.displayMenu();
            if (choice.equalsIgnoreCase("Exit")) {
                break;
            }

            if (choice.equalsIgnoreCase("Add")) {
                System.out.print("Enter employee ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();

                System.out.println("Choose an employee type: (Commission / Hourly / Salary)");
                String employeeType = scanner.nextLine();

                Employee employee = EmployeeFactory.createEmployee(employeeType, id, name);

                if (employee instanceof CommissionEmployee) {
                    System.out.print("Enter commission rate: ");
                    double commissionRate = scanner.nextDouble();
                    System.out.print("Enter sales amount: ");
                    double sales = scanner.nextDouble();
                    ((CommissionEmployee) employee).setCommissionRate(commissionRate);
                    ((CommissionEmployee) employee).setSales(sales);
                } else if (employee instanceof HourlyEmployee) {
                    System.out.print("Enter hourly rate: ");
                    double hourlyRate = scanner.nextDouble();
                    System.out.print("Enter hours worked: ");
                    double hoursWorked = scanner.nextDouble();
                    ((HourlyEmployee) employee).setHourlyRate(hourlyRate);
                    ((HourlyEmployee) employee).setHoursWorked(hoursWorked);
                } else if (employee instanceof SalaryEmployee) {
                    System.out.print("Enter base salary: ");
                    double baseSalary = scanner.nextDouble();
                    ((SalaryEmployee) employee).setBaseSalary(baseSalary);
                }

                employeeManager.addEmployee(employee);
            } else if (choice.equalsIgnoreCase("View")) {
                System.out.print("Enter employee name: ");
                scanner.nextLine(); // Clear the newline character
                String name = scanner.nextLine();
                Employee employee = employeeManager.findEmployeeByName(name);
                if (employee != null) {
                    Menu.displaySalary(employee);
                } else {
                    System.out.println("Employee not found.");
                }
            } else if (choice.equalsIgnoreCase("Calculate")) {
                double totalSalary = employeeManager.calculateTotalSalary();
                System.out.println("Total salary for all employees: " + totalSalary);
            }
        }
    }
}
