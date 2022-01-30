package mausereignisse;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mausereignisse extends JFrame implements MouseListener, MouseMotionListener{

	Canvas canvas;
	List<Point> points;
	
    public Mausereignisse()
    {
        super();
        this.setTitle("Mausereignisse");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.points = new ArrayList<>();
        this.canvas = new Canvas();
        this.canvas.addMouseListener(this);
        this.canvas.addMouseMotionListener(this);
        this.getContentPane().add(this.canvas);

        this.setSize(400, 300);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    private class Canvas extends JPanel
    {
    	final static int DURCHMESSSER = 20;
    	
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        // Implementierung von JPanel aufrufen
            Graphics2D g2 = (Graphics2D)g;  // Methoden von Graphics2D nutzbar
            // hier koennen wir zeichnen
            
            for(Point p : Mausereignisse.this.points)
            {
            	g2.fillOval(p.x - (DURCHMESSSER/2), p.y - (DURCHMESSSER/2), DURCHMESSSER, DURCHMESSSER);
            }
        }
    }

    public static void main(String[] args) 
    {
        new Mausereignisse();
    }

  
    
    
//MouseListener
    
	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		
		if(e.getClickCount() == 2)
		{
			this.points.add(p);
			this.canvas.repaint();
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
        //System.out.println("mousePressed"); 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
        //System.out.println("mouseReleased");            
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
        //System.out.println("mouseEntered");         
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
        //System.out.println("mouseExited");          
		
	}

	
	
	
	
//MouseMotionListener
	
	@Override
	public void mouseDragged(MouseEvent e) {
        //System.out.println("mouseDragged");     
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		/*
		Point p = e.getPoint();
	     System.out.println("mouseMoved bei [x=" + p.x +" ,y=" + p.y + "]");             
	   		*/
	}
	
}


