package fr.fms.entities;

import java.awt.Graphics;

public class Circle extends Shape {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(double radius) {
		this(radius, new Point(0, 0));
	}

	public Circle(double radius, int x, int y) {
		this(radius, new Point(x, y));
	}

	public Circle(double radius, Point center) {
		super(center);
		this.setRadius(radius);
	}

	public Circle() {
		super(1, 1);
		setRadius(1);
	}

	public void draw(Graphics g) {
		g.fillOval(this.getCenter().getX(), this.getCenter().getY(), 2 * (int) ((Circle) this).getRadius(),
				2 * (int) ((Circle) this).getRadius());
	}

	public double area() {
		return Math.PI * 2 * getRadius();
	}
}
