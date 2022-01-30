package klausurvorbereitung2;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Schachbrett extends JFrame implements MouseListener{
    Canvas canvas;
    enum State {MARKIERT, UNMARKIERT, GREEN};
    State[][] field;
    
    public Schachbrett()
    {
        super();
        this.setTitle("Schachbrett");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

        this.initField();
        
        this.canvas = new Canvas();
        this.canvas.addMouseListener(this);
        this.getContentPane().add(this.canvas, BorderLayout.CENTER);

        // von den folgenden vier Zeilen werden eventuell eine oder mehrere oder alle auskommentiert
        this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
        

        this.setSize(400, 400);
        this.setLocation(300,200);
        this.setVisible(true);
    }
    
    private void initField() 
    {
        this.field = new State[8][8];
        for(int row=0; row<this.field.length; row++)
        {
            for(int col=0; col<this.field[row].length; col++)
            {
                this.field[row][col] = State.UNMARKIERT;
            }
        }
    }
    
    private class Canvas extends JPanel
    {
    	 int heightRect = 0;
         int widthRect = 0;
         
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);        // Implementierung von JPanel aufrufen
            Graphics2D g2 = (Graphics2D)g;  // Methoden von Graphics2D nutzbar
            // hier koennen wir zeichnen
            
            widthRect = Schachbrett.this.canvas.getWidth()/8;
            heightRect = Schachbrett.this.canvas.getHeight()/8;
            
            boolean grey = true;
            for(int row=0; row<Schachbrett.this.field.length; row++)
            {
            	 int y = row * this.heightRect;       // y-Wert des linken oberen Punktes
                 grey = !grey;                   // mit gleichen Farbe anfangen, wie aufgehoert
                 for(int col=0; col<Schachbrett.this.field[row].length; col++)
                 {
                     int x = col * this.widthRect;    // x-Wert des linken oberen Punktes

                     if(grey) 
                     {
                         g2.setColor(Color.LIGHT_GRAY);
                         grey = false;
                         
                     } else 
                     {
                         g2.setColor(Color.WHITE);
                         grey = true;
                     }
                     
                     if(Schachbrett.this.field[row][col] == State.GREEN)
                     {
                         g2.setColor(Color.GREEN);
                         Schachbrett.this.field[row][col] = State.UNMARKIERT;
                     }

                     g2.fillRect(x, y, widthRect, heightRect);
                  
                 }
               
       
                 for(int row1=0; row1<Schachbrett.this.field.length; row1++)
                 {
                     int y1 = row1 * this.heightRect;      
                     for(int col=0; col<Schachbrett.this.field[row1].length; col++)
                     {
                         int x1 = col * this.widthRect;   

                         if(Schachbrett.this.field[row1][col] == State.MARKIERT)
                         {
                             int abstandX = this.widthRect / 3;
                             int abstandY = this.heightRect / 3;
                             int durchmesser = this.widthRect / 3;
                             g2.setColor(Color.RED);
                             g2.fillOval(x1+abstandX, y1+abstandY, durchmesser, durchmesser);

                             g2.setStroke(new BasicStroke(3.0f));
                             g2.drawLine((this.widthRect / 2), y1 + (this.heightRect / 2), Schachbrett.this.canvas.getWidth() - (this.widthRect / 2), y1 + (this.heightRect / 2));
                             g2.drawLine(x1+ (this.widthRect / 2), (this.heightRect / 2), x1 + (this.widthRect / 2), Schachbrett.this.canvas.getHeight() - (this.heightRect / 2));

                         }
                     }
                 }
            }
            
        }
    }

    private JPanel initSouth() 
    {
        JPanel south = new JPanel();
        JButton reset = new JButton("reset");
        reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("clicked");
				
				Schachbrett.this.initField();
				Schachbrett.this.repaint();
			}
		
        });
        
        south.add(reset);
        return south;
    }


    public static void main(String[] args) 
    {
        new Schachbrett();
    }

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		int x = e.getX();
		int y = e.getY();
		System.out.println("x: " + x + ", y: " + y);
		
		int spalte = x / this.canvas.widthRect;
        int zeile = y / this.canvas.heightRect;
        
        boolean bereitsMarkiert = false;
        if(Schachbrett.this.field[zeile][spalte] == State.MARKIERT)
        {
            bereitsMarkiert = true;
        }

        for(int row=0; row<Schachbrett.this.field.length  && !bereitsMarkiert; row++)
        {
            if(Schachbrett.this.field[row][spalte] == State.MARKIERT)
            {
                bereitsMarkiert = true;
            }
        }

        for(int col=0; col<Schachbrett.this.field[zeile].length && !bereitsMarkiert; col++)
        {       
            if(Schachbrett.this.field[zeile][col] == State.MARKIERT)
            {
                bereitsMarkiert = true;
            }
        }

        // Diagonalen
        for(int row=0; row<Schachbrett.this.field.length  && !bereitsMarkiert; row++)
        {
            for(int col=0; col<Schachbrett.this.field[row].length && !bereitsMarkiert; col++)
            {       
                if(!(col==spalte && row==zeile)) // nicht das Feld selbst betrachten
                {
                    if((Math.abs(col-spalte) == Math.abs(row-zeile)) && Schachbrett.this.field[row][col] == State.MARKIERT)
                    {
                        bereitsMarkiert = true;
                    }
                }
            }
        }
        
        if(!bereitsMarkiert)
        {
            this.field[zeile][spalte] = State.MARKIERT;
        }
        else 
        {
            this.field[zeile][spalte] = State.GREEN;
        }
        
        System.out.println("mouseClicked: [zeile = " + zeile + ", spalte = " + spalte + "]");
        this.canvas.repaint();
		
	}

	
	
	
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}   
