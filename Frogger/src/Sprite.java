
public class Sprite {

	//variables used for positioning
	protected int x, y;
	protected int height, width;
	protected String Image;
	
	private Boolean visible, moving;
	
	//getters and setters
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public String getImage() {
		return Image;
	}
	
	public void setImage(String image) {
		Image = image;
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
	
	public void move() {
		this.moving = true;
	}
	
	//constructor 1
	public Sprite() {
		super();
		this.x = -1;
		this.y = -1;
		this.width = -1;
		this.height = -1;
		this.Image = "";
	}
	
	//open constructor that can be overloaded
	public Sprite(int x, int y, int width, int height, String Image) {
		super();
		this.x = x;
		this.y = y;
		this.width = height;
		this.height = width;
		this.Image = Image;
	}
	
	//displaying the positions
	public void Display () {
		System.out.println("x,y: " + this.x + "," + this.y);
		System.out.println("width,height: " + this.width + "," + this.height);
		System.out.println("Frog: " + this.Image);
		System.out.println("visible: " + this.visible);
		System.out.println("moving: " + this.moving);
	}
	
}
