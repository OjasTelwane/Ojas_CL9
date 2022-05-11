
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args) throws IOException
	{
		InetAddress ip = InetAddress.getLocalHost();
		int port = 4444;
		Scanner sc = new Scanner(System.in);

		// Step 1: Open the socket connection.
		Socket s = new Socket(ip, port);

		// Step 2: Communication-get the input and output stream
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());


		while (true) {
			// User Menu
			System.out.println(
				"\n1.Power function\n2.Exit");
			System.out.println("Enter the option:");
			int opt = sc.nextInt();
			if (opt == 2) {
				break;
			}
			System.out.println("Enter the the first number:");
			double a = sc.nextDouble();
			// send the numbers to server
			dos.writeDouble(a);
			System.out.println("Enter the second number:");
			double b = sc.nextDouble();
			// send the numbers to server
			dos.writeDouble(b);
			double n = dis.readDouble();
			System.out.println(a + " raised to " + b + " = " + n);
		}
	}
}

