import java.awt.Container;

public class CarRows {
	
		
	public CarRows(Container container, Sprite Frog, Engine Engine) {
		
		
	Car[] CarRow1;
	Car[] CarRow2;
	Car[] CarRow3;
	
	
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
					
					Car.startMoving();
				}
	
	}
}
