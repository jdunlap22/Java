import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogRows {
	
	private JLabel LogLabel;
	private ImageIcon LogImage;
	
	public LogRows(Container container) {
		
		
	Log[] LogRow1;
	
	int xoffset = 0;
	
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
			Log.setX(Log.getX() + xoffset);
			LogLabel.setLocation(Log.getX(), Log.getY());
			Log.setLogLabel(LogLabel);
			container.add(LogLabel); 
			
			xoffset += 330;
		}
	
	}
}