package uebungen.uebung7;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GUIUebung extends JFrame {

    public GUIUebung()
    {
        super();	        // Konstruktor von JFrame --> macht er eigentlich allein, kann man auch weglassen

		this.setTitle("GUI Übung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// neue obere Schicht 
		JPanel content = this.initContent();
		this.getContentPane().add(content);
		
		// Hintergrundfarben festlegen
		//this.setBackground(Color.MAGENTA);
		//this.getContentPane().setBackground(Color.MAGENTA);
		
		// Eigenschaften festlegen
		this.setSize(400, 300);
		this.setLocation(400, 400);
		this.setVisible(true);
		
	
    }

    private JPanel initContent()
    {
    	JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(2, 1, 20, 20));

        Border border = BorderFactory.createLineBorder(Color.RED);


		// "Text"
		JLabel label1 = new JLabel("Text");
		label1.setForeground(Color.WHITE);
		topPanel.add(label1);
		topPanel.setBackground(Color.BLUE);
		topPanel.setBorder(border);
		
		topPanel.add(label1);

		
		
		// "weiterer Text"
		JLabel label2 = new JLabel("weiterer Text");
		leftPanel.add(label2);

		
		
		// input
		JTextField input = new JTextField("Feld", 10);
		leftPanel.add(input);

		
		
		// button1
		JButton button1 = new JButton("Button 1");
		rightPanel.add(button1);

		
		
		// button2
		JButton button2 = new JButton("Button 2");
		rightPanel.add(button2);

		
		
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(leftPanel, BorderLayout.CENTER);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		
		return mainPanel;
        //Ein paar Tipps:       
        //mehrere Panels verwenden
        //JTextField hat verschiedene Konstruktoren, nicht nur JTextField(int columns)
        //Rahmen können mit BorderFactory erzeugt werden
        //Beim FlowLayout ändert sich die Größe der Steuerelemente nicht,
        //bei GridLayout passt sich die Größe an den Container an

    }

    public static void main(String[] args) 
    {
        new GUIUebung();
    }
}
