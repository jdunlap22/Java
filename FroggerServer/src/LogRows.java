import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class LogRows extends Sprite implements Runnable {
	
	private Boolean moving = true;
	final static int SERVER_PORT = 5556;
	
	Log[] LogRow1;
	Log[] LogRow2;
	Log[] LogRow3;
	Log[] LogRow4;
	Log[] LogRow5;
	Thread t;
	
	public LogRows(Sprite Frog, Engine Engine) {
		
	this.Engine = Engine;
	
	
	LogRow1 = new Log[3];
	
	LogRow1[0] = new Log(1);
	LogRow1[1] = new Log(2);
	LogRow1[2] = new Log(3);
	
		for (Log Log : LogRow1) {
			
			Log.setX(0);
			Log.setY(65);
			Log.setWidth(272);
			Log.setHeight(58);
			Log.setVisible(true);
			Log.setMoving(false);
			Log.setImage("Log.png");
						
		}
		
		LogRow2 = new Log[3];
		
		LogRow2[0] = new Log(4);
		LogRow2[1] = new Log(5);
		LogRow2[2] = new Log(6);
		
			for (Log Log : LogRow2) {
				
				Log.setX(-915);
				Log.setY(128);
				Log.setWidth(272);
				Log.setHeight(58);
				Log.setVisible(true);
				Log.setReverse(true);
				Log.setImage("Log.png");
				
			}
			
			LogRow3 = new Log[3];
			
			LogRow3[0] = new Log(7);
			LogRow3[1] = new Log(8);
			LogRow3[2] = new Log(9);
			
				for (Log Log : LogRow3) {
					
					Log.setX(-1980);
					Log.setY(190);
					Log.setWidth(272);
					Log.setHeight(58);
					Log.setVisible(true);
					Log.setMoving(false);
					Log.setImage("Log.png");
										
				}
				
				LogRow4 = new Log[3];
				
				LogRow4[0] = new Log(10);
				LogRow4[1] = new Log(11);
				LogRow4[2] = new Log(12);
				
					for (Log Log : LogRow4) {
						
						Log.setX(-3035);
						Log.setY(253);
						Log.setWidth(272);
						Log.setHeight(58);
						Log.setVisible(true);
						Log.setReverse(true);
						Log.setImage("Log.png");
											
					}
					
				LogRow5 = new Log[3];
					
				LogRow5[0] = new Log(13);
				LogRow5[1] = new Log(14);
				LogRow5[2] = new Log(15);
					
					for (Log Log : LogRow5) {
							
						Log.setX(-4230);
						Log.setY(313);
						Log.setWidth(272);
						Log.setHeight(58);
						Log.setVisible(true);
						Log.setMoving(false);
						Log.setImage("Log.png");
														
					}
						t = new Thread(this);
						t.start();
	}
	
	@Override
	public void run() {
		
		System.out.println("Thread started.");
		this.moving = true;
		while (this.moving) {
			
			//moving log
			for (Log Log : LogRow1) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
							
							try {
								Socket s = new Socket("localhost", SERVER_PORT);
								OutputStream outstream = s.getOutputStream();
								PrintWriter out = new PrintWriter(outstream);
								String command = "LOG_POSITION " + Log.getLogNum() + " " + currentX;
								System.out.println("Sending: " + command);
								out.println(command);
								out.flush();
								s.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					//update x
					Log.setX(currentX);
			}
			for (Log Log: LogRow2) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
							
							try {
								Socket s = new Socket("localhost", SERVER_PORT);
								OutputStream outstream = s.getOutputStream();
								PrintWriter out = new PrintWriter(outstream);
								String command = "LOG_POSITION " + Log.getLogNum() + " " + currentX;
								System.out.println("Sending: " + command);
								out.println(command);
								out.flush();
								s.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					//update x
					Log.setX(currentX);
				
			}
			for (Log Log: LogRow3) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
							
							try {
								Socket s = new Socket("localhost", SERVER_PORT);
								OutputStream outstream = s.getOutputStream();
								PrintWriter out = new PrintWriter(outstream);
								String command = "LOG_POSITION " + Log.getLogNum() + " " + currentX;
								System.out.println("Sending: " + command);
								out.println(command);
								out.flush();
								s.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					//update x
					Log.setX(currentX);
				
			}
			for (Log Log: LogRow4) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
							
							try {
								Socket s = new Socket("localhost", SERVER_PORT);
								OutputStream outstream = s.getOutputStream();
								PrintWriter out = new PrintWriter(outstream);
								String command = "LOG_POSITION " + Log.getLogNum() + " " + currentX;
								System.out.println("Sending: " + command);
								out.println(command);
								out.flush();
								s.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					//update x
					Log.setX(currentX);
				
			}
			for (Log Log: LogRow5) {
				//get current x
				int currentX = Log.getX();
				//increase x
					if (Log.getReverse() == true) {
						currentX -= GameProperties.CHARACTER_STEP;
						//boundary check
						if (currentX <= - Log.getWidth()) {
							currentX = GameProperties.SCREEN_WIDTH + Log.getWidth();
						}
						} else {
							currentX += GameProperties.CHARACTER_STEP;
							//boundary check
							if (currentX >= GameProperties.SCREEN_WIDTH) {
								currentX = -1 * Log.getWidth();
							}
							
							try {
								Socket s = new Socket("localhost", SERVER_PORT);
								OutputStream outstream = s.getOutputStream();
								PrintWriter out = new PrintWriter(outstream);
								String command = "LOG_POSITION " + Log.getLogNum() + " " + currentX;
								System.out.println("Sending: " + command);
								out.println(command);
								out.flush();
								s.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					//update x
					Log.setX(currentX);
			}
			
			try {
				Thread.sleep(800);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}