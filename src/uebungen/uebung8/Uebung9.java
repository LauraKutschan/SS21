package uebungen.uebung8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Uebung9 extends JFrame implements ActionListener {

	JTextField input;
	JButton add;
	JButton remove;
	JPanel unten;
	List<JLabel> labels;
	
	public Uebung9()
	{
		super("Elemente hinzufügen");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 100);
		
		JPanel oben = new JPanel();
		oben.setBackground(Color.YELLOW);
		this.getContentPane().add(oben, BorderLayout.NORTH);
	
		//Textfeld
		this.input = new JTextField(10);
	
		//OBEN
		// add-Button
		this.add = new JButton("Hinzufuegen");
		this.add.addActionListener(this);
		
		// remove-Button
		this.remove = new JButton("loeschen");
		this.remove.addActionListener(this);
		
		
		oben.add(this.input);
		oben.add(this.add);
		oben.add(this.remove);
		
		
		
		//UNTEN
		unten = new JPanel();
		unten.setBackground(Color.CYAN);
		this.getContentPane().add(unten, BorderLayout.CENTER);
		
		
		//labels
		this.labels = new ArrayList<>();
		
		
		//letzter Schritt
		this.setVisible(true);
	}

	public JPanel createOben()
	{
		JPanel panel = new JPanel();
		return panel;
	}
	
	public static void main(String[] args) 
	{
		new Uebung9();
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object quelle = e.getSource();
		if(quelle instanceof JButton)
		{
			JButton quelleButton = (JButton) quelle;
			if(quelleButton.equals(this.add))
			{	
				String s = this.input.getText();
				JLabel j = new JLabel(s);
				j.setOpaque(true);
				j.setBackground(Color.RED);
				this.labels.add(j);

				this.unten.add(j);
				
				
				
			}
			else if(quelleButton.equals(this.remove))
			{
				String s = this.input.getText();
				
				for(JLabel l : this.labels)
				{
					if(l.getText().equals(s))
					{
						this.unten.remove(l);
						this.labels.remove(l);
						
					}
				}
				
			}
			
			this.input.setText("");			//Eingabefeld automatisch leeren für neue Eingabe
			this.input.requestFocus();		//Cursor automatisch auf Eingabefeld legen
			this.unten.revalidate();
			this.unten.repaint();
		}
	}
}
