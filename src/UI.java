import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {
	
    private JFrame frame;
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UI window = new UI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JPanel panel_1 = new JPanel();
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(new CardLayout(0, 0));

        final Clockanalog clk1 = new Clockanalog();
        panel_2.add(clk1, "Analog");
        final Clockdigital clk2 = new Clockdigital();
        panel_2.add(clk2, "Digital");

        JPanel panel_3 = new JPanel();
        frame.getContentPane().add(panel_3, BorderLayout.WEST);

        JButton btnNewButton = new JButton("Change clock");
        panel_3.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clk1.setVisible(!clk1.isVisible());
                clk2.setVisible(!clk2.isVisible());
            }
        });

        clk1.setVisible(true);
        clk2.setVisible(false);
    }
}
