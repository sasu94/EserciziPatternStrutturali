package provaDecorator;

import java.awt.Color;
import java.awt.Graphics;

public class BlueShape implements Shape {
	Shape s;

	public BlueShape(Shape s) {
		this.s = s;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		s.draw(g);
	}

}
