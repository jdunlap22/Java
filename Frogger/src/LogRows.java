import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogRows {
	
	private JLabel LogLabel;
	private ImageIcon LogImage;
	
	public LogRows(Container container) {
		
		
	Log[] LogRow1;
	Log[] LogRow2;
	Log[] LogRow3;
	
	int Spacing = 0;
	
	LogRow1 = new Log[3];
	
	LogRow1[0] = new Log();
	LogRow1[1] = new Log();
	LogRow1[2] = new Log();
	
		for (Log Log : LogRow1) {
			
			Log.setX(0);
			Log.setY(65);
			Log.setWidth(272);
			Log.setHeight(58);
			Log.setVisible(true);
			Log.setMoving(false);
			Log.setImage("Log.png");
			
			LogLabel = new JLabel();
			LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
			LogLabel.setIcon(LogImage);
			LogLabel.setSize(Log.getWidth(), Log.getHeight());
			Log.setX(Log.getX() + Spacing);
			LogLabel.setLocation(Log.getX(), Log.getY());
			Log.setLogLabel(LogLabel);
			container.add(LogLabel); 
			
			Spacing += 320;
		}
		
		LogRow2 = new Log[3];
		
		LogRow2[0] = new Log();
		LogRow2[1] = new Log();
		LogRow2[2] = new Log();
		
			for (Log Log : LogRow2) {
				
				Log.setX(-915);
				Log.setY(130);
				Log.setWidth(272);
				Log.setHeight(58);
				Log.setVisible(true);
				Log.setMoving(false);
				Log.setImage("Log.png");
				
				LogLabel = new JLabel();
				LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
				LogLabel.setIcon(LogImage);
				LogLabel.setSize(Log.getWidth(), Log.getHeight());
				Log.setX(Log.getX() + Spacing);
				LogLabel.setLocation(Log.getX(), Log.getY());
				Log.setLogLabel(LogLabel);
				container.add(LogLabel); 
				
				Spacing += 340;
			}
			
			LogRow3 = new Log[3];
			
			LogRow3[0] = new Log();
			LogRow3[1] = new Log();
			LogRow3[2] = new Log();
			
				for (Log Log : LogRow3) {
					
					Log.setX(-1980);
					Log.setY(195);
					Log.setWidth(272);
					Log.setHeight(58);
					Log.setVisible(true);
					Log.setMoving(false);
					Log.setImage("Log.png");
					
					LogLabel = new JLabel();
					LogImage = new ImageIcon(getClass().getResource(Log.getImage()));
					LogLabel.setIcon(LogImage);
					LogLabel.setSize(Log.getWidth(), Log.getHeight());
					Log.setX(Log.getX() + Spacing);
					LogLabel.setLocation(Log.getX(), Log.getY());
					Log.setLogLabel(LogLabel);
					container.add(LogLabel); 
					
					Spacing += 400;
				}
	
	}
}