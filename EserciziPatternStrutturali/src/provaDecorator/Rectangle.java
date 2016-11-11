package provaDecorator;

import java.awt.Graphics;

public class Rectangle implements Shape {

	@Override
	public void draw(Graphics g) {
		g.fillRect(280, 140, 100, 50);

	}

}
