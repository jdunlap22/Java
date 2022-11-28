

public class Car extends Sprite implements Runnable {
	
	private Boolean visible, moving, reverse = false;
	private Thread t;
	private Sprite Frog;
	
	public Car() {
		super(0, 0, 135, 68, "Car.png");
		this.visible = true;
		this.moving = false;
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
			System.out.println("Splat!");
			Frog.setX(450);
			Frog.setY(765);
			Engine.setScore(Engine.getScore() - 50);			
		}
	}
	
	public void startMoving() {
		if (!this.moving) {
			t = new Thread(this, "Car Thread");
			t.start();
		}
	}
	
	@Override
	public void run() {
		
		this.moving = true;
		while (this.moving) {
			//moving car
			
			//get current x
			int currentX = this.x;
			//increase x
			if (this.reverse == true) {
				currentX -= GameProperties.CHARACTER_STEP;
				//boundary check
				if (currentX <= - this.width) {
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

			//pause
			detectCollison();
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
		System.out.println("End Thread");
	}

}
