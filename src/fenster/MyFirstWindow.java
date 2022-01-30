package fenster;

import java.awt.*;

import javax.swing.*;

public class MyFirstWindow extends JFrame {

	public MyFirstWindow()
	{
		super(); // Konstruktor von JFrame --> macht er eigentlich allein, kann man auch weglassen
		this.setTitle("My first window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// neue obere Schicht 
		JPanel content = this.initContent();
		this.getContentPane().add(content);
		
		// Hintergrundfarben festlegen
		this.setBackground(Color.MAGENTA);
		//this.getContentPane().setBackground(Color.MAGENTA);
		
		// Eigenschaften festlegen
		this.setSize(400, 300);
		this.setLocation(400, 400);
		this.setVisible(true);
	

	}
	

	/*
	 * FlowLayout = Standard - alles nebeneinander, so lange es passt
	 * GridLayout - Gitterstruktur in Zeilen und Spalten
	 * BorderLayout - Norden, Sueden, Osten, Westen, Center
	 */
	
	
	private JPanel initContent() 
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 2));

		JButton b1 = new JButton("EAST");
		JButton b2 = new JButton("WEST");
		JButton b3 = new JButton("SOUTH");
		JButton b4 = new JButton("NORTH");
		JButton b5 = new JButton("CENTER");
		
		mainPanel.add(b1);
		mainPanel.add(b2);
		mainPanel.add(b3);
		mainPanel.add(b4);
		mainPanel.add(b5);
		
		/*mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40)); //Linksbündig und Abstände zwischen Button
		
		JButton b1 = new JButton("EAST");
		JButton b2 = new JButton("WEST");
		JButton b3 = new JButton("SOUTH");
		JButton b4 = new JButton("NORTH");
		JButton b5 = new JButton("CENTER");
		
		mainPanel.add(b1);
		mainPanel.add(b2);
		mainPanel.add(b3);
		mainPanel.add(b4);
		mainPanel.add(b5);

		mainPanel.setLayout(new BorderLayout());
		
		JButton b1 = new JButton("EAST");
		JButton b2 = new JButton("WEST");
		JButton b3 = new JButton("SOUTH");
		JButton b4 = new JButton("NORTH");
		JButton b5 = new JButton("CENTER");
		
		
		mainPanel.add(b1, BorderLayout.EAST);
		mainPanel.add(b2, BorderLayout.WEST);
		mainPanel.add(b3, BorderLayout.SOUTH);
		mainPanel.add(b4, BorderLayout.NORTH);
		mainPanel.add(b5, BorderLayout.CENTER);

		
		// hier weitere Container oder Steuerelemente hinzufuegen
		
		JLabel label = new JLabel("Name  : ");
		JTextField input = new JTextField(10);
		JButton button = new JButton("Klick mich");
		JCheckBox cb = new JCheckBox();
		JRadioButton rb = new JRadioButton();
		
		mainPanel.add(label);
		mainPanel.add(input);
		mainPanel.add(button);
		mainPanel.add(cb);
		mainPanel.add(rb);
		 */
		
		return mainPanel;
	}
	

}
