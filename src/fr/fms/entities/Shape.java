package fr.fms.entities;

import java.awt.Graphics;

public abstract class Shape {
	private Point center;

	public Shape(int x, int y) {
		this.center = new Point(x, y);
	}

	public Shape(Point center) {
		this.center = center;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public abstract void draw(Graphics g);

	public abstract double area();
}
