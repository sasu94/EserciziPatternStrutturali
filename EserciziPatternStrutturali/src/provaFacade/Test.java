package provaFacade;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Builder;

public class Test extends JFrame {
	private JPanel p;
	JButton plsChooseFile, plsTextPlain, plsRichText;
	JFileChooser f;
	String file;
	XmlBuilderFacade fac;

	public Test() {
		p = new JPanel();
		p.setPreferredSize(new Dimension(170, 100));
		p.setLayout(null);
		setContentPane(p);
		fac = new XmlBuilderFacade();

		plsChooseFile = new JButton("scegli un xml");
		plsChooseFile.setBounds(10, 10, 150, 20);
		plsChooseFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				f = new JFileChooser();
				if (f.showOpenDialog(p) == JFileChooser.APPROVE_OPTION)
					file = f.getSelectedFile().toString();
			}
		});
		p.add(plsChooseFile);

		plsTextPlain = new JButton("PlainText");
		plsTextPlain.setBounds(10, 40, 150, 20);
		plsTextPlain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				action(plsTextPlain.getText());

			}

		});
		p.add(plsTextPlain);

		plsRichText = new JButton("RTF");
		plsRichText.setBounds(10, 70, 150, 20);
		plsRichText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				action(plsRichText.getText());

			}

		});
		p.add(plsRichText);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void action(String builder) {
		try {
			fac.convertXml(file, (Builder) Class.forName("main." + builder + "Builder").newInstance());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(p, "Convertito");
	}

	public static void main(String[] args) {
		Test t = new Test();
	}

}
