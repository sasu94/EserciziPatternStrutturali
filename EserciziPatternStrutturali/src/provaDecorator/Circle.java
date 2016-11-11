package provaDecorator;

import java.awt.Graphics;

public class Circle implements Shape {

	@Override
	public void draw(Graphics g) {
		g.fillOval(275, 95, 100, 100);
	}

}
