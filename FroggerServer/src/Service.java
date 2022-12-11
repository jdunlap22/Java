import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Service implements Runnable {
	
	final int CLIENT_PORT = 5656;

	private Socket s;
	private Scanner in;
	private Frog Frog;
	private Log Log;
	private Car Car;

	public Service (Socket aSocket, Frog Frog, Car Car, Log Log) {
		this.s = aSocket;
		this.Frog = Frog;
		this.Log = Log;
		this.Car = Car;
	}
	
	public void run() {
		
		try {
			in = new Scanner(s.getInputStream());
			processRequest( );
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void processRequest () throws IOException {

		while(true) {
			if(!in.hasNext( )){
				return;
			}
			String command = in.next();
			if (command.equals("Quit")) {
				return;
			} else {
				executeCommand(command);
			}
		}
	}
	
	public void executeCommand(String command) throws IOException{
	
		
		if ( command.equals("PLAYER")) {
			int playerNo = in.nextInt();
			String playerAction = in.next();
			int playerX = in.nextInt();
			int playerY = in.nextInt();
			Frog.setX(playerX);
			Frog.setY(playerY);
			
			System.out.println("Player "+playerNo+" moves "+playerAction);
			
			
			//send a response
			Socket s2 = new Socket("localhost", CLIENT_PORT);
			
			//Initialize data stream to send data out
			OutputStream outstream = s2.getOutputStream();
			PrintWriter out = new PrintWriter(outstream);

			String commandOut = "PLAYER "+playerNo+ " " +playerAction+" "+playerX+ " " +playerY;
			System.out.println("Sending: " + commandOut);
			out.println(commandOut);
			out.flush();
				
			s2.close();

		}
		
		if ( command.equals("CAR_POSITION")) {
			int CarNo = in.nextInt();
			String CarAction = in.next();
			int CarX = in.nextInt();
			int CarY = in.nextInt();
			Car.setX(CarX);
			Car.setY(CarY);
			
			System.out.println("Player "+CarNo+" "+CarAction + " "+CarX+", "+CarY);
			
			Socket s2 = new Socket("localhost", CLIENT_PORT);
			
			//Initialize data stream to send data out
			OutputStream outstream = s2.getOutputStream();
			PrintWriter out = new PrintWriter(outstream);

			String commandOut = "PLAYER "+CarNo+ " " +CarAction+" "+CarX+ " " +CarY;
			System.out.println("Sending: " + commandOut);
			out.println(commandOut);
			out.flush();
				
			s2.close();
		}
		
		if ( command.equals("LOG_POSITION")) {
			int LogNo = in.nextInt();
			String LogAction = in.next();
			int LogX = in.nextInt();
			int LogY = in.nextInt();
			Log.setX(LogX);
			Log.setY(LogY);
			
			System.out.println("Player "+LogNo+" "+LogAction + " "+LogX+", "+LogY);
			
			Socket s2 = new Socket("localhost", CLIENT_PORT);
			
			//Initialize data stream to send data out
			OutputStream outstream = s2.getOutputStream();
			PrintWriter out = new PrintWriter(outstream);

			String commandOut = "PLAYER "+LogNo+ " " +LogAction+" "+LogX+ " " +LogY;
			System.out.println("Sending: " + commandOut);
			out.println(commandOut);
			out.flush();
				
			s2.close();
		}
		

	}

}
