import javax.swing.JLabel;

public class Log extends Sprite implements Runnable {
	
	private Boolean visible, moving, reverse = false;
	private Thread t;
	private JLabel LogLabel, FrogLabel;
	private Sprite Frog;
	private int LogIntersect;
	
	//parameters for the Log
	public Log() {
		super(0, 0, 58, 272, "Log.png");
		this.visible = true;
		this.moving = false;
	}
	
	public void setLogLabel(JLabel temp) {
		this.LogLabel = temp;
	}
	
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getMoving() {
		return moving;
	}

	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public Boolean getReverse() {
		return reverse;
	}

	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	
	public void setFrog (Sprite Frog) {
		this.Frog = Frog;
	}
	
	public void setFrogLabel (JLabel FrogLabel) {
		this.FrogLabel = FrogLabel;
	}
	
	public void show() {
		this.visible = true;
		
	}
	
	public void hide() {
		this.visible = false;
		
	}
	
	public void Display () {
		System.out.println("x,y: " + this.x + "," + this.y);
		System.out.println("width,height: " + this.width + "," + this.height);
		System.out.println("Frog: " + this.Image);
		System.out.println("visible: " + this.visible);
		System.out.println("moving: " + this.moving);
	}
	
	public void detectCollison() {
		if(r.intersects(Frog.getRectangle())) {
			System.out.println("Connected");
			if (this.reverse == true) {
			Frog.setX(Frog.getX() - GameProperties.CHARACTER_STEP);
			} else {
				Frog.setX(Frog.getX() + GameProperties.CHARACTER_STEP);
			}
			FrogLabel.setLocation(Frog.getX(), Frog.getY());
		}
		
		if (Frog.getY() >= 63 && Frog.getY() <= 378 && ! r.intersects(Frog.getRectangle())) {
			System.out.println("Splat!");
			Frog.setX(450);
			Frog.setY(765);
			FrogLabel.setLocation(Frog.getX(), Frog.getY());
		}
		
	}
	
	public void startMoving() {
		System.out.println("Move!");
		if (!this.moving) {
			t = new Thread(this, "Log Thread");
			t.start();
		}
	}
	
	@Override
	public void run() {
		
		System.out.println("Thread started.");
		this.moving = true;
		while (this.moving) {
			//moving log
			
			//get current x
			int currentX = this.x;
			//increase x
			if (this.reverse == true) {
				currentX -= GameProperties.CHARACTER_STEP;
				//boundary check
				if (currentX <= -this.width) {
					currentX = GameProperties.SCREEN_WIDTH + this.width;
				}
			} else {
				currentX += GameProperties.CHARACTER_STEP;
				//boundary check
				if (currentX >= GameProperties.SCREEN_WIDTH) {
					currentX = -1 * this.width;
				}
			}
			//update x
			setX(currentX);
			//System.out.println("X, Y:" + this.x + "," + this.y);
			//update CarLabel
			this.LogLabel.setLocation(this.x, this.y);
			//pause
			detectCollison();
			try {
				Thread.sleep(900);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
		
		System.out.println("End Thread");
	}
	
}
