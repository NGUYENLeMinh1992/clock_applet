import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;


public class Clockdigital extends Applet implements Runnable {

	GregorianCalendar cal;
	Timer clockTimer = new Timer();
	TimeZone clockTimeZone = TimeZone.getDefault();
	
	Thread t = null;  
	int hours=0, minutes=0, seconds=0;  
	String timeString = "";
	

@Override
public void init() {	
	setBackground( Color.yellow); 
}

@Override
public void paint(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillOval(40, 40, 220, 220);
	g.setColor(Color.WHITE);
	g.fillOval(50, 50, 200, 200);
	
	g.setColor( Color.BLACK );  
	g.setFont(new Font("digital-7", Font.BOLD, 50));
	g.drawString( timeString, 63, 168 );  
	
	g.setColor(Color.BLACK);
	g.setFont(new Font("Arial", Font.BOLD, 18));
	g.drawString("NGUYEN LE MINH", 70, 290);
	
	g.setColor(Color.BLACK);
	g.setFont(new Font("Tahoma", Font.BOLD, 14));
	g.drawString("DIGITAL", 120, 30);
	}
public void start() {  
    t = new Thread( this );  
    t.start();  
}  


public void run() {  
  try {  
     while (true) {  

        Calendar cal = Calendar.getInstance();  
        hours = cal.get( Calendar.HOUR_OF_DAY );  
        if ( hours > 12 ) hours -= 12;  
        minutes = cal.get( Calendar.MINUTE );  
        seconds = cal.get( Calendar.SECOND );  

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
        Date date = cal.getTime();  
        timeString = formatter.format( date );  

        repaint();  
        t.sleep( 1000 );  
     }  
  }  
  catch (Exception e) { }  
}
}

