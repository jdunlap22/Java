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
	private JLabel FrogLabel, BGLabel;
	private ImageIcon FrogImage, BGImage;
	
	
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
		
		CarRows CRows = new CarRows(content, Frog, FrogLabel);
		
		add(FrogLabel);
		LogRows LRows = new LogRows(content, Frog, FrogLabel);
		
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
		
	}
}
