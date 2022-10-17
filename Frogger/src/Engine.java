import java.awt.Color;
import java.awt.Container;

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
		Frog.setImage("Frog.png");
		
		Log = new Log();
		Log.setX(0);
		Log.setY(65);
		Log.setWidth(272);
		Log.setHeight(58);
		Log.setImage("Log.png");
		
		Car = new Car();
		Car.setX(0);
		Car.setY(433);
		Car.setWidth(135);
		Car.setHeight(68);
		Car.setImage("Car.png");
		
		BackGround = new Background();
		BackGround.setX(0);
		BackGround.setY(0);
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
		BGLabel.setLocation(BackGround.getX(), BackGround.getY());
		BGLabel.setSize(BackGround.getWidth(), BackGround.getHeight());
		
		//screen population
		add(FrogLabel);
		add(LogLabel);
		add(CarLabel);
		add(BGLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String args []) {
		Engine myGame = new Engine();
		myGame.setVisible(true);
		
	}
}
