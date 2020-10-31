package Interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	int width, height;
	
	JButton play = new JButton("play");
	JButton settings = new JButton("settings");
	JButton mainMenu = new JButton("main menu");
	
	CardLayout layout = new CardLayout();
	
	JPanel panel = new JPanel();
	JPanel game = new JPanel();
	JPanel menu = new JPanel(); 

	public Screen(int width, int height) {
	   this.width = width;
	   this.height = height;
	
	   panel.setLayout(layout);        
	   addButtons();
	
	   setSize(width, height);
	   setResizable(false);
	   setLocationRelativeTo(null);
	   setVisible(true);
	   setTitle("BUILD YOUR EMPIRE");
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   requestFocus();
	
	}
	
	private void addButtons() {
	
	   play.addActionListener(this);
	   settings.addActionListener(this);
	   mainMenu.addActionListener(this);
	
	   //menu buttons
	   menu.add(play);
	   menu.add(settings);
	
	   //game buttons
	   game.add(mainMenu);
	
	   //background colors
	   game.setBackground(Color.MAGENTA);
	   menu.setBackground(Color.GREEN);
	
	   //adding children to parent Panel
	   panel.add(menu,"Menu");
	   panel.add(game,"Game");
	
	   add(panel);
	   layout.show(panel,"Menu");
	
	}
	
	public void actionPerformed(ActionEvent event) {
	
	   Object source = event.getSource();
	
	   if (source == play) {
	       layout.show(panel, "Game");
	   } else if (source == settings){
	
	   } else if (source == mainMenu){
	       layout.show(panel, "Menu");
	   }
	
	   }
	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
		
	}
}