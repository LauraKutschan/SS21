package uebungen.uebung10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RechteckeZeichnen extends JFrame implements MouseListener , MouseMotionListener{

	//Objektvariablen
	private Canvas canvas;
	private Rechteck aktRechteck;
	private Color aktColor;
	private Map<Rechteck, Color> rechtecke;
	
	public RechteckeZeichnen()
	{
		this.setTitle("Rechtecke Zeichnen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Collection für die Rechtecke erstellen
		this.rechtecke = new LinkedHashMap<>();
		
		//Leinwand anlegen
		this.canvas = new Canvas();
	    this.canvas.addMouseListener(this);
	    this.canvas.addMouseMotionListener(this);
	    this.getContentPane().add(this.canvas);
		
		//Größe und Ort
		this.setSize(400, 300);
		this.setLocation(300, 200);
		this.setVisible(true);
	}
	
	
	//Leinwand
	private class Canvas extends JPanel
	{
		protected void paintComponent(Graphics g)
		{
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D) g;
			
			
			//aktuelles Rechteck zeichnen, falls es aktuell eins gibt
			if(RechteckeZeichnen.this.aktRechteck != null)
			{
				g2.setColor(aktColor);
				
				int x = RechteckeZeichnen.this.aktRechteck.getX();
				int y = RechteckeZeichnen.this.aktRechteck.getY();
				int width = RechteckeZeichnen.this.aktRechteck.getWidth();
				int height = RechteckeZeichnen.this.aktRechteck.getHeight();
				
				g2.fillRect(x,  y,  width,  height);
			}
			
			//gespeicherte Rechtecke zeichnen
			for(Map.Entry<Rechteck, Color> entry : RechteckeZeichnen.this.rechtecke.entrySet())
			{
				Rechteck r = entry.getKey();
				Color c = entry.getValue();
				
				g2.setColor(c);
				int x = r.getX();
				int y = r.getY();
				int width = r.getWidth();
				int height = r.getHeight();
				
				g2.fillRect(x,  y,  width,  height);
			}
		}
	}
	

	
	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		
		this.aktRechteck = new Rechteck(p.x, p.y, 0, 0);
		
		Random r = new Random();
		int rot = r.nextInt(256);
		int gruen = r.nextInt(256);
		int blau = r.nextInt(256);
		
		this.aktColor = new Color(rot, gruen, blau);

	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {

		Point p = e.getPoint();
		
		//rechts, links
		if (p.x > this.aktRechteck.getX()) //wenn Maus nach rechts wandert 
		{
			int width = p.x - this.aktRechteck.getX();
			this.aktRechteck.setWidth(width);
		}
		else if(p.x < this.aktRechteck.getX()) //wenn Maus nach links wandert
		{
			int width = (this.aktRechteck.getX() - p.x) + this.aktRechteck.getWidth();
			this.aktRechteck.setWidth(width);
			this.aktRechteck.setX(p.x);
		}
		
		//unten, oben
		if (p.y > this.aktRechteck.getY()) //wenn Maus nach unten wandert 
		{
			int height = p.y - this.aktRechteck.getY();
			this.aktRechteck.setHeight(height);
		}
		else if(p.y < this.aktRechteck.getY()) //wenn Maus nach oben wandert
		{
			int height = (this.aktRechteck.getY() - p.y) + this.aktRechteck.getHeight();
			this.aktRechteck.setHeight(height);
			this.aktRechteck.setY(p.y);
		}
		
		//Leinwand neu zeichnen
		this.canvas.repaint();

	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		//aktuelles Rechteck speichern
		this.rechtecke.put(this.aktRechteck, this.aktColor);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) 
	{
		new RechteckeZeichnen();
	}
	

}
