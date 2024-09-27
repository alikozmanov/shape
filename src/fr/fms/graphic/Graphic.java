/**
 * Programme permettant l'affichage de plusieurs formes géométriques
 * 
 * @author El babili - 2023
 * 
 */
package fr.fms.graphic;

import fr.fms.entities.*;
import fr.fms.job.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Graphic extends JFrame  {
	
	
	private static final long serialVersionUID = 1L;
	public static IJobImpl job = new IJobImpl();
	
	public Graphic() {
		super("Voici nos formes géométriques !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton button = new JButton("Ajouter ");
		button.setSize(200,50);
		button.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.add(button);
		this.add(panel, BorderLayout.SOUTH);
		
		
		button.addActionListener(e -> {
			
			String [] options = {"Cercle", "Carré"};
			int inputUser = JOptionPane.showOptionDialog(this, "Choisissez une forme : ",
			                "Clique sur un bouton",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			
			String inputX = JOptionPane.showInputDialog(this, "Entre la position X");
			String inputY = JOptionPane.showInputDialog(this,"Entre la position Y");
			int x = Integer.parseInt(inputX);
			int y = Integer.parseInt(inputY);
			
			if(inputUser == 0) {
				String inputRadius = JOptionPane.showInputDialog(this,"Entre le rayon");
				int radius = Integer.parseInt(inputRadius);
				job.addShape(job.shapes.size(),new Circle(x,y,radius));

			} else {
				String inputWidth = JOptionPane.showInputDialog(this,"Entre la largeur");
				int width = Integer.parseInt(inputWidth);
				job.addShape(job.shapes.size(),new Square(x,y,width));				
			}
			
			repaint();
			
		});
		
		setVisible(true);
	}

	@Override // le repère commence en haut à gauche (0,0)
	public void paint(Graphics g) {
		super.paint(g);
		job.drawShapes(g);
		System.out.println("okay");
	}
	
	public static void main(String[] args) {
		job.addShape(0, new Circle(20, 30, 50));
		job.addShape(1, new Circle(15, new Point(100, 150)));
		job.addShape(2, new Circle(30, 300, 300));
		job.addShape(3, new Square(50, 200, 200));
		job.addShape(4, new Square(65, 200, 50));		
		
		new Graphic();		
	}


}
