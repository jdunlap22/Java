import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CarRows {
	
	private JLabel CarLabel;
	private ImageIcon CarImage;
	
	public CarRows(Container container) {
		
		
	Car[] CarRow1;
	
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
			Car.setImage("Car.png");
			
			CarLabel = new JLabel();
			CarImage = new ImageIcon(getClass().getResource(Car.getImage()));
			CarLabel.setIcon(CarImage);
			CarLabel.setSize(Car.getWidth(), Car.getHeight());
			Car.setX(Car.getX() + xoffset);
			CarLabel.setLocation(Car.getX(), Car.getY());
			Car.setCarLabel(CarLabel);
			container.add(CarLabel);
			
			xoffset += 280;
		}
	
	}
}
