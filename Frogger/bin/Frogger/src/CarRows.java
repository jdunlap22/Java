import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CarRows {
	
	private JLabel CarLabel, FrogLabel;
	private ImageIcon CarImage;
	private Sprite Frog = new Sprite();
	
	public void setFrog(Sprite Frog) {
		this.Frog = Frog;
	}
	
	public CarRows(Container container, Sprite Frog, JLabel FrogLabel) {
		
		
	Car[] CarRow1;
	Car[] CarRow2;
	Car[] CarRow3;
	
	int xoffset = 0;
	
	CarRow1 = new Car[3];
	
	CarRow1[0] = new Car();
	CarRow1[1] = new Car();
	CarRow1[2] = new Car();
	
		for (Car Car : CarRow1) {
			
			Car.setX(0);
			Car.setY(434);
			Car.setWidth(135);
			Car.setHeight(68);
			Car.setVisible(true);
			Car.setMoving(false);
			Car.setFrog(Frog);
			Car.setImage("Car.png");
			Car.setFrogLabel(FrogLabel);
			
			CarLabel = new JLabel();
			CarImage = new ImageIcon(getClass().getResource(Car.getImage()));
			CarLabel.setIcon(CarImage);
			CarLabel.setSize(Car.getWidth(), Car.getHeight());
			Car.setX(Car.getX() + xoffset);
			CarLabel.setLocation(Car.getX(), Car.getY());
			Car.setCarLabel(CarLabel);
			container.add(CarLabel);
			
			xoffset += 290;
			
			Car.startMoving();
		}
		
		CarRow2 = new Car[3];
		
		CarRow2[0] = new Car();
		CarRow2[1] = new Car();
		CarRow2[2] = new Car();
		
			for (Car Car : CarRow2) {
				
				Car.setX(-480);
				Car.setY(558);
				Car.setWidth(135);
				Car.setHeight(68);
				Car.setVisible(true);
				Car.setReverse(true);
				Car.setFrog(Frog);
				Car.setImage("Car.png");
				Car.setFrogLabel(FrogLabel);
				
				CarLabel = new JLabel();
				CarImage = new ImageIcon(getClass().getResource(Car.getImage()));
				CarLabel.setIcon(CarImage);
				CarLabel.setSize(Car.getWidth(), Car.getHeight());
				Car.setX(Car.getX() + xoffset);
				CarLabel.setLocation(Car.getX(), Car.getY());
				Car.setCarLabel(CarLabel);
				container.add(CarLabel);
				
				xoffset += 250;
				
				Car.startMoving();
			}
			
			CarRow3 = new Car[3];
			
			CarRow3[0] = new Car();
			CarRow3[1] = new Car();
			CarRow3[2] = new Car();
			
				for (Car Car : CarRow3) {
					
					Car.setX(-1590);
					Car.setY(683);
					Car.setWidth(135);
					Car.setHeight(68);
					Car.setVisible(true);
					Car.setMoving(false);
					Car.setFrog(Frog);
					Car.setImage("Car.png");
					Car.setFrogLabel(FrogLabel);
					
					CarLabel = new JLabel();
					CarImage = new ImageIcon(getClass().getResource(Car.getImage()));
					CarLabel.setIcon(CarImage);
					CarLabel.setSize(Car.getWidth(), Car.getHeight());
					Car.setX(Car.getX() + xoffset);
					CarLabel.setLocation(Car.getX(), Car.getY());
					Car.setCarLabel(CarLabel);
					container.add(CarLabel);
					
					xoffset += 250;
					
					Car.startMoving();
				}
	
	}
}
