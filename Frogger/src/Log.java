import javax.swing.JLabel;

public class Log extends Sprite implements Runnable {
	
	private Boolean visible, moving;
	private Thread t;
	private JLabel LogLabel;
	
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
			//moving car
			
			//get current x
			int currentX = this.x;
			//increase x
			currentX += GameProperties.CHARACTER_STEP;
			//boundary check
			if (currentX >= GameProperties.SCREEN_WIDTH) {
				currentX = -1 * this.width;
			}
			//update x
			this.x = currentX;
			System.out.println("X, Y:" + this.x + "," + this.y);
			//update CarLabel
			this.LogLabel.setLocation(this.x, this.y);
			//pause
			try {
				Thread.sleep(700);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
		
		System.out.println("End Thread");
	}
	
}
