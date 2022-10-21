import javax.swing.JLabel;

public class Car extends Sprite implements Runnable {
	
	private Boolean visible, moving;
	private Thread t;
	private JLabel CarLabel;
	
	public Car() {
		super(0, 0, 135, 68, "Car.png");
		this.visible = true;
		this.moving = false;
	}
	
	public void setCarLabel(JLabel temp) {
		this.CarLabel = temp;
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
			t = new Thread(this, "Car Thread");
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
			this.CarLabel.setLocation(this.x, this.y);
			//pause
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
		System.out.println("End Thread");
	}

}
