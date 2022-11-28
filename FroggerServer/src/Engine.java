import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Engine extends JFrame implements KeyListener, ActionListener {
	
	//data class instances
	private Frog Frog;
	private Background BackGround;
	private int Score;
	private Database Database;
	
	//elements
	private Container content;
	private ImageIcon FrogImage, BGImage;
	
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
				
		
		//screen setup
		setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		
		CarRows CRows = new CarRows(content, Frog, this);
		LogRows LRows = new LogRows(content, Frog, this);
		

		
		content.addKeyListener(this);
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String args []) {
		Engine myGame = new Engine();
		myGame.setVisible(true);
		
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
