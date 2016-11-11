package provaFlyweight;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2743574149855089215L;
	private JPanel p;
	JButton plsBall, plsStar;
	ImageIcon star, ball, tree;
	Image current;
	ImagePool imgPool;
	HashMap<String, Image> images;

	public MainFrame() throws IOException {
		p = new JPanel();
		p.setPreferredSize(new Dimension(432, 475));
		p.setLayout(null);
		setContentPane(p);

		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				images.put(x + " " + y, current);
				repaint();
			}
		});

		images = new HashMap<String, Image>();
		imgPool = new ImagePool();

		star = ((Star) imgPool.getGraphic("star")).getImage();
		ball = ((ChristmasBall) imgPool.getGraphic("ball")).getImage();
		tree = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("Albero.png")));

		JLabel l = new JLabel(tree);
		l.setBounds(100, 10, 322, 436);
		add(l);

		plsBall = new JButton(ball);
		plsBall.setBounds(10, 10, 50, 50);
		plsBall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				current = ball.getImage();
			}

		});
		add(plsBall);

		plsStar = new JButton(star);
		plsStar.setBounds(10, 70, 50, 50);
		plsStar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				current = star.getImage();
			}
		});
		add(plsStar);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		for (String s : images.keySet()) {
			String[] coord = s.split(" ");
			int x = Integer.parseInt(coord[0]), y = Integer.parseInt(coord[1]);
			Image img = images.get(s);
			System.out.println(img);
			g.drawImage(img, x - 17, y + 20, 50, 50, this);
		}

	}

	public static void main(String[] args) {
		try {
			MainFrame m = new MainFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
