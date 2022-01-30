package klausurwdhlg;



import java.awt.BasicStroke;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Klausur extends JFrame implements MouseListener, MouseMotionListener{
	
	Canvas canvas;
	JLabel groesse;;
	boolean clicked;
	Figure rechteck;
	Figure kreis;
	Boolean circlemoved = false;
	Boolean squaremoved = false;
	Point lastpoint;
	Boolean fixed = false;
	
	public Klausur()
	{
	     super();
	     this.setTitle("Klausur");
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

	     this.canvas = new Canvas();
	     this.canvas.addMouseListener(this);
	     this.canvas.addMouseMotionListener(this);
	     this.getContentPane().add(this.canvas);
	     
	     JPanel north = this.initNorth();
	     this.getContentPane().add(north, BorderLayout.NORTH);

	     JPanel south = this.initSouth();
	     this.getContentPane().add(south, BorderLayout.SOUTH);
	     
	     this.clicked = false;
	     
	     this.setSize(400, 300);
	     this.setLocation(300,200);
	     this.setVisible(true);
	 }

	
	public JPanel initNorth()
	{
		JPanel oben = new JPanel();
		oben.setBackground(Color.LIGHT_GRAY);
		this.groesse = new JLabel();
		oben.add(groesse);
		
		return oben;
	}
	
	public JPanel initSouth()
	{
		JPanel unten = new JPanel();
		unten.setBackground(Color.LIGHT_GRAY);
		JButton reset = new JButton("new");
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Klausur.this.clicked = true;
				System.out.println("clicked = " + clicked);
				
				int width = Klausur.this.canvas.getWidth();
				int height = Klausur.this.canvas.getHeight();
				
				if(width < height)
				{
					int height2 = height/2;
                    int smallest = (height2 < width) ? height2 : width;
                    int length = (int)(smallest * 0.9);
                    int oben = (height2-length)/2;
                    int links = (width-length)/2;

					Klausur.this.rechteck = new Figure(links, oben, length);
					Klausur.this.kreis = new Figure(links, height2 + oben, length);
				}
				else	
				{
					int width2 = width/2;
	                int smallest = (width2 < height) ? width2 : height;
	                int length = (int)(smallest * 0.9);
	                int links = (width2-length)/2;
	                int oben = (height-length)/2;
					
					Klausur.this.rechteck = new Figure(links, oben, length);
					Klausur.this.kreis = new Figure(width2 + links, oben, length);
				}
				
				Klausur.this.canvas.repaint();
				
				Klausur.this.squaremoved = false;
				Klausur.this.circlemoved = false;
				Klausur.this.lastpoint = null;
				Klausur.this.fixed = false;
			}
		});
		
		
		unten.add(reset);

		return unten;
	}
	
	
	public class Canvas extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2.0f));
			
			if(this.getHeight() > this.getWidth())
			{
				Klausur.this.groesse.setFont(new Font("Verdana", Font.BOLD, 10));
				Klausur.this.groesse.setText("hoeher: (" + this.getHeight() + ", " + this.getWidth() + ")");
				g2.drawLine(0, (this.getHeight()/2), this.getWidth(), (this.getHeight()/2));
				
				if(Klausur.this.clicked == true)
				{			
					g2.setColor(Color.YELLOW);
					g2.fillRect(Klausur.this.rechteck.getX(), Klausur.this.rechteck.getY(), Klausur.this.rechteck.getLength(), Klausur.this.rechteck.getLength());
				
					g2.setColor(Color.GREEN);
					g2.fillOval(Klausur.this.kreis.getX(), Klausur.this.kreis.getY(), Klausur.this.kreis.getLength(), Klausur.this.kreis.getLength());
				}
			
			}
			else if(this.getHeight() <= this.getWidth())
			{
				Klausur.this.groesse.setFont(new Font("Verdana", Font.BOLD, 10));
				Klausur.this.groesse.setText("breiter: (" + this.getHeight() + ", " + this.getWidth() + ")");
				g2.drawLine((this.getWidth()/2), 0, (this.getWidth()/2), this.getHeight());
			
				if(Klausur.this.clicked == true)
				{			
					g2.setColor(Color.YELLOW);
					g2.fillRect(Klausur.this.rechteck.getX(), Klausur.this.rechteck.getY(), Klausur.this.rechteck.getLength(), Klausur.this.rechteck.getLength());
				
					g2.setColor(Color.GREEN);
					g2.fillOval(Klausur.this.kreis.getX(), Klausur.this.kreis.getY(), Klausur.this.kreis.getLength(), Klausur.this.kreis.getLength());
				}
			
			}
			
			if(Klausur.this.fixed)
			{
				Klausur.this.groesse.setFont(new Font("Verdana", Font.BOLD, 14));
				Klausur.this.groesse.setText("FIXED");
			}
			
		}
	}
	
	
	
//MouseListener
	
	

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(!Klausur.this.fixed)
		{
			int x = e.getX();
			int y = e.getY();
			
			int xc = Klausur.this.kreis.getX();
			int yc = Klausur.this.kreis.getY();
			
			int xs = Klausur.this.rechteck.getX();
			int ys = Klausur.this.rechteck.getY();
			
			int length = Klausur.this.rechteck.getLength();
			
			if(x >= xc && x <= (xc + length) && y >= yc && y <= (yc + length))
			{
				Klausur.this.circlemoved = true;
				Klausur.this.lastpoint = e.getPoint();
			}
			else if(x >= xs && x <= (xs + length) && y >= ys && y <= (ys + length))
			{
				Klausur.this.squaremoved = true;
				Klausur.this.lastpoint = e.getPoint();
	
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
			Klausur.this.circlemoved = false;
			Klausur.this.squaremoved = false;
			Klausur.this.lastpoint = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
//MouseMotionListener
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
		if(Klausur.this.circlemoved || Klausur.this.squaremoved && !Klausur.this.fixed)
		{
			int x = e.getX();
			int y = e.getY();
			
			int x1 = Klausur.this.lastpoint.x;
			int y1 = Klausur.this.lastpoint.y;
			
			int diffx = x - x1;
			int diffy = y - y1;
			
			if(Klausur.this.circlemoved)
			{
				int newx = Klausur.this.kreis.getX() + diffx;
				int newy = Klausur.this.kreis.getY() + diffy;
				
				Klausur.this.kreis.setX(newx);
				Klausur.this.kreis.setY(newy);
			}
			else if(Klausur.this.squaremoved)
			{
				int newx = Klausur.this.rechteck.getX() + diffx;
				int newy = Klausur.this.rechteck.getY() + diffy;
				
				Klausur.this.rechteck.setX(newx);
				Klausur.this.rechteck.setY(newy);
			}
		
			
			final int ABSTAND = 30;
			
			int xAbstand = Math.abs(Klausur.this.rechteck.getX() - Klausur.this.kreis.getX());
            int yAbstand = Math.abs(Klausur.this.rechteck.getY() - Klausur.this.kreis.getY());
            
			if(ABSTAND >= xAbstand && ABSTAND >= yAbstand)
			{
				if(Klausur.this.circlemoved)
				{
					Klausur.this.kreis.setX(Klausur.this.rechteck.getX());
					Klausur.this.kreis.setY(Klausur.this.rechteck.getY());
					
				}
				else if(Klausur.this.squaremoved)
				{
					Klausur.this.rechteck.setX(Klausur.this.kreis.getX());
					Klausur.this.rechteck.setY(Klausur.this.kreis.getY());
				}
				
				Klausur.this.fixed = true;
			}
			
		
			Klausur.this.canvas.repaint();
			Klausur.this.lastpoint = e.getPoint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) 
	{
		new Klausur();
	}
	

}
