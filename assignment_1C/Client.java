// Program for client application
import java.rmi.*;
import java.util.*;
public class Client {
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		while (true) {
			// User Menu
			System.out.println(
				"\n1.Power function\n2.Exit");
			System.out.println("Enter the option:");
			int opt = sc.nextInt();
			if (opt == 2) {
				break;
			}
			System.out.println(
				"Enter the the first number:");
			double a = sc.nextDouble();
			System.out.println("Enter the second number:");
			double b = sc.nextDouble();
			double n;
				// lookup method to find reference of remote
				// object
				PowInterface obj
					= (PowInterface)Naming.lookup("POW");
				n = obj.pow(a, b);
				System.out.println(a + " raised to " + b + " = " + n);
		}
	}
}

