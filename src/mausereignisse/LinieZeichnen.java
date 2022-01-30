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



public class LinieZeichnen extends JFrame implements MouseListener, MouseMotionListener{

	Canvas canvas;
	Linie aktLinie;
	List<Linie> linien;
	
    public LinieZeichnen()
    {
        super();
        this.setTitle("Linie zeichnen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.linien = new ArrayList<>();
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
    	
    	
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        // Implementierung von JPanel aufrufen
            Graphics2D g2 = (Graphics2D)g;  // Methoden von Graphics2D nutzbar
            // hier koennen wir zeichnen
            
            if(LinieZeichnen.this.aktLinie != null)
            {
            	 int x1 = LinieZeichnen.this.aktLinie.getXstart();
                 int y1 = LinieZeichnen.this.aktLinie.getYstart();
                 int x2 = LinieZeichnen.this.aktLinie.getXende();
                 int y2 = LinieZeichnen.this.aktLinie.getYende();

                 g2.drawLine(x1, y1, x2, y2);
            }
            
            for(Linie l : LinieZeichnen.this.linien)
            {
            	 int x1 = l.getXstart();
                 int y1 = l.getYstart();
                 int x2 = l.getXende();
                 int y2 = l.getYende();

                 g2.drawLine(x1, y1, x2, y2);
            }
        }
    }

    public static void main(String[] args) 
    {
        new LinieZeichnen();
    }

  
    
    
//MouseListener
    
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}


	@Override
	public void mousePressed(MouseEvent e) {
         
		Point p = e.getPoint();
		this.aktLinie = new Linie(p, p);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.linien.add(aktLinie);
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
		Point p = e.getPoint();
		this.aktLinie.setEnde(p);
		this.canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		/*
		Point p = e.getPoint();
	     System.out.println("mouseMoved bei [x=" + p.x +" ,y=" + p.y + "]");             
	   		*/
	}
	
}
