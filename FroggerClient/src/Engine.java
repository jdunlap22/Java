import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
	
	//client/server port
	final static int CLIENT_PORT = 5656;
	final static int SERVER_PORT = 5556;
	
	//elements
	private Container content;
	private JLabel FrogLabel, BGLabel, ScoreLabel;
	private ImageIcon FrogImage, BGImage;
	
	public int getScore() {
		return Score;
	}
	
	public void setScore(int Score) {
		this.Score = Score;
	}
	
	public void ServerListener() {
		
		ServerSocket client;
		
		try {
			client = new ServerSocket(CLIENT_PORT);
			Thread t1 = new Thread ( new Runnable () {
				public void run ( ) {
					synchronized(this) {
						
						System.out.println("Waiting for server responses...");
						while(true) {
							Socket s2;
							try {
								s2 = client.accept();
								Service myService = new Service (s2);
								Thread t = new Thread(myService);
								t.start();
								
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//System.out.println("client connected");
							
						}
						
					}
				}
			});
			t1.start( );
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public Engine() {
		
		ServerListener();
		
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
		
		//Score Label set up to display score
		ScoreLabel = new JLabel();
		ScoreLabel.setSize(300, 30);
		ScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		ScoreLabel.setForeground(Color.WHITE);
		ScoreLabel.setLocation(10, 10);
		ScoreLabel.setText("Score: " + Score);
		
		//Frog graphic added to screen and instantiation
		FrogLabel = new JLabel();
		FrogImage = new ImageIcon(getClass().getResource(Frog.getImage()));
		FrogLabel.setIcon(FrogImage);
		FrogLabel.setSize(Frog.getWidth(), Frog.getHeight());
		FrogLabel.setLocation(Frog.getX(), Frog.getY());
				
		//Set up BackGround
		BackGround = new Background();
		BackGround.setWidth(1000);
		BackGround.setHeight(813);
		BackGround.setImage("frogger-background.png");
		
		//screen setup
		setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);
		
		CarRows CRows = new CarRows(content, Frog, FrogLabel, this);
		add(ScoreLabel);
		add(FrogLabel);
		LogRows LRows = new LogRows(content, Frog, FrogLabel, this);
		
		//Background graphic added to screen and instantiation
		BGLabel = new JLabel();
		BGImage = new ImageIcon(getClass().getResource(BackGround.getImage()));
		BGLabel.setIcon(BGImage);
		BGLabel.setSize(BackGround.getWidth(), BackGround.getHeight());
		
		//screen population
		add(BGLabel);
		
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
			
			try {
				Socket s = new Socket("localhost", SERVER_PORT);
				OutputStream outstream = s.getOutputStream();
				PrintWriter out = new PrintWriter(outstream);
				String command = "PLAYER 1 UP " + Frog.getX() + " " + y;
				System.out.println("Sending: " + command);
				out.println(command);
				out.flush();
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (Frog.getY() <= 60) {
				Score += 50;
				Database.setScore(Score);
				ScoreLabel.setText("Score: " + Score);
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
			
			try {
				Socket s = new Socket("localhost", SERVER_PORT);
				OutputStream outstream = s.getOutputStream();
				PrintWriter out = new PrintWriter(outstream);
				String command = "PLAYER 1 DOWN " + Frog.getX() + " " + y;
				System.out.println("Sending: " + command);
				out.println(command);
				out.flush();
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if (y >= GameProperties.SCREEN_HEIGHT) {
				y = -1 * Frog.getHeight();
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			
			x -= GameProperties.CHARACTER_STEP;
			
			try {
				Socket s = new Socket("localhost", SERVER_PORT);
				OutputStream outstream = s.getOutputStream();
				PrintWriter out = new PrintWriter(outstream);
				String command = "PLAYER 1 LEFT " + x + " " + Frog.getY();
				System.out.println("Sending: " + command);
				out.println(command);
				out.flush();
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (x + Frog.getWidth() < 0) {
				x = GameProperties.SCREEN_WIDTH;
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			
			x += GameProperties.CHARACTER_STEP;	
			
			try {
				Socket s = new Socket("localhost", SERVER_PORT);
				OutputStream outstream = s.getOutputStream();
				PrintWriter out = new PrintWriter(outstream);
				String command = "PLAYER 1 RIGHT " + x + " " + Frog.getY();
				System.out.println("Sending: " + command);
				out.println(command);
				out.flush();
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (x >= GameProperties.SCREEN_WIDTH) {
				x = -1 * Frog.getWidth();
			}
			
		} else {
			System.out.println("Invalid Key. Please Try using the WASD keys!");
		}
		
		Frog.setX(x);
		Frog.setY(y);
		
		//update Frog
		FrogLabel.setLocation(Frog.getX(), Frog.getY());
		}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
