package provaDecorator;

import java.awt.Color;
import java.awt.Graphics;

public class RedShape implements Shape {
	Shape s;

	public RedShape(Shape s) {
		this.s = s;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		s.draw(g);
	}

}
