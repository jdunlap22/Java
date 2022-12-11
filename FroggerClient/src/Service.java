import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Service implements Runnable {
	
	private Socket s;
	private Scanner in;

	public Service (Socket Socket) {
		this.s = Socket;
	}

	@Override
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
	
		System.out.println(command);
		
		if ( command.equals("PLAYER")) {
			int playerNo = in.nextInt();
			String playerAction = in.next();
			int playerX = in.nextInt();
			int playerY = in.nextInt();
			System.out.println("Player "+playerNo+" "+playerAction + " "+playerX+", "+playerY);
		}
		
		if ( command.equals("CAR_POSITION")) {
			int CarNo = in.nextInt();
			String CarAction = in.next();
			int CarX = in.nextInt();
			int CarY = in.nextInt();
			System.out.println("Player "+CarNo+" "+CarAction + " "+CarX+", "+CarY);
		}
		
		if ( command.equals("LOG_POSITION")) {
			int LogNo = in.nextInt();
			String LogAction = in.next();
			int LogX = in.nextInt();
			int LogY = in.nextInt();
			System.out.println("Player "+LogNo+" "+LogAction + " "+LogX+", "+LogY);
		}
	}

}
