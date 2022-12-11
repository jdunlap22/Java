
public class CarRows {
	
		
	public CarRows(Sprite Frog, Engine Engine) {
		
		
	Car[] CarRow1;
	Car[] CarRow2;
	Car[] CarRow3;
	
	
	CarRow1 = new Car[3];
	
	CarRow1[0] = new Car(1);
	CarRow1[1] = new Car(2);
	CarRow1[2] = new Car(3);
	
		for (Car Car : CarRow1) {
			
			Car.setX(0);
			Car.setY(434);
			Car.setWidth(135);
			Car.setHeight(68);
			Car.setVisible(true);
			Car.setMoving(false);
			Car.setImage("Car.png");
			
			Car.startMoving();
			System.out.println("Moving");
		}
		
		CarRow2 = new Car[3];
		
		CarRow2[0] = new Car(4);
		CarRow2[1] = new Car(5);
		CarRow2[2] = new Car(6);
		
			for (Car Car : CarRow2) {
				
				Car.setX(-480);
				Car.setY(558);
				Car.setWidth(135);
				Car.setHeight(68);
				Car.setVisible(true);
				Car.setReverse(true);
				Car.setImage("Car.png");
				
				Car.startMoving();
				System.out.println("Moving");
			}
			
			CarRow3 = new Car[3];
			
			CarRow3[0] = new Car(7);
			CarRow3[1] = new Car(8);
			CarRow3[2] = new Car(9);
			
				for (Car Car : CarRow3) {
					
					Car.setX(-1590);
					Car.setY(683);
					Car.setWidth(135);
					Car.setHeight(68);
					Car.setVisible(true);
					Car.setMoving(false);
					Car.setImage("Car.png");
					
					Car.startMoving();
					System.out.println("Moving");
				}
	
	}
}
