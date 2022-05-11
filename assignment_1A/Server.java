import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.lang.Math;

public class Server
{
	public static void main(String args[]) throws IOException
	{
		// Step 1: Establish the socket connection.
		ServerSocket ss = new ServerSocket(4444);
		Socket s = ss.accept();

		// Step 2: Processing the request.
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	
		// wait for input
		Double a = dis.readDouble();
		Double b = dis.readDouble();

		Double result = Math.pow(a, b);
		System.out.println("Sending the result...");

		// send the result back to the client.
		dos.writeDouble(result);		
	}
}

