package klausurvorbereitung1;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import klausurwdhlg.Klausur;


public class Quadrat extends JFrame implements MouseListener, MouseMotionListener{

	Canvas canvas;
	Boolean neuClicked = false;
	Boolean fillClicked = false;
	int length;
	int x;
	int y;
	JButton fill;
	JButton neu;
	int red;
	int blue;
	int green;
	Point lastpoint;
	Boolean obereKgetroffen = false;
	Boolean untereKgetroffen = false;
	Boolean	linkeKgetroffen = false;
	Boolean rechteKgetroffen = false;
	
	public Quadrat()
	{
        super();
        this.setTitle("Quadrat");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.canvas.addMouseListener(this);
	    this.canvas.addMouseMotionListener(this);
        this.getContentPane().add(this.canvas, BorderLayout.CENTER);
       
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
 
        this.setSize(400, 400);
        this.setLocation(300,200);
        this.setVisible(true);
    }

	
	
	
	
	
//Canvas
	
    private class Canvas extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        // Implementierung von JPanel aufrufen
            Graphics2D g2 = (Graphics2D)g;  // Methoden von Graphics2D nutzbar
            // hier koennen wir zeichnen
            
        
            g2.setStroke(new BasicStroke(3.0f));
            
            if(Quadrat.this.neuClicked || Quadrat.this.fillClicked && Quadrat.this.fill.getText() == "unfill")
            {
            	g2.drawRect(Quadrat.this.x, Quadrat.this.y, Quadrat.this.length, Quadrat.this.length);
            	
            	Quadrat.this.fill.setText("fill");
        
            } 
            else if(Quadrat.this.fillClicked && Quadrat.this.fill.getText() == "fill")
            {
    			g2.setColor(new Color(Quadrat.this.red, Quadrat.this.green, Quadrat.this.blue));
    			
    			g2.fillRect(Quadrat.this.x, Quadrat.this.y, Quadrat.this.length, Quadrat.this.length);
            	
    			g2.setStroke(new BasicStroke(3.0f));
    			g2.setColor(Color.BLACK);
    			g2.drawRect(Quadrat.this.x, Quadrat.this.y, Quadrat.this.length, Quadrat.this.length);
    			
    			Quadrat.this.fill.setText("unfill");

            }
            
            Quadrat.this.neuClicked = false;
            Quadrat.this.fillClicked = false;
        }
    }
    
    
    
    
    
    
    
    
//SOUTH

    private JPanel initSouth() 
    {
        JPanel south = new JPanel();
        
        Quadrat.this.neu = new JButton("new");
        neu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Quadrat.this.neuClicked = true;
				
				int width = Quadrat.this.canvas.getWidth();
				int height = Quadrat.this.canvas.getHeight();
				
				if(width > height)
            	{
            		Quadrat.this.length = (int) (height*0.8);
            		Quadrat.this.x = (width-length)/2;
            		Quadrat.this.y = (int) (height*0.1);
            	}
            	else if(height >= width)
            	{
            		Quadrat.this.length = (int) (width*0.8);
            		Quadrat.this.x = (int) (width*0.1);
            		Quadrat.this.y = (height-length)/2;
            	}
				
				Quadrat.this.canvas.repaint();
				neu.setText("refresh");
				
				Random r = new Random();
    			Quadrat.this.red = r.nextInt(256);
    			Quadrat.this.green = r.nextInt(256);
    			Quadrat.this.blue = r.nextInt(256);
			}
        });
        
        Quadrat.this.fill = new JButton("fill");
        
        Quadrat.this.fill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Quadrat.this.fillClicked = true;
				
				int width = Quadrat.this.canvas.getWidth();
				int height = Quadrat.this.canvas.getHeight();
			
				if(width > height)
				{						Quadrat.this.length = (int) (height*0.8);
					Quadrat.this.x = (width-length)/2;
					Quadrat.this.y = (int) (height*0.1);
				}
				else if(height >= width)
				{
					Quadrat.this.length = (int) (width*0.8);
					Quadrat.this.x = (int) (width*0.1);
           			Quadrat.this.y = (height-length)/2;
				}
			
				Quadrat.this.canvas.repaint();
			}
			
		});
        
        south.add(neu);
        south.add(fill);
        return south;
    }


    public static void main(String[] args) 
    {
        new Quadrat();
    }


    
    
    
    
    
    
    
    
    
    
 //MouseMotionListener
    
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		int x1 = Quadrat.this.lastpoint.x;
		int y1 = Quadrat.this.lastpoint.y;
		
		int x2 = e.getX();
		int y2 = e.getY();
		
		int diffx = x1 - x2;
		int diffy = y1 - y2;
		
		
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
		
		int x = e.getX();
		int y = e.getY();
	
		int xr = Quadrat.this.x;
		int yr = Quadrat.this.y;
		int length = Quadrat.this.length;
		
		if(x >= xr && x <= (xr + length))
		{
			Quadrat.this.obereKgetroffen = true;
			System.out.println("getroffen = " + Quadrat.this.obereKgetroffen);
			Quadrat.this.lastpoint = e.getPoint();
			
		} else if(y >= yr && y <= (yr + length))
		{
			Quadrat.this.obereKgetroffen = true;
			System.out.println("getroffen = " + Quadrat.this.obereKgetroffen);
			Quadrat.this.lastpoint = e.getPoint();
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) 
	{
		Quadrat.this.obereKgetroffen = false;
		Quadrat.this.untereKgetroffen = false;
		Quadrat.this.lastpoint = null;		
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
