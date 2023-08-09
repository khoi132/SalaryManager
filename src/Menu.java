import java.util.Scanner;

public class Menu {
    public static String displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee Salary");
        System.out.println("3. Calculate Employee Salary");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "Add";
            case 2:
                return "View";
            case 3:
                return "Calculate";
            case 4:
                return "Exit";
            default:
                System.out.println("Invalid choice!");
                return displayMenu();
        }
    }

    public static void displaySalary(Employee employee) {
        double salary = employee.calculateSalary();
        System.out.println("Employee: " + employee.getName());
        System.out.println("Salary: " + salary);
    }
}
