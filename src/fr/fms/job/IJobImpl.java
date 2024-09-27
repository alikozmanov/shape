package fr.fms.job;

import fr.fms.entities.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class IJobImpl implements IJob {
	public Map<Integer, Shape> shapes = new HashMap<Integer, Shape>();

	public IJobImpl() {
		shapes = new HashMap<>();
	}

	public void addShape(int id, Shape shape) {
		shapes.put(id, shape);
	}

	public void deleteShape(int id) {
		shapes.remove(id);
	}

	public Shape getShapeById(int id) {
		return shapes.get(id);
	}

	public void moveShape(int id, int x, int y) {
		Shape shape = shapes.get(id);
		shape.getCenter().setX(x);
		shape.getCenter().setY(y);
	}

	public void drawShapes(Graphics g) {
		this.shapes.forEach((id, shape) -> shape.draw(g));
	}
}
