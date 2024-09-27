package fr.fms.entities;

import java.awt.Graphics;

public class Square extends Shape {
	private double side;

	public Square(double side) {
		super(new Point(0, 0));
		this.setSide(side);
	}

	public Square(double side, int x, int y) {
		super(new Point(x, y));
		this.setSide(side);
	}

	public Square(double side, Point center) {
		super(center);
		this.setSide(side);
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public void draw(Graphics g) {
		g.drawRect(this.getCenter().getX(), this.getCenter().getY(), (int) ((Square) this).getSide(),
				(int) ((Square) this).getSide());
	}

	public double area() {
		return this.getSide() * this.getSide();
	}
}
