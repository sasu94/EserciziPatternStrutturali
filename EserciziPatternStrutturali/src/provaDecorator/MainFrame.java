package provaDecorator;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8644230124889216855L;
	private JPanel p;
	JButton plsRRed, plsRBlue, plsCRed, plsCBlue;

	public MainFrame() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(650, 250));
		p.setLayout(null);
		setContentPane(p);

		plsRRed = new JButton("Rettangolo Rosso");
		plsRRed.setBounds(10, 10, 150, 20);
		plsRRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				draw(new RedShape(new Rectangle()));
			}
		});
		add(plsRRed);

		plsRBlue = new JButton("Rettangolo Blu");
		plsRBlue.setBounds(170, 10, 150, 20);
		plsRBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				draw(new BlueShape(new Rectangle()));
			}
		});
		add(plsRBlue);

		plsCRed = new JButton("Cerchio Rosso");
		plsCRed.setBounds(330, 10, 150, 20);
		plsCRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				draw(new RedShape(new Circle()));
			}

		});
		add(plsCRed);

		plsCBlue = new JButton("Cerchio Blu");
		plsCBlue.setBounds(490, 10, 150, 20);
		plsCBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				draw(new BlueShape(new Circle()));
			}
		});
		add(plsCBlue);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void draw(Shape s) {
		getGraphics().clearRect(0, 70, p.getWidth(), p.getHeight());
		s.draw(getGraphics());
	}

	public static void main(String[] args) {
		MainFrame m = new MainFrame();
	}

}
