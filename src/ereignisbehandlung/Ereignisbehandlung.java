package ereignisbehandlung;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Ereignisbehandlung extends JFrame {

	private Integer anzKlicks = 0;
	private JLabel unten;
	
	public Ereignisbehandlung()
	{
		super();
		this.setTitle("Ereignisbehandlung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = this.initContent();
		this.getContentPane().add(content);
		this.setSize(200, 150);
		this.setLocation(200, 100);
		this.setVisible(true);
		
	}
	
	public JPanel initContent()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel oben = new JPanel();
		
		//Button
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		
		
		// ActionListener direkt in den () Klammern implementiert 
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Ereignisbehandlung.this.anzKlicks++;					
				Ereignisbehandlung.this.unten.setText(Ereignisbehandlung.this.anzKlicks.toString());
				System.out.println("Plus-Button geklickt... " + Ereignisbehandlung.this.anzKlicks);
			}
		});
		
		
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Ereignisbehandlung.this.anzKlicks--;					
				Ereignisbehandlung.this.unten.setText(Ereignisbehandlung.this.anzKlicks.toString());
				System.out.println("Minus-Button geklickt... " + Ereignisbehandlung.this.anzKlicks);
			}
		});
		
		
		oben.add(plus);
		oben.add(minus);

		
		//Label
		this.unten = new JLabel(this.anzKlicks.toString());
		this.unten.setFont(new Font("Verdana", Font.BOLD, 24));
		this.unten.setHorizontalAlignment(JLabel.CENTER);			//zentrieren (linksbündig ist Standard)
		
		
		mainPanel.add(oben, BorderLayout.NORTH);
		mainPanel.add(unten, BorderLayout.CENTER);
		
		
		
		return mainPanel;
	}
	
	
	/*public class ActionHandler implements ActionListener {			//innere Klasse 

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Object quelle = e.getSource();
			if(quelle instanceof JButton)
			{
				JButton button = (JButton) quelle;
				if(button.getText().equals("-"))
				{
					Ereignisbehandlung.this.anzKlicks--;
					System.out.println("Minus-Button geklickt... " + Ereignisbehandlung.this.anzKlicks);
				}
				else if(button.getText().equals("+"))
				{
					Ereignisbehandlung.this.anzKlicks++;
					System.out.println("Plus-Button geklickt... " + Ereignisbehandlung.this.anzKlicks);
				}
				Ereignisbehandlung.this.unten.setText(anzKlicks.toString());
			}
		}
		
	}*/
	
	
	public static void main(String[] args) 
	{
		new Ereignisbehandlung();
	}

}
