package ereignisbehandlung;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.awt.geom.Arc2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Zeichnen extends JFrame {

	public Zeichnen()
	{
		super();
		this.setTitle("Zeichnen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Canvas content = new Canvas();
		this.getContentPane().add(content);
		this.setSize(500, 600);
		this.setLocation(200, 100);
		this.setVisible(true);
		
	}
	

	public class Canvas extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			// Formen
			g2.setColor(Color.WHITE);
			g2.fillOval(40, 30, 200, 200);
			g2.setColor(Color.MAGENTA);
			g2.drawRect(40, 30, 200, 200);
			
			
			// Kreisbogen
			g2.setColor(Color.RED);
			g2.drawArc(280, 40, 200, 200, 0, 139);
			
			Shape arc = new Arc2D.Double(40, 280, 200, 200, 0, 237, Arc2D.PIE);		// Arc2D.PIE --> geschlossener Bogen (Arc2D.OPEN ---> offener Bogen)
			g2.setColor(Color.BLUE);
			g2.draw(arc);
			
			// HERZ
			g2.setColor(Color.RED);
			g2.drawArc(240, 40, 200, 200, 340, 200);
			
			g2.setColor(Color.RED);
			g2.drawArc(40, 40, 200, 200, 0, 200);
			
			g2.drawLine(46, 174, 240, 400);
			g2.drawLine(434, 173, 240, 400);
			
		}
	}
	
	
	
	public static void main(String[] args) 
	{
		new Zeichnen();
	}
}
