package klausur2;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import klausur2.Figure.Shape;


public class Klausur extends JFrame implements MouseListener, MouseMotionListener{
    Canvas canvas;
    Figure figure; 
    Figure oval;
    JButton change;

    public Klausur()
    {
        super();
        this.setTitle("Klausur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.canvas.addMouseListener(this);
	    this.canvas.addMouseMotionListener(this);
        this.getContentPane().add(this.canvas, BorderLayout.CENTER);

        // von den folgenden vier Zeilen werden eventuell eine oder mehrere oder alle auskommentiert
        this.getContentPane().add(this.initNorth(), BorderLayout.NORTH);
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
        this.getContentPane().add(this.initEast(), BorderLayout.EAST);
        this.getContentPane().add(this.initWest(), BorderLayout.WEST);

        this.setSize(400, 400);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    
    
    
    
 //Zeichnen
    
    private class Canvas extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        // Implementierung von JPanel aufrufen
            Graphics2D g2 = (Graphics2D)g;  // Methoden von Graphics2D nutzbar
            // hier koennen wir zeichnen
            
            if(Klausur.this.figure != null && Klausur.this.figure.shape == Shape.RECTANGLE)
            {
            	g2.setColor(Klausur.this.figure.color);
            	g2.fillRect(Klausur.this.figure.start.x, Klausur.this.figure.start.y, Klausur.this.figure.width, Klausur.this.figure.height);
            	Klausur.this.change.setText("Ellipse");
            }
            else if(Klausur.this.figure != null && Klausur.this.figure.shape == Shape.OVAL)
            {
            	g2.setColor(Klausur.this.figure.color);
            	g2.fillOval(Klausur.this.figure.start.x, Klausur.this.figure.start.y, Klausur.this.figure.width, Klausur.this.figure.height);
            	Klausur.this.change.setText("Rechteck");
            }
        }
    }

    
    
    
    
    
    
    
 // Panel
    
    private JPanel initNorth() 
    {
        JPanel north = new JPanel();
        north.setLayout(new BorderLayout());
        this.change = new JButton("Form aendern");
        
        change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(Klausur.this.figure != null)
				{
					Klausur.this.figure.changeShape();
					Klausur.this.canvas.repaint();
				}
				
			}
        });
        
        north.add(change);
        return north;
    }

    private JPanel initSouth() 
    {
        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        JButton delete = new JButton("Loeschen");
        JButton changeC = new JButton("Farbe aendern");
        
        delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Klausur.this.figure = null;
				Klausur.this.canvas.repaint();
			}
        });
        
        changeC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(Klausur.this.figure != null)
				{
					Klausur.this.figure.changeColor();
					Klausur.this.canvas.repaint();
				}
			}
        });
        
        south.add(delete);
        south.add(changeC);
        
        return south;
    }


    private JPanel initEast() 
    {
        JPanel east = new JPanel();
        east.setLayout(new BorderLayout());
        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(Klausur.this.figure != null)
				{
					Klausur.this.figure.bigger();
					Klausur.this.canvas.repaint();
				}
			}
        });
        
        east.add(plus);
        return east;
    }

    private JPanel initWest() 
    {
        JPanel west = new JPanel();
        west.setLayout(new BorderLayout());
        JButton minus = new JButton("-");
        
        minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(Klausur.this.figure != null)
				{
					Klausur.this.figure.smaller();
					Klausur.this.canvas.repaint();
				}
			}
        });
        
        
        west.add(minus);
        return west;
    }

    public static void main(String[] args) 
    {
        new Klausur();
    }

    
    
    
    
    
    
    
    
    
 // MouseMotionListener
    
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		Point p = e.getPoint();
		int xDiff = 0;
		int yDiff = 0;
		
		//rechts, links
		if (p.x > this.figure.start.x) //wenn Maus nach rechts wandert 
		{
			xDiff = p.x - this.figure.start.x;
			this.figure.width = xDiff;
			
		}
		else if(p.x < this.figure.start.x) //wenn Maus nach links wandert
		{
			xDiff = (this.figure.start.x - p.x) + this.figure.width;
			this.figure.width = xDiff;
			this.figure.start.x = p.x;
		}
		
		//unten, oben
		if (p.y > this.figure.start.y) //wenn Maus nach unten wandert 
		{
			yDiff = p.y - this.figure.start.y;
			this.figure.height = yDiff;
		}
		else if(p.y < this.figure.start.y) //wenn Maus nach oben wandert
		{
			yDiff = (this.figure.start.y - p.y) + this.figure.height;
			this.figure.height = yDiff;
			this.figure.start.y = p.y;
		}
		
		
		
		//Leinwand neu zeichnen
		this.canvas.repaint();

		
	}

	@Override public void mouseMoved(MouseEvent e) {}

	
	
	
	
	
	
	
	
	
// MouseListener

	@Override
	public void mousePressed(MouseEvent e) 
	{
		Point p = e.getPoint();
		
		this.figure = new Figure(Shape.RECTANGLE, p);
		this.figure.changeColor();
		
	}

	
	
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}   
