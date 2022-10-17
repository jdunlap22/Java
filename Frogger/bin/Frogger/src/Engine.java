import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Engine extends JFrame implements KeyListener {
	
	//data class instances
	private Frog Frog;
	private Log Log;
	private Car Car;
	private Background BackGround;
	
	//elements
	private Container content;
	private JLabel FrogLabel, LogLabel, CarLabel, BGLabel;
	private ImageIcon FrogImage, LogImage, CarImage, BGImage;

	
	
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
		
		//set up Log
		Log = new Log();
		Log.setX(0);
		Log.setY(65);
		Log.setWidth(272);
		Log.setHeight(58);
		Log.setVisible(true);
		Log.setMoving(true);
		Log.setImage("Log.png");
		
		// set up Car
		Car = new Car();
		Car.setX(0);
		Car.setY(434);
		Car.setWidth(135);
		Car.setHeight(68);
		Car.setVisible(true);
		Car.setMoving(true);
		Car.setImage("Car.png");
		
		
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
		
		//Frog graphic added to screen and instantiation
		FrogLabel = new JLabel();
		FrogImage = new ImageIcon(getClass().getResource(Frog.getImage()));
		FrogLabel.setIcon(FrogImage);
		FrogLabel.setSize(Frog.getWidth(), Frog.getHeight());
		FrogLabel.setLocation(Frog.getX(), Frog.getY());
		
		//Log graphic added to screen and instantiation
		LogLabel = new JLabel();
		LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
		LogLabel.setIcon(LogImage);
		LogLabel.setSize(Log.getWidth(), Log.getHeight());
		LogLabel.setLocation(Log.getX(), Log.getY());
		
		//Car graphic added to screen and instantiation
		CarLabel = new JLabel();
		CarImage = new ImageIcon(getClass().getResource(Car.getImage()));
		CarLabel.setIcon(CarImage);
		CarLabel.setSize(Car.getWidth(), Car.getHeight());
		CarLabel.setLocation(Car.getX(), Car.getY());
		
		//Background graphic added to screen and instantiation
		BGLabel = new JLabel();
		BGImage = new ImageIcon(getClass().getResource(BackGround.getImage()));
		BGLabel.setIcon(BGImage);
		BGLabel.setSize(BackGround.getWidth(), BackGround.getHeight());
		
		//screen population
		add(FrogLabel);
		add(LogLabel);
		add(CarLabel);
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
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			y += GameProperties.CHARACTER_STEP;	
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			x -= GameProperties.CHARACTER_STEP;	
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			x += GameProperties.CHARACTER_STEP;	
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
}
