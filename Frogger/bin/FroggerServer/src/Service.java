import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Service implements Runnable {
	
	final int CLIENT_PORT = 5656;

	private Socket s;
	private Scanner in;

	public Service (Socket aSocket) {
		this.s = aSocket;
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
	}

}
