import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;


public class Clockanalog extends Applet {

	GregorianCalendar cal;
	Timer clockTimer = new Timer();
	TimeZone clockTimeZone = TimeZone.getDefault();

public Clockanalog() {
	clockTimer.schedule(new TickTimerTask(), 0, 1000);
}
class TickTimerTask extends TimerTask {

@Override
public void run() {
	cal = (GregorianCalendar) GregorianCalendar.getInstance(clockTimeZone);
	repaint();
}
}

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
	double second = cal.get(Calendar.SECOND);
	double minute = cal.get(Calendar.MINUTE);
	double hours = cal.get(Calendar.HOUR);
	//Ve mat dong ho
	for (int i = 0; i < 60; i++) {
		int length = 90;
		double rad = (i * 6) * (Math.PI) / 180;
		if (i % 5 == 0) {
			length = 82;
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.RED);
		}
		int x = 150 + (int) (95 * Math.cos(rad - (Math.PI / 2)));
		int y = 150 + (int) (95 * Math.sin(rad - (Math.PI / 2)));
		int x1 = 150 + (int) (length * Math.cos(rad - (Math.PI / 2)));
		int y1 = 150 + (int) (length * Math.sin(rad - (Math.PI / 2)));
		g.drawLine(x, y, x1, y1);
}
	

//ve kim dong ho
	drawHands(g, second, minute, hours);
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	g.setColor(Color.BLACK);
	g.setFont(new Font("digital-7", Font.BOLD, 15));
	g.drawString(sdf.format(cal.getTime()), 130, 190);
	g.setColor(Color.BLACK);
	g.setFont(new Font("Arial", Font.BOLD, 18));
	g.drawString("NGUYEN LE MINH", 70, 290);
	g.setColor(Color.BLACK);
	g.setFont(new Font("Tahoma", Font.BOLD, 14));
	g.drawString("ANALOG", 120, 30);
}

public void drawHands(Graphics g, double second, double minute, double hours) {
	double rSecond = (second * 6) * (Math.PI) / 180;
	double rMinute = ((minute + (second / 60)) * 6) * (Math.PI) / 180;
	double rHours = ((hours + (minute / 60)) * 30) * (Math.PI) / 180;
	
	//Kim giay
	g.setColor(Color.BLACK);
	g.drawLine(150, 150, 150 + (int) (100 * Math.cos(rSecond - (Math.PI / 2))), 150 + (int) (100 * Math.sin(rSecond - (Math.PI / 2))));
	// Kim phut
	g.setColor(Color.RED);
	g.drawLine(150, 150, 150 + (int) (70 * Math.cos(rMinute - (Math.PI / 2))), 150 + (int) (70 * Math.sin((rMinute - (Math.PI / 2)))));
	// Kim gio
	g.setColor(Color.GREEN);
	g.drawLine(150, 150, 150 + (int) (50 * Math.cos(rHours - (Math.PI / 2))), 150 + (int) (50 * Math.sin(rHours - (Math.PI / 2))));

}
}