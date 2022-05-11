// Importing required classes
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;
import java.lang.Math;

class Server {

	// Main driver method
	public static void main(String[] args)
		throws IOException
	{

		// Creating a socket to listen at port 1234
		DatagramSocket ds = new DatagramSocket(1234);

		byte[] buf = null;

		// Initializing them initially with null
		DatagramPacket DpReceive = null;
		DatagramPacket DpSend = null;

		while (true) {
			buf = new byte[65535];

			// Creating a DatagramPacket to receive the data.
			DpReceive = new DatagramPacket(buf, buf.length);

			// Receiving the data in byte buffer.
			ds.receive(DpReceive);

			String inp = new String(buf, 0, buf.length);

			// Using trim() method to
			// remove extra spaces.
			inp = inp.trim();

			System.out.println("\nEquation Received:- "
							+ inp);

			// Exit the server if the client sends "bye"
			if (inp.equals("Exit")) {
				System.out.println(
					"\nClient sent Exit.....Terminating");

				// Exit from program here itself without checking further
				break;
			}

			// Use StringTokenizer to break the input string
			StringTokenizer st = new StringTokenizer(inp);

			Double a = Double.parseDouble(st.nextToken());
			String operation = st.nextToken();
			Double b = Double.parseDouble(st.nextToken());

			Double result = Math.pow(a, b);			

			System.out.println("Sending the result...");
			String res = Double.toString(result);

			// Clearing the buffer after every message
			buf = res.getBytes();

			// Getting the port of client
			int port = DpReceive.getPort();

			DpSend = new DatagramPacket(
				buf, buf.length, InetAddress.getLocalHost(),
				port);
			ds.send(DpSend);
		}
	}
}

