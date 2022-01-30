package uebungen.uebung9;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Uebung9 extends JFrame{

	public Uebung9()
	{
		super();
		this.setTitle("Uebung9");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().add(new Canvas());

		this.setSize(400, 400);
		this.setLocation(200, 100);
		this.setVisible(true);
	}
	
	public class Canvas extends JPanel
	{
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			Random r = new Random();
			int red = r.nextInt(256);
			int green = r.nextInt(256);
			int blue = r.nextInt(256);
			g2.setColor(new Color(red, green, blue));

			if(this.getHeight() < this.getWidth())
			{
				int abstandObenUnten = this.getHeight() / 20;
				int seitenlaenge = this.getHeight() - (2 * abstandObenUnten);
				int links = (this.getWidth() - seitenlaenge) / 2;
				g2.fillRect(links, abstandObenUnten, seitenlaenge, seitenlaenge);
				
			}
			else
			{
				g2.setStroke(new BasicStroke(5.0f));
				int abstandlinksrechts = this.getWidth() / 20;
				int seitenlaenge = this.getWidth() - (2 * abstandlinksrechts);
				int oben = (this.getHeight() - seitenlaenge) / 2;
				g2.drawRect(abstandlinksrechts, oben, seitenlaenge, seitenlaenge);

			}	
		}
	}
	
	public static void main (String[] args) 
	{
		new Uebung9();
	}
}
