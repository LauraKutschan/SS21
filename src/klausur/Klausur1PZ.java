package klausur;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Klausur1PZ extends JFrame{
    
	private Canvas canvas;
	private JLabel l;
	private JButton b;
	private Figure rect;
	private Figure circle;
	private boolean clicked = false;
	private int x;
	private int y;
	private int length;
	
    public Klausur1PZ()
    {
        super();
        this.setTitle("Klausur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.canvas = new Canvas();
        this.getContentPane().add(this.canvas, BorderLayout.CENTER);

        // von den folgenden vier Zeilen werden eventuell eine oder mehrere oder alle auskommentiert
        this.getContentPane().add(this.initNorth(), BorderLayout.NORTH);
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
 

        this.setSize(400, 300);
        this.setLocation(300,200);
        this.setVisible(true);
    }

    private class Canvas extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        
            Graphics2D g2 = (Graphics2D)g;  
            
        	g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(2.0f));  
			
            if(this.getHeight() < this.getWidth())
			{
            	Klausur1PZ.this.l.setText("breiter: (" + this.getHeight() + ", " + this.getWidth() + ") ");
				g2.drawLine(0, (this.getHeight()/2), this.getWidth(), (this.getHeight()/2));
				
				Klausur1PZ.this.x = this.getHeight();
				Klausur1PZ.this.y = this.getHeight();
				
			}
			else
			{
				Klausur1PZ.this.l.setText("hoeher: (" + this.getHeight() + ", " + this.getWidth() + ") ");
				g2.drawLine((this.getWidth()/2), 0, (this.getWidth()/2), this.getHeight());
				
			}	
            
            if(clicked == true)
            {
            	g2.setColor(Color.YELLOW);
            	g2.fillRect(Klausur1PZ.this.rect.getX(), Klausur1PZ.this.rect.getY(), Klausur1PZ.this.rect.getLength(), Klausur1PZ.this.rect.getLength());
			
            	g2.setColor(Color.GREEN);
            	g2.fillOval(Klausur1PZ.this.circle.getX(), Klausur1PZ.this.circle.getY(), Klausur1PZ.this.circle.getLength(), Klausur1PZ.this.circle.getLength());
            }
		}
    }

    private JPanel initNorth() 
    {
        JPanel north = new JPanel();
        north.setBackground(Color.LIGHT_GRAY);
        
        this.l = new JLabel();
        north.add(l);
        
        return north;
    }

    private JPanel initSouth() 
    {
        JPanel south = new JPanel();
        south.setBackground(Color.LIGHT_GRAY);
        this.b = new JButton("new");
        this.b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Klausur1PZ.this.clicked = true;
				Klausur1PZ.this.canvas = new Canvas();
				
				System.out.println("hallo");
				if(Klausur1PZ.this.canvas.getHeight() < Klausur1PZ.this.canvas.getWidth())
				{
					Klausur1PZ.this.rect = new Figure(40, 40, Klausur1PZ.this.canvas.getWidth()/2);
					Klausur1PZ.this.circle = new Figure(80, 40, Klausur1PZ.this.canvas.getWidth()/2);
				}
				else
				{
					Klausur1PZ.this.rect = new Figure(40, 40, Klausur1PZ.this.canvas.getHeight()/2);
					Klausur1PZ.this.circle = new Figure(80, 40, Klausur1PZ.this.canvas.getHeight()/2);
				}
			}
		});
      
        south.add(b);
        
        return south;
    }


    public static void main(String[] args) 
    {
        new Klausur1PZ();
    }

}
