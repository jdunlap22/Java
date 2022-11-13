import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogRows extends Sprite implements Runnable {
	
	private JLabel LogLabel, FrogLabel;
	private ImageIcon LogImage;
	private Sprite Frog = new Sprite();
	private Boolean moving = true;
	private int LogCount = 0;
	
	Log[] LogRow1;
	Log[] LogRow2;
	Log[] LogRow3;
	Log[] LogRow4;
	Log[] LogRow5;
	Thread t;
	
	public LogRows(Container container, Sprite Frog, JLabel FrogLabel, Engine Engine) {
		
	this.FrogLabel = FrogLabel;
	this.Engine = Engine;
	
	int Spacing = 0;
	
	LogRow1 = new Log[3];
	
	LogRow1[0] = new Log();
	LogRow1[1] = new Log();
	LogRow1[2] = new Log();
	
		for (Log Log : LogRow1) {
			
			Log.setX(0);
			Log.setY(65);
			Log.setWidth(272);
			Log.setHeight(58);
			Log.setVisible(true);
			Log.setMoving(false);
			Log.setFrog(Frog);
			Log.setImage("Log.png");
			Log.setFrogLabel(FrogLabel);
			
			LogLabel = new JLabel();
			LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
			LogLabel.setIcon(LogImage);
			LogLabel.setSize(Log.getWidth(), Log.getHeight());
			Log.setX(Log.getX() + Spacing);
			LogLabel.setLocation(Log.getX(), Log.getY());
			Log.setLogLabel(LogLabel);
			container.add(LogLabel);
			
			Spacing += 320;
			
		}
		
		LogRow2 = new Log[3];
		
		LogRow2[0] = new Log();
		LogRow2[1] = new Log();
		LogRow2[2] = new Log();
		
			for (Log Log : LogRow2) {
				
				Log.setX(-915);
				Log.setY(128);
				Log.setWidth(272);
				Log.setHeight(58);
				Log.setVisible(true);
				Log.setReverse(true);
				Log.setFrog(Frog);
				Log.setImage("Log.png");
				Log.setFrogLabel(FrogLabel);
				
				LogLabel = new JLabel();
				LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
				LogLabel.setIcon(LogImage);
				LogLabel.setSize(Log.getWidth(), Log.getHeight());
				Log.setX(Log.getX() + Spacing);
				LogLabel.setLocation(Log.getX(), Log.getY());
				Log.setLogLabel(LogLabel);
				container.add(LogLabel); 
				
				Spacing += 340;
			}
			
			LogRow3 = new Log[3];
			
			LogRow3[0] = new Log();
			LogRow3[1] = new Log();
			LogRow3[2] = new Log();
			
				for (Log Log : LogRow3) {
					
					Log.setX(-1980);
					Log.setY(190);
					Log.setWidth(272);
					Log.setHeight(58);
					Log.setVisible(true);
					Log.setMoving(false);
					Log.setFrog(Frog);
					Log.setImage("Log.png");
					Log.setFrogLabel(FrogLabel);
					
					LogLabel = new JLabel();
					LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
					LogLabel.setIcon(LogImage);
					LogLabel.setSize(Log.getWidth(), Log.getHeight());
					Log.setX(Log.getX() + Spacing);
					LogLabel.setLocation(Log.getX(), Log.getY());
					Log.setLogLabel(LogLabel);
					container.add(LogLabel); 
					
					Spacing += 400;
					
				}
				
				LogRow4 = new Log[3];
				
				LogRow4[0] = new Log();
				LogRow4[1] = new Log();
				LogRow4[2] = new Log();
				
					for (Log Log : LogRow4) {
						
						Log.setX(-3035);
						Log.setY(253);
						Log.setWidth(272);
						Log.setHeight(58);
						Log.setVisible(true);
						Log.setReverse(true);
						Log.setFrog(Frog);
						Log.setImage("Log.png");
						Log.setFrogLabel(FrogLabel);
						
						LogLabel = new JLabel();
						LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
						LogLabel.setIcon(LogImage);
						LogLabel.setSize(Log.getWidth(), Log.getHeight());
						Log.setX(Log.getX() + Spacing);
						LogLabel.setLocation(Log.getX(), Log.getY());
						Log.setLogLabel(LogLabel);
						container.add(LogLabel); 
						
						Spacing += 330;
						
					}
					
				LogRow5 = new Log[3];
					
				LogRow5[0] = new Log();
				LogRow5[1] = new Log();
				LogRow5[2] = new Log();
					
					for (Log Log : LogRow5) {
							
						Log.setX(-4230);
						Log.setY(313);
						Log.setWidth(272);
						Log.setHeight(58);
						Log.setVisible(true);
						Log.setMoving(false);
						Log.setFrog(Frog);
						Log.setImage("Log.png");
						Log.setFrogLabel(FrogLabel);
						
						LogLabel = new JLabel();
						LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
						LogLabel.setIcon(LogImage);
						LogLabel.setSize(Log.getWidth(), Log.getHeight());
						Log.setX(Log.getX() + Spacing);
						LogLabel.setLocation(Log.getX(), Log.getY());
						Log.setLogLabel(LogLabel);
						container.add(LogLabel); 
							
						Spacing += 320;
							
					}
						t = new Thread(this);
						t.start();
	}
	
	@Override
	public void run() {
		
		System.out.println("Thread started.");
		this.moving = true;
		while (this.moving) {
			
			LogCount = 0;
			//moving log
			for (Log Log : LogRow1) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
						}
					//update x
					Log.setX(currentX);
					Log.getLogLabel().setLocation(Log.getX(),Log.getY());
					//pause
					Log.detectCollison();
			}
			for (Log Log: LogRow2) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
						}
					//update x
					Log.setX(currentX);
					Log.getLogLabel().setLocation(Log.getX(),Log.getY());
					//pause
					Log.detectCollison();
				
			}
			for (Log Log: LogRow3) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
						}
					//update x
					Log.setX(currentX);
					Log.getLogLabel().setLocation(Log.getX(),Log.getY());
					//pause
					Log.detectCollison();
				
			}
			for (Log Log: LogRow4) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
						}
					//update x
					Log.setX(currentX);
					Log.getLogLabel().setLocation(Log.getX(),Log.getY());
					//pause
					Log.detectCollison();
				
			}
			for (Log Log: LogRow5) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
						}
					//update x
					Log.setX(currentX);
					Log.getLogLabel().setLocation(Log.getX(),Log.getY());
					//pause
					Log.detectCollison();
			}
			for (Log Log: LogRow1) {
				if (Log.detectWater() == false) {
					LogCount++;
				}
			}
			for (Log Log: LogRow2) {
				if (Log.detectWater() == false) {
					LogCount++;
				}
			}
			
			for (Log Log: LogRow3) {
				if (Log.detectWater() == false) {
					LogCount++;
				}
			}
			
			for (Log Log: LogRow4) {
				if (Log.detectWater() == false) {
					LogCount++;
				}
			}
			
			for (Log Log: LogRow5) {
				if (Log.detectWater() == false) {
					LogCount++;
				}
			}
			
			if (LogCount == 0) {
			System.out.println("Splat!");
			Frog.setX(450);
			Frog.setY(765);
			FrogLabel.setLocation(Frog.getX(), Frog.getY());
			Engine.setScore(Engine.getScore() - 50);
			}
			
			try {
				Thread.sleep(800);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}