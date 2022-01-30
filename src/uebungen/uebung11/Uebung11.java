package uebungen.uebung11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Uebung11 extends JFrame{

	JPanel content;
	MyPanel[][] panels;
	
	public Uebung11(int hoehe, int breite)
	{
		super();
		this.setTitle("klicks zaehlen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.content = this.initCenter(hoehe, breite);
		this.getContentPane().add(this.content, BorderLayout.CENTER);

		this.getContentPane().add(this.initSouth(), BorderLayout.SOUTH);
		
		
		this.setSize(500, 500);
		this.setLocation(200, 100);
		this.setVisible(true);
	}

	private JPanel initCenter(int hoehe, int breite) 
	{
		JPanel center = new JPanel();
		center.setBackground(Color.BLACK);
		center.setLayout(new GridLayout(hoehe, breite, 2, 2));
		
		this.panels = new MyPanel[hoehe][breite];
		for(int row = 0; row < hoehe; row++)
		{
			for(int col = 0; col < breite; col++)
			{
				panels[row][col] = new MyPanel();
				panels[row][col].setBackground(Color.LIGHT_GRAY);
				center.add(panels[row][col]);
			}
		}
		return center;
	}

	class MyPanel extends JPanel implements MouseListener
	{
		int nrOfClicks;
		JLabel label;
		
		MyPanel()
		{
			this.nrOfClicks = 0;
			this.setLayout(new GridLayout(1, 1));

			this.label = new JLabel("0");
			this.label.setFont(new Font("Verdana", Font.BOLD, 60));
			this.label.setForeground(Color.WHITE);
			this.label.setHorizontalAlignment(JLabel.CENTER);
			this.add(label);
			
			this.addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			MyPanel mp = (MyPanel) e.getSource();
			mp.nrOfClicks++;
			mp.label.setText(String.valueOf(nrOfClicks));
			
			int meistenKlicks = 0;
			for(int zeile = 0; zeile < Uebung11.this.panels.length; zeile++ )
			{
				for(int spalte = 0; spalte < Uebung11.this.panels[zeile].length; spalte++)
				{
					if(Uebung11.this.panels[zeile][spalte].nrOfClicks > meistenKlicks)
					{
						meistenKlicks = Uebung11.this.panels[zeile][spalte].nrOfClicks;
					}
				}
			}
			
			for(int zeile = 0; zeile < Uebung11.this.panels.length; zeile++ )
			{
				for(int spalte = 0; spalte < Uebung11.this.panels[zeile].length; spalte++)
				{
					if(Uebung11.this.panels[zeile][spalte].nrOfClicks == meistenKlicks)
					{
						Uebung11.this.panels[zeile][spalte].setBackground(Color.RED);
					}
					else
					{
						Uebung11.this.panels[zeile][spalte].setBackground(Color.LIGHT_GRAY);
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
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
	}
	
	private JPanel initSouth() 
	{
		JPanel south = new JPanel();
		JButton reset = new JButton("reset");
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				for(int zeile = 0; zeile < Uebung11.this.panels.length; zeile++ )
				{
					for(int spalte = 0; spalte < Uebung11.this.panels[zeile].length; spalte++)
					{
						Uebung11.this.panels[zeile][spalte].nrOfClicks = 0;
						Uebung11.this.panels[zeile][spalte].label.setText("0");
						Uebung11.this.panels[zeile][spalte].setBackground(Color.LIGHT_GRAY);
					}
				}
			}
			
		});
		
		south.add(reset);
		return south;
	}
	
	public static void main(String[] args) {
		new Uebung11(4, 3);
	}
	
	
}
