

public class Log extends Sprite {
	
	private Boolean visible, moving, reverse = false;
	private int LogNum;
	
	//parameters for the Log
	public Log(int LogNum) {
		super(0, 0, 58, 272, "Log.png");
		this.visible = true;
		this.moving = false;
		this.LogNum = LogNum;
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

	public void show() {
		this.visible = true;
		
	}
	
	public void hide() {
		this.visible = false;
		
	}
	
	public int getLogNum() {
		return LogNum;
	}
	
	public void Display () {
		System.out.println("x,y: " + this.x + "," + this.y);
		System.out.println("width,height: " + this.width + "," + this.height);
		System.out.println("Frog: " + this.Image);
		System.out.println("visible: " + this.visible);
		System.out.println("moving: " + this.moving);
	}
	
}			

