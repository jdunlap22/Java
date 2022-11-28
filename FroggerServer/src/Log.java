

public class Log extends Sprite {
	
	private Boolean visible, moving, reverse = false;
	private Sprite Frog;
	
	//parameters for the Log
	public Log() {
		super(0, 0, 58, 272, "Log.png");
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
			setFrogOnLog(true);
			if (this.reverse == true) {
			Frog.setX(Frog.getX() - GameProperties.CHARACTER_STEP);
			} else {
				Frog.setX(Frog.getX() + GameProperties.CHARACTER_STEP);
			}
		}	
		if (getFrogOnLog() == true && ! r.intersects(Frog.getRectangle())) {
			setFrogOnLog(false);
		}
	}
	
	public boolean detectWater() {
		
		if (Frog.getY() >= 63 && Frog.getY() <= 378 && ! r.intersects(Frog.getRectangle()) && getFrogOnLog() == false) {
			return true;
		}
		return false;
	}
}			

