package klausurvorbereitung4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Rechtecke  extends JFrame implements MouseListener, MouseMotionListener{
    Canvas canvas;
    int anzklicks;
    int anz;
    int hoehe;
    int breite;
    boolean moved = false;
    boolean fixed = false;
    Point lastpoint;
    Figur rectangle;
    List<Figur> rectangles = new ArrayList<>();
    JLabel l;
    
    
    public Rechtecke()
    {
        super();
        this.setTitle("Rechtecke fixieren");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.canvas.addMouseListener(this);
	    this.canvas.addMouseMotionListener(this);
        this.getContentPane().add(this.canvas, BorderLayout.CENTER);

        // von den folgenden vier Zeilen werden eventuell eine oder mehrere oder alle auskommentiert
        this.getContentPane().add(this.initNorth(), BorderLayout.NORTH);
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
        

        this.setSize(400, 400);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    private class Canvas extends JPanel
    {
    	
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        // Implementierung von JPanel aufrufen
            Graphics2D g2 = (Graphics2D)g;  // Methoden von Graphics2D nutzbar
            // hier koennen wir zeichnen
            
            Rechtecke.this.hoehe = Rechtecke.this.canvas.getHeight()-2;
            Rechtecke.this.breite = Rechtecke.this.canvas.getWidth()-2;
            
            g2.drawRect(1, 1, breite, hoehe);
            g2.drawLine(1, (hoehe/2), breite, (hoehe/2));
            g2.drawLine((breite/2), 1, (breite/2), hoehe);
            
            if(Rechtecke.this.rectangles != null)
            {
	            for(Figur rectangle : Rechtecke.this.rectangles)
	            {
	            	g2.setColor(rectangle.getC());
	            	g2.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getH(), rectangle.getB());
	            }
            }
        }
    }

    private JPanel initNorth() 
    {
        JPanel north = new JPanel();
        // hier das JPanel fuer NORTH befuellen
        
        this.l = new JLabel(this.anz + " Rechtecke fixiert");
        l.setFont(new Font("Verdana", Font.ITALIC, 15));
        north.add(l);
        
        return north;
    }

    private JPanel initSouth() 
    {
        JPanel south = new JPanel();
        // hier das JPanel fuer SOUTH befuellen
        
        JButton clear = new JButton("clear");
        JButton rect = new JButton("rectangle");

        rect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Rechtecke.this.anzklicks++;
				switch(Rechtecke.this.anzklicks)
            	{
					case 1 : Rechtecke.this.rectangle = new Figur(Rechtecke.this.breite/4, Rechtecke.this.hoehe/4, (Rechtecke.this.breite/2)-1, (Rechtecke.this.hoehe/2)-1, Color.GREEN);
							 break;
					case 2 : Rechtecke.this.rectangle = new Figur(Rechtecke.this.breite/4, Rechtecke.this.hoehe/4, (Rechtecke.this.breite/2)-1, (Rechtecke.this.hoehe/2)-1, Color.RED);
							 break;
					case 3 : Rechtecke.this.rectangle = new Figur(Rechtecke.this.breite/4, Rechtecke.this.hoehe/4, (Rechtecke.this.breite/2)-1, (Rechtecke.this.hoehe/2)-1, Color.YELLOW);
							 break;
					case 4 : Rechtecke.this.rectangle = new Figur(Rechtecke.this.breite/4, Rechtecke.this.hoehe/4, (Rechtecke.this.breite/2)-1, (Rechtecke.this.hoehe/2)-1, Color.BLACK);
					   		 break;
			    }
				Rechtecke.this.rectangles.add(Rechtecke.this.rectangle);
				Rechtecke.this.canvas.repaint();
			}
        });
        
        
        clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Rechtecke.this.rectangles = new ArrayList<>();
				Rechtecke.this.anzklicks = 0;
				Rechtecke.this.anz = 0;
				Rechtecke.this.moved = false;
				Rechtecke.this.lastpoint = null;
				Rechtecke.this.fixed = false;
				Rechtecke.this.canvas.repaint();
			}
        });
        
        south.add(clear);
        south.add(rect);
        
        return south;
    }



    public static void main(String[] args) 
    {
        new Rechtecke();
    }

    
//MouseMotionListener
    
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(Rechtecke.this.moved && !Rechtecke.this.fixed)
		{
			System.out.println("dragged" + e.getX() + ", " + e.getY());
			int x = e.getX();
			int y = e.getY();
			
			int xr = Rechtecke.this.lastpoint.x;
			int yr = Rechtecke.this.lastpoint.y;
			
			int diffx = x - xr;
			int diffy = y - yr;
			
			
			int newx = Rechtecke.this.rectangle.getX() + diffx;
			int newy = Rechtecke.this.rectangle.getY() + diffy;
				
			Rechtecke.this.rectangle.setX(newx);
			Rechtecke.this.rectangle.setY(newy);
			
		
			
			
			// fixieren
			
			final int ABSTAND = 30;
			int xAbstand = 0;
			int yAbstand = 0;
			
			if(Rechtecke.this.rectangle.getC() == Color.GREEN)
			{
				xAbstand = Math.abs(Rechtecke.this.rectangle.getX() - Rechtecke.this.canvas.getX());
	            yAbstand = Math.abs(Rechtecke.this.rectangle.getY() - Rechtecke.this.canvas.getY());
	            
	            if(ABSTAND >= xAbstand && ABSTAND >= yAbstand)
				{
					Rechtecke.this.rectangle.setX(1);
					Rechtecke.this.rectangle.setY(1);
					Rechtecke.this.fixed = true;
					Rechtecke.this.anz++;
					this.l.setText(this.anz + " Rechteck fixiert");
				}
			}
			else if(Rechtecke.this.rectangle.getC() == Color.RED)
			{
				xAbstand = Math.abs(Rechtecke.this.rectangle.getX() - (Rechtecke.this.breite/2));
	            yAbstand = Math.abs(Rechtecke.this.rectangle.getY() - 0);
	            
	            if(ABSTAND >= xAbstand && ABSTAND >= yAbstand)
				{
					Rechtecke.this.rectangle.setX((Rechtecke.this.breite/2)+1);
					Rechtecke.this.rectangle.setY(1);
					Rechtecke.this.fixed = true;
					Rechtecke.this.anz++;
					this.l.setText(this.anz + " Rechtecke fixiert");
				}
			}
			else if(Rechtecke.this.rectangle.getC() == Color.YELLOW)
			{
				xAbstand = Math.abs(Rechtecke.this.rectangle.getX() - 0);
	            yAbstand = Math.abs(Rechtecke.this.rectangle.getY() - (Rechtecke.this.hoehe/2));
	            
	            if(ABSTAND >= xAbstand && ABSTAND >= yAbstand)
				{
					Rechtecke.this.rectangle.setX(1);
					Rechtecke.this.rectangle.setY(((Rechtecke.this.hoehe/2)+1));
					Rechtecke.this.fixed = true;
					Rechtecke.this.anz++;
					this.l.setText(this.anz + " Rechtecke fixiert");
				}
			}
			else if(Rechtecke.this.rectangle.getC() == Color.BLACK)
			{
				xAbstand = Math.abs(Rechtecke.this.rectangle.getX() - (Rechtecke.this.breite/2));
	            yAbstand = Math.abs(Rechtecke.this.rectangle.getY() - (Rechtecke.this.hoehe/2));
	            
	            if(ABSTAND >= xAbstand && ABSTAND >= yAbstand)
				{
					Rechtecke.this.rectangle.setX(((Rechtecke.this.breite/2)+1));
					Rechtecke.this.rectangle.setY(((Rechtecke.this.hoehe/2)+1));
					Rechtecke.this.fixed = true;
					Rechtecke.this.anz++;
					this.l.setText("ENDE: 4 Rechtecke fixiert");
				}
			}
		
			Rechtecke.this.canvas.repaint();
			Rechtecke.this.lastpoint = e.getPoint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
//MouseListener
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		System.out.println("pressed: " + e.getX() + ", " + e.getY());
		
		if(Rechtecke.this.fixed == false)
		{
			int x = e.getX();
			int y = e.getY();
			
			int xs = Rechtecke.this.rectangle.getX();
			int ys = Rechtecke.this.rectangle.getY();
			
			int hoehe = Rechtecke.this.rectangle.getH();
			int breite = Rechtecke.this.rectangle.getB();
			
			if(x >= xs && x <= (xs + breite) && y >= ys && y <= (ys + hoehe))
			{
				Rechtecke.this.moved = true;
				Rechtecke.this.lastpoint = e.getPoint();
	
			}
			
			
			
			
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		Rechtecke.this.moved = false;
		Rechtecke.this.fixed = false;
		Rechtecke.this.lastpoint = null;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}   
