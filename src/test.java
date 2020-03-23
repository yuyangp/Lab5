import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class test {
	static Scanner scanner=new Scanner(System.in);
	static int selected;
	static NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
	static List<Employee> elist = new ArrayList<>();
	
	public static Employee chooseType(Employee employee) {
		System.out.println("Input the type:");
		System.out.println("1.Salaried\t2.Hourly\t3.Commissioned");
		employee.setType(scanner.nextInt());
		Scanner scanner=new Scanner(System.in);
		if (employee.getType() == 1) {
			System.out.println("Input the salary:");
			employee.setWeeklypay(scanner.nextDouble());
		} else if (employee.getType() == 2) {
			System.out.println("Input the hours:");
			employee.setHours(scanner.nextInt());
			System.out.println("Input the hourly rate:");
			employee.setRate(scanner.nextDouble());
			if (employee.getHours() <= 40) {
				employee.setWeeklypay(employee.getHours() * employee.getRate());
			} else {
				employee.setWeeklypay(
						40 * employee.getRate() + (employee.getHours() - 40) * employee.getRate() * 2);
			}
		} else if (employee.getType() == 3) {
			System.out.println("Input the sales:");
			employee.setSales(scanner.nextDouble());
			employee.setWeeklypay(employee.getSales() * 0.2);
		}
		return employee;
	}
	
	public static void selectEmployee(List<Employee> elist) {
		System.out.println("select salaried employees?(y/n)");
		String rwd = scanner.next();
		if (rwd.equals("y")) {
			for (int i = 0; i < elist.size(); i++) {
				if (elist.get(i).getType() == 1) {
					System.out.println((i + 1) + "." + elist.get(i).getName());
				}
			}
			System.out.println("Input the num:");
			selected = scanner.nextInt();
			elist.get(selected - 1).setWeeklypay(elist.get(selected - 1).getWeeklypay() * 1.1);
		}
	}
	
	public static void printSalary(List<Employee> elist) {
		System.out.println("Name\t\tClass\t\tHours\t\tSales\t\tRate\t\tWeekly Pay");
		System.out.println("================================================================================================");
		for (Employee employee : elist) {
			System.out.print(employee.getName() + "\t\t");
			switch (employee.getType()) {
			case 1:
				System.out.print("Salaried\t\t");
				break;
			case 2:
				System.out.print("Hourly\t\t");
				break;
			case 3:
				System.out.print("Commissioned\t\t");
				break;
			default:
				break;
			}
			System.out.print(employee.getHours() + "\t\t");
			System.out.print(usFormat.format(employee.getSales()) + "\t\t");
			System.out.print(usFormat.format(employee.getRate()) + "\t\t");
			System.out.println(usFormat.format(employee.getWeeklypay()));
		}
		System.out.println("================================================================================================");
	}
	
	public static void main(String[] args) {
		String flag = "y";
		
		while (flag.equals("y")) {
			Employee employee = new Employee();
			System.out.println("Input the name:");
			employee.setName(scanner.next());		
			elist.add(chooseType(employee));
			System.out.println("Add more?(y/n)");
			flag = scanner.next();
		}
		selectEmployee(elist);
		printSalary(elist);
	}
}
