import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Engine extends JFrame implements KeyListener, ActionListener {
	
	//data class instances
	private Frog Frog;
	private Log Log;
	private Car Car;
	private Background BackGround;
	
	//elements
	private Container content;
	private JLabel FrogLabel, LogLabel, BGLabel;
	private ImageIcon FrogImage, LogImage, BGImage;
	private JButton Start, Visibility;
	
	
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
		Log.setMoving(false);
		Log.setImage("Log.png");
				
		
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
		Log.setLogLabel(LogLabel);
		
		LogRows LRows = new LogRows(content);
		CarRows CRows = new CarRows(content);
		
		
		//Background graphic added to screen and instantiation
		BGLabel = new JLabel();
		BGImage = new ImageIcon(getClass().getResource(BackGround.getImage()));
		BGLabel.setIcon(BGImage);
		BGLabel.setSize(BackGround.getWidth(), BackGround.getHeight());
		
		//Start Button and Disappear Button
		Start = new JButton ("Start");
		Start.setSize(100, 50);
		Start.setLocation(GameProperties.SCREEN_WIDTH-125, GameProperties.SCREEN_HEIGHT-150);
		Start.setFocusable(false);
		
		
		Visibility = new JButton ("Hide");
		Visibility.setSize(100, 50);
		Visibility.setLocation(GameProperties.SCREEN_WIDTH-125, GameProperties.SCREEN_HEIGHT-95);
		Visibility.setFocusable(false);
		
		//screen population
		add(Start);
		Start.addActionListener(this);
		add(Visibility);
		Visibility.addActionListener(this);
		add(FrogLabel);
		add(LogLabel);
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
		
		//update Frog
		FrogLabel.setLocation(Frog.getX(), Frog.getY());
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Button set up code for each button
		if (e.getSource() == Start) {
			if (Car.getMoving() && Log.getMoving()) {
				//Stop, button displays Start
				Car.setMoving(false);
				Log.setMoving(false);
				Start.setText("Start");
			} else {
				//Start, button displays Stop
				//for (Car Car: CarRow1) {
					
				//Car.startMoving();
				//}
				Log.startMoving();
				Start.setText("Stop");
			}
		} else if (e.getSource() == Visibility) {
			//check visibility of car
			if (Car.getVisible() && Log.getVisible()) {
			//if visible hide to check collision, change text to button to say show
				Car.setVisible(false);
				Log.setVisible(false);
				//CarLabel.setVisible(Car.getVisible());
				LogLabel.setVisible(Log.getVisible());
				Visibility.setText("Show");
			} else {
			//If hidden change text to hide on button.
				Car.setVisible(true);
				//CarLabel.setVisible(Car.getVisible());
				Log.setVisible(true);
				LogLabel.setVisible(Log.getVisible());
				Visibility.setText("Hide");
			}
		}
		
	}
}
