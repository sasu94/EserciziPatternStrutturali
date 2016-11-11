package provaAdapter;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;

public class Test extends JFrame {
	JPanel p;
	JButton b;
	JFileChooser f;
	Adapter a;
	JTree t;

	public Test() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(500, 500));
		p.setLayout(null);
		b = new JButton("scegli un\n xml");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f = new JFileChooser();
				int r = f.showOpenDialog(p);
				if (r == JFileChooser.APPROVE_OPTION) {
					a = new Adapter(f.getSelectedFile());

					t = a.drawTree();
					t.setBounds(10, 70, 150, 250);
					p.add(t);
					p.revalidate();
					p.repaint();
				}

			}
		});

		b.setBounds(10, 10, 150, 50);
		p.add(b);

		setContentPane(p);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		Test t = new Test();
	}
}
