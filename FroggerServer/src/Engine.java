
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Engine implements KeyListener, ActionListener {
	
	//data class instances
	private Frog Frog;
	private int Score;
	private Database Database;
	
	public int getScore() {
		return Score;
	}
	
	public void setScore(int Score) {
		this.Score = Score;
	}
	
	public void ConnectServer() {
		
		final int SERVER_PORT = 5556;
		ServerSocket server;
		try {	
			server = new ServerSocket(SERVER_PORT);
			System.out.println("Waiting for clients to connect...");
			while(true) {
				Socket s = server.accept();
				System.out.println("client connected");
				
				Service myService = new Service(s);
				Thread t = new Thread(myService);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Engine() {
		
		ConnectServer();
		
		// set up Frog
		Frog = new Frog();
		Frog.setX(450);
		Frog.setY(765);
		Frog.setWidth(51);
		Frog.setHeight(36);
		Frog.setVisible(true);
		Frog.setMoving(true);
		Frog.setImage("Frog.png");
		
		Database = new Database();		
				
		
		CarRows CRows = new CarRows(Frog, this);
		LogRows LRows = new LogRows(Frog, this);
		
	}
	
	public static void main (String args []) {
		Engine myGame = new Engine();	
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = Frog.getX();
		int y = Frog.getY();
		//keys to move Frog
		if (e.getKeyCode() == KeyEvent.VK_W) {
			y -= GameProperties.CHARACTER_STEP;
			if (Frog.getY() <= 60) {
				Score += 50;
				Database.setScore(Score);
				Scanner reader = new Scanner(System.in);
				System.out.println("Please Enter Name");
				String Name = reader.nextLine();
				Database.setName(Name);
				Database.CreateDatabase();
				//reader.close();
				
				x = 450;
				y = 765;
			}
			
			if (y + Frog.getHeight() < 0) {
				y = GameProperties.SCREEN_HEIGHT;
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			y += GameProperties.CHARACTER_STEP;
			
			if (y >= GameProperties.SCREEN_HEIGHT) {
				y = -1 * Frog.getHeight();
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			x -= GameProperties.CHARACTER_STEP;	
			
			if (x + Frog.getWidth() < 0) {
				x = GameProperties.SCREEN_WIDTH;
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			x += GameProperties.CHARACTER_STEP;	
			
			if (x >= GameProperties.SCREEN_WIDTH) {
				x = -1 * Frog.getWidth();
			}
			
		} else {
			System.out.println("Invalid Key. Please Try using the WASD keys!");
		}
		
		Frog.setX(x);
		Frog.setY(y);
	}
		

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
